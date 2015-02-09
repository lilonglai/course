package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kevin.aeas.object.Teacher;

public class DbTeacherOperation extends DbBaseOperation{
	public Teacher get(int key){
		String sql = "select * from aeas_teacher where id = " + key;
		Teacher teacher = null;
		List<Teacher> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacher = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teacher;		
	}
	
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
		String sql = "select * from aeas_teacher where name = '" + name + "'";
		Teacher teacher = null;
		List<Teacher> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacher = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return teacher;		
	}
	
	
	public Teacher getByShortName(String shortName){
		String sql = "select * from aeas_teacher where shortName = '" + shortName + "'";
		Teacher teacher = null;
		List<Teacher> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacher = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teacher;		
	}
	
	public List<Teacher> getAll(){
		String sql = "select * from aeas_teacher";
		List<Teacher> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	public List<Teacher> getAlive(){
		String sql = "select * from aeas_teacher" + " where isalive=true";
		List<Teacher> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	public List<Teacher> getNotAlive(){
		String sql = "select * from aeas_teacher" + " where isalive=false";
		List<Teacher> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getIdByObject(Teacher condition){
		String sql = "select * from aeas_teacher where";
		if(condition.getName() != null)
			sql += " name = '" + condition.getName() + "'";
		
		if(condition.getShortName() != null)			
			sql +=  " && shortname = '" + condition.getShortName() + "'";
		
		if(condition.getPhone() != null)
			sql +=  " && phone = '" + condition.getPhone() + "'";
		
		int id = 0;
		Teacher teacher = null;
		List<Teacher> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacher = list.get(0);
				id = teacher.getId();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
		
	}
	
	public void add(Teacher teacher){
		String sql = "insert into aeas_teacher(name,shortname,phone,ismaster) values("
				+ "'" +teacher.getName() +"',"
				+"'" +teacher.getShortName() +"',";
		if(teacher.getPhone() == null){
			sql += "'" + "" + "',";
		}
		else{
			sql += "'" +  teacher.getPhone() +"',";
		}
		
		sql += teacher.getIsMaster() +")";
		
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Teacher teacher){
		String sql = "update aeas_teacher set "
				+ "name=" + "'" + teacher.getName() +"',"
				+ "shortname=" +"'" +teacher.getShortName() +"',";
		if(teacher.getPhone() == null){
			sql += "phone=" + "'" + "',";
		}
		else{
			sql += "phone=" + "'" + teacher.getPhone() +"',";
		}
		
		sql += "ismaster=" + teacher.getIsMaster() +"";
		
		sql += " where id = " + teacher.getId();
		
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void delete(int key){
		String sql = "delete from aeas_teacher where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void retire(int key){
		String sql = "update aeas_teacher set isalive = false" + " where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
