package com.kevin.aeas.operation.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.utils.DatabaseHelp;

public class SecondCourseOperation {
	public SecondCourse get(int key){
		String sql = "select * from aeas_secondcourse where id = " + key;
		SecondCourse secondCourse = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				secondCourse = new SecondCourse();
				secondCourse.setId(rs.getInt("id"));
				secondCourse.setName(rs.getString("name"));
				secondCourse.setShortName(rs.getString("shortname"));
				secondCourse.setFirstCourseId(rs.getInt("firstcourseid"));
				secondCourse.setDescription(rs.getString("description"));				
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return secondCourse;
		
	}
	
	public ArrayList<SecondCourse> getByFirstCourseId(int firstCourseId){
		String sql = "select * from aeas_secondcourse where firstcourseid = " + firstCourseId;
		ArrayList<SecondCourse> list = new ArrayList<SecondCourse>();
		SecondCourse secondCourse = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				secondCourse = new SecondCourse();
				secondCourse.setId(rs.getInt("id"));
				secondCourse.setName(rs.getString("name"));
				secondCourse.setShortName(rs.getString("shortname"));
				secondCourse.setFirstCourseId(rs.getInt("firstcourseid"));
				secondCourse.setDescription(rs.getString("description"));
				list.add(secondCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public ArrayList<SecondCourse> getByGrade(int grade){
		String sql = "select aeas_secondcourse.* from aeas_firstcourse,aeas_secondcourse "
				+ "where aeas_firstcourse.id=aeas_secondcourse.firstcourseid and grade = " + grade
				+ " order by aeas_secondcourse.firstcourseid";
		ArrayList<SecondCourse> list = new ArrayList<SecondCourse>();
		SecondCourse secondCourse = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				secondCourse = new SecondCourse();
				secondCourse.setId(rs.getInt("id"));
				secondCourse.setName(rs.getString("name"));
				secondCourse.setShortName(rs.getString("shortname"));
				secondCourse.setFirstCourseId(rs.getInt("firstcourseid"));
				secondCourse.setDescription(rs.getString("description"));
				list.add(secondCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public ArrayList<SecondCourse> getAll(){
		String sql = "select * from aeas_secondcourse"
				+ " order by firstcourseid";
		ArrayList<SecondCourse> list = new ArrayList<SecondCourse>();
		SecondCourse secondCourse = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				secondCourse = new SecondCourse();
				secondCourse.setId(rs.getInt("id"));
				secondCourse.setName(rs.getString("name"));
				secondCourse.setShortName(rs.getString("shortname"));
				secondCourse.setFirstCourseId(rs.getInt("firstcourseid"));
				secondCourse.setDescription(rs.getString("description"));
				list.add(secondCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public int add(SecondCourse secondCourse){
		String sql = "insert into aeas_secondcourse(name,shortname,firstcourseid,description) values("
				+ "'" +secondCourse.getName() +"',";
		
		if(secondCourse.getShortName() == null){
			sql += "'" + "" + "',";
		}
		else{
			sql += "'" +  secondCourse.getShortName() +"',";
		}
		
		sql += secondCourse.getFirstCourseId() + ",";
				
		if(secondCourse.getDescription() == null){
			sql += "'" + "" + "')";
		}
		else{
			sql += "'" +  secondCourse.getDescription() +"')";
		}
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public int update(SecondCourse secondCourse){
		String sql = "update aeas_secondcourse set "
				+ "name=" + "'" + secondCourse.getName() +"',"
				+ "shortname=" +"'" +secondCourse.getShortName() +"',"
		        + "firstcourseid=" + secondCourse.getFirstCourseId() + ",";
		
		if(secondCourse.getDescription() == null){
			sql += "description=" + "'" + "'";
		}
		else{
			sql += "description=" + "'" + secondCourse.getDescription() +"'";
		}
		
		
		sql += " where id = " + secondCourse.getId();
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public int delete(int key){
		String sql = "delete from aeas_secondcourse where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		SecondCourseOperation operation = new SecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));
		
		
		
		
	}

}
