package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kevin.aeas.object.SecondCourse;

public class DbSecondCourseOperation extends DbBaseOperation{
	public SecondCourse get(int key){
		String sql = "select * from aeas_secondcourse where id = " + key;
		SecondCourse secondCourse = null;
		List<SecondCourse> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				secondCourse = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return secondCourse;		
	}
	
	protected SecondCourse generateObject(ResultSet rs) throws SQLException{
		SecondCourse secondCourse = new SecondCourse();
		secondCourse.setId(rs.getInt("id"));
		secondCourse.setName(rs.getString("name"));
		secondCourse.setShortName(rs.getString("shortname"));
		secondCourse.setFirstCourseId(rs.getInt("firstcourseid"));
		secondCourse.setDescription(rs.getString("description"));
		return secondCourse;
	}
	
	public List<SecondCourse> getByFirstCourseId(int firstCourseId){
		String sql = "select * from aeas_secondcourse where firstcourseid = " + firstCourseId;
		List<SecondCourse> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;		
	}
	
	public List<SecondCourse> getByGrade(int grade){
		String sql = "select aeas_secondcourse.* from aeas_firstcourse,aeas_secondcourse "
				+ "where aeas_firstcourse.id=aeas_secondcourse.firstcourseid and grade = " + grade
				+ " order by aeas_secondcourse.firstcourseid";
		List<SecondCourse> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;	
	}
	
	public List<SecondCourse> getAll(){
		String sql = "select * from aeas_secondcourse"
				+ " order by firstcourseid";
		List<SecondCourse> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;	
	}
	
	
	public void add(SecondCourse secondCourse){
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
		
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void update(SecondCourse secondCourse){
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
		
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(int key){
		String sql = "delete from aeas_secondcourse where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));		
	}

}
