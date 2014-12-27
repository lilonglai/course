package com.kevin.aeas.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.utils.DatabaseHelp;

public class TeacherOperation {
	public Teacher get(int key){
		String sql = "select * from aeas_teacher where id = " + key;
		Teacher teacher = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setShortName(rs.getString("shortname"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMaster(rs.getBoolean("ismaster"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacher;		
	}
	
	public Teacher getByName(String name){
		String sql = "select * from aeas_teacher where name = '" + name + "'";
		Teacher teacher = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setShortName(rs.getString("shortname"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMaster(rs.getBoolean("ismaster"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacher;		
	}
	
	
	public Teacher getByShortName(String shortName){
		String sql = "select * from aeas_teacher where shortName = '" + shortName + "'";
		Teacher teacher = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setShortName(rs.getString("shortname"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMaster(rs.getBoolean("ismaster"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacher;		
	}
	
	public ArrayList<Teacher> getAll(){
		String sql = "select * from aeas_teacher";
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setShortName(rs.getString("shortname"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMaster(rs.getBoolean("ismaster"));
				list.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public ArrayList<Teacher> getAlive(){
		String sql = "select * from aeas_teacher" + " where isalive=true";
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setShortName(rs.getString("shortname"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMaster(rs.getBoolean("ismaster"));
				list.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public ArrayList<Teacher> getNotAlive(){
		String sql = "select * from aeas_teacher" + " where isalive=false";
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setShortName(rs.getString("shortname"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMaster(rs.getBoolean("ismaster"));
				list.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				id = rs.getInt("id");			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	public int add(Teacher teacher){
		String sql = "insert into aeas_teacher(name,shortname,phone,ismaster) values("
				+ "'" +teacher.getName() +"',"
				+"'" +teacher.getShortName() +"',";
		if(teacher.getPhone() == null){
			sql += "'" + "" + "',";
		}
		else{
			sql += "'" +  teacher.getPhone() +"',";
		}
		
		sql += teacher.isMaster() +")";
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public int update(Teacher teacher){
		String sql = "update aeas_teacher set "
				+ "name=" + "'" + teacher.getName() +"',"
				+ "shortname=" +"'" +teacher.getShortName() +"',";
		if(teacher.getPhone() == null){
			sql += "phone=" + "'" + "',";
		}
		else{
			sql += "phone=" + "'" + teacher.getPhone() +"',";
		}
		
		sql += "ismaster=" + teacher.isMaster() +"";
		
		sql += " where id = " + teacher.getId();
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public int delete(int key){
		String sql = "delete from aeas_teacher where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int retire(int key){
		String sql = "update aeas_teacher set isalive = false" + " where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		TeacherOperation operation = new TeacherOperation();
		System.out.println(operation.getAll());
		
		operation.delete(6);
		
		
		
		
	}

}
