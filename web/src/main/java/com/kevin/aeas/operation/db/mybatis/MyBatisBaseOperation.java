package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.utils.C3Pool;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DbNoPool;
import com.kevin.aeas.utils.IGetConnection;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class MyBatisBaseOperation<T> {
    protected static SqlSessionFactory sqlSessionFactory;
    static{
        try{
            Reader reader    = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }



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
	public MyBatisBaseOperation() {

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

	protected  T generateObject(ResultSet rs) throws SQLException{

        return null;
    }

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

	protected  String getTableName(){
        return null;
    }
}
