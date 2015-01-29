package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.utils.DatabaseHelp;


public class DbFirstCourseOperation {
	public FirstCourse get(int key){
		String sql = "select * from aeas_firstcourse where id = " + key;
		FirstCourse firstCourse = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				firstCourse = generateFirstCourse(rs);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return firstCourse;
		
	}
	
	private FirstCourse generateFirstCourse(ResultSet rs) throws SQLException{
		FirstCourse firstCourse = new FirstCourse();
		firstCourse.setId(rs.getInt("id"));
		firstCourse.setGrade(rs.getInt("grade"));
		firstCourse.setName(rs.getString("name"));
		firstCourse.setShortName(rs.getString("shortname"));
		firstCourse.setDescription(rs.getString("description"));
		return firstCourse;
	}
	
	public ArrayList<FirstCourse> getByGrade(int grade){
		String sql = "select * from aeas_firstcourse where grade = " + grade;
		ArrayList<FirstCourse> list = new ArrayList<FirstCourse>();
		FirstCourse firstCourse = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				firstCourse = generateFirstCourse(rs);
				list.add(firstCourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public ArrayList<FirstCourse> getAll(){
		String sql = "select * from aeas_firstcourse";
		ArrayList<FirstCourse> list = new ArrayList<FirstCourse>();
		FirstCourse firstCourse = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				firstCourse = generateFirstCourse(rs);	
				list.add(firstCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public int add(FirstCourse firstCourse){
		String sql = "insert into aeas_firstcourse(grade,name,shortname,description) values("
				+ firstCourse.getGrade() +","
				+ "'" +firstCourse.getName() +"',"
				+"'" +firstCourse.getShortName() +"',";
		
		if(firstCourse.getDescription() == null){
			sql += "'" + "" + "')";
		}
		else{
			sql += "'" +  firstCourse.getDescription() +"')";
		}
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public void update(FirstCourse firstCourse){
		String sql = "update aeas_firstcourse set "
				+ "grade=" + firstCourse.getGrade() +","
				+ "name=" + "'" + firstCourse.getName() +"',"
				+ "shortname=" +"'" +firstCourse.getShortName() +"',";
		
		if(firstCourse.getDescription() == null){
			sql += "description=" + "'" + "'";
		}
		else{
			sql += "description=" + "'" + firstCourse.getDescription() +"'";
		}
		
		
		sql += " where id = " + firstCourse.getId();
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void delete(int key){
		String sql = "delete from aeas_firstcourse where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		DbFirstCourseOperation operation = new DbFirstCourseOperation();
		System.out.println(operation.getAll());		
	}

}
