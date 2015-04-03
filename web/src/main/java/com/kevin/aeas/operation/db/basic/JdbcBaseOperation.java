package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.utils.C3Pool;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DbNoPool;
import com.kevin.aeas.utils.IGetConnection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JdbcBaseOperation<T> {
	private static IGetConnection getCon = null;

	static {
		String usePoolString = ConfigurationManager.getInstance().getProperty(
				"usePool");
		boolean usePool = true;
		if (usePoolString != null) {
			usePool = Boolean.valueOf(usePoolString);
		}

		if (usePool) {
			getCon = new C3Pool();
		} else {
			getCon = new DbNoPool();
		}
	}
	public JdbcBaseOperation() {

	}

	protected Connection getConnection() throws SQLException {
		return getCon.getConnection();
	}

	protected void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	protected void closeStatement(Statement statement) throws SQLException {
		if (statement != null) {
			statement.close();
		}
	}

	protected void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

	protected abstract T generateObject(ResultSet rs) throws SQLException;

    protected  abstract String getTableName();

	protected List<T> executeSql(String sql) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<T> list = new ArrayList<T>();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				T t = generateObject(rs);
				list.add(t);
			}
		} finally {
			closeResultSet(rs);
			closeStatement(statement);
			closeConnection(connection);
		}
		return list;
	}

	protected void executeUpdateSql(String sql) throws SQLException {		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} finally {
			closeResultSet(rs);
			closeStatement(statement);
			closeConnection(connection);
		}
	}

    protected List<T> executeSql(String sql, Map map) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList<T> list = new ArrayList<T>();
        try {
            connection = getConnection();
            preparedStatement = createPrepareStatement(connection, sql, map);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                T t = generateObject(rs);
                list.add(t);
            }
        } finally {
            closeResultSet(rs);
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
        return list;
    }

    protected void executeUpdateSql(String sql, Map map) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            preparedStatement = createPrepareStatement(connection, sql, map);;
            preparedStatement.executeUpdate();
        } finally {
            closeResultSet(rs);
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    private int findNearestPosition(String from, String in, int startPos){
        int endPos = startPos;
        for(; endPos < from.length(); endPos++){
            for(int i = 0; i< in.length(); i++){
                if(from.charAt(endPos) == in.charAt(i))
                    return endPos;
            }
        }
        return endPos;
    }

    private PreparedStatement createPrepareStatement(Connection connection, String sql, Map map)
    throws SQLException{
        PreparedStatement preparedStatement;
        ArrayList<String> indexToName = new ArrayList<>();
        String nativeSql = "";
        int startPos = 0;
        int endPos = 0;
        startPos = sql.indexOf(":", startPos);

        while(startPos >= 0){
            nativeSql += sql.substring(endPos, startPos);
            endPos = findNearestPosition(sql, ", )", startPos);
            String namedParameter = sql.substring(startPos+1, endPos);
            indexToName.add(namedParameter);

            startPos = endPos;
            startPos = sql.indexOf(":", startPos);
            nativeSql += "?";
        }

        nativeSql += sql.substring(endPos);
        preparedStatement = connection.prepareStatement(nativeSql);

        for(int i = 0; i< indexToName.size(); i++){
            Object parameter = map.get(indexToName.get(i));
            if(parameter instanceof Byte){
                preparedStatement.setByte(i+1, (Byte)parameter);
            }else if(parameter instanceof Short){
                preparedStatement.setShort(i+1, (Short)parameter);
            }else if(parameter instanceof Integer){
                preparedStatement.setInt(i+1, (Integer)parameter);
            }else if(parameter instanceof Long){
                preparedStatement.setLong(i+1, (Long)parameter);
            }else if(parameter instanceof Float){
                preparedStatement.setFloat(i+1, (Float)parameter);
            }else if(parameter instanceof Double){
                preparedStatement.setDouble(i+1, (Double)parameter);
            }else if(parameter instanceof Boolean){
                preparedStatement.setBoolean(i+1, (Boolean)parameter);
            }else if(parameter instanceof String){
                preparedStatement.setString(i+1, (String)parameter);
            }else if(parameter instanceof Date){
                preparedStatement.setDate(i+1, (Date)parameter);
            }else if(parameter instanceof Time){
                preparedStatement.setTime(i+1, (Time)parameter);
            }else if(parameter instanceof Timestamp){
                preparedStatement.setTimestamp(i+1, (Timestamp)parameter);
            }else{
                preparedStatement.setNull(i+1, Types.NULL);
            }
        }
        return preparedStatement;
    }

    private String getMethodName(String fieldName){
        char[] items = fieldName.toCharArray();
        items[0] = (char)(items[0]-'a'+'A');
        return "get" + new String(items);
    }
    protected Map<String, Object> createMap(T obj) {
        Class objClass = obj.getClass();
        Field[]fields  = objClass.getFields();
        HashMap<String, Object> map = new HashMap<>();
        for (Field field: fields) {
            Method getMethod;
            try {
                getMethod = objClass.getMethod(getMethodName(field.getName()));
                map.put(field.getName(), getMethod.invoke(obj));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public T get(int key){
        String sql = "select * from " + getTableName() + " where id = :id";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", key);
        T obj = null;
        List<T> list;
        try {
            list = executeSql(sql, map);
            if(list.size() > 0){
                obj = list.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public List<T> getAll() {
        String sql = "select * from " + getTableName();
        List<T> list = null;
        try {
            list = executeSql(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void delete(int key) {
        String sql = "delete from " + getTableName() + " where id =:id";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", key);
        try {
            executeUpdateSql(sql, map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
