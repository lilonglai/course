package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.ISecondCourseOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcSecondCourseOperation extends JdbcBaseOperation<SecondCourse> implements ISecondCourseOperation{
	public SecondCourse get(int key){
		String sql = "select * from " + getTableName() + " where id = " + key;
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
	
	public List<? extends SecondCourse> getByFirstCourseId(int firstCourseId){
		String sql = "select * from " + getTableName() + " where firstcourseid = " + firstCourseId;
		List<SecondCourse> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;		
	}
	
	public List<? extends SecondCourse> getByGrade(int grade){
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
	
	public List<? extends SecondCourse> getAll(){
		String sql = "select * from " + getTableName() + ""
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
		String sql = "insert into " + getTableName() + "(name,shortname,firstcourseid,description) values("
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
		String sql = "update " + getTableName() + " set "
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
		String sql = "delete from " + getTableName() + " where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));		
	}

	@Override
	protected String getTableName() {
		return "aeas_secondcourse";
	}

}
