package com.kevin.course.operation.db.basic;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.ITeacherOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTeacherOperation extends JdbcBaseOperation<Teacher> implements ITeacherOperation {
	protected Teacher generateObject(ResultSet rs) throws SQLException{
		Teacher teacher = new Teacher();
		teacher.setId(rs.getInt("id"));
		teacher.setName(rs.getString("name"));
		teacher.setShortName(rs.getString("shortname"));
		teacher.setPhone(rs.getString("phone"));
		teacher.setIsMaster(rs.getBoolean("ismaster"));	
		return teacher;
	}
	
	public Teacher getByName(String name){
		String sql = "select * from " + getTableName() + " where name = :name";
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
		try {
            List<Teacher> list = executeSql(sql, map);
            return list.size() > 0? list.get(0): null;
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	
	public Teacher getByShortName(String shortName){
		String sql = "select * from " + getTableName() + " where shortName = :shortName";
        HashMap<String, Object> map = new HashMap<>();
        map.put("shortName", shortName);
		try {
            List<Teacher> list = executeSql(sql, map);
            return list.size() > 0? list.get(0): null;
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<Teacher> getAlive(){
		String sql = "select * from " + getTableName() + "" + " where isalive=true";
		try {
			return executeSql(sql);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<Teacher> getNotAlive(){
		String sql = "select * from " + getTableName() + "" + " where isalive=false";
		try {
			return executeSql(sql);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public Teacher getByCondition(Teacher condition){
		String sql = "select * from " + getTableName() + " where ";
        boolean andFlag = false;
		if(condition.getName() != null) {
            sql += "name = :name ";
            andFlag = true;
        }

		if(condition.getShortName() != null) {
            sql += andFlag? "and ":"";
            sql += "shortname=:shortName ";
            andFlag = true;
        }

		if(condition.getPhone() != null) {
            sql += andFlag? "and ":"";
            sql += "phone = :phone";
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", condition.getName());
        map.put("shortName", condition.getShortName());
        map.put("phone", condition.getPhone());

		try {
            List<Teacher> list = executeSql(sql, map);
            return list.size() > 0? list.get(0): null;
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void add(Teacher teacher){
		String sql = "insert into " + getTableName() + "(name,shortname,phone,ismaster) values("+
                ":name, :shortName, :phone, :isMaster)";
        Map<String, Object> map = createMap(teacher);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void update(Teacher teacher){
		String sql = "update " + getTableName() + " set name=:name, shortname=:shortName, phone=:phone, ismaster= :isMaster " +
                " where id = :id";
        Map<String, Object> map = createMap(teacher);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void retire(int key){
		String sql = "update " + getTableName() + " set isalive = false" + " where id = :id";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", key);
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "aeas_teacher";
	}
	

}
