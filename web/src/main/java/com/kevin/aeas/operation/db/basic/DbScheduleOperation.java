package com.kevin.aeas.operation.db.basic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kevin.aeas.object.Schedule;

public class DbScheduleOperation extends DbBaseOperation<Schedule>{
	public Schedule get(int key){
		String sql = "select * from aeas_schedule where id = " + key + " order by ondate,ontime";
		Schedule schedule = null;
		List<Schedule> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				schedule = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return schedule;		
	}
	
	protected Schedule generateObject(ResultSet rs) throws SQLException{
		Schedule schedule = new Schedule();
		schedule.setId(rs.getInt("id"));
		schedule.setOnDate(rs.getDate("ondate"));
		schedule.setOnTime(rs.getInt("ontime"));
		schedule.setStudentId(rs.getInt("id"));
		schedule.setCourseId(rs.getInt("courseid"));
		schedule.setTeacherId(rs.getInt("teacherid"));
		schedule.setAddition(rs.getString("addition"));
		schedule.setDescription(rs.getString("description"));	
		return schedule;
	}
	
	public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
		String sql = "select * from aeas_schedule where studentid = " + studentId 
				+" and onDate = '" + onDate + "'" + " and onTime=" + onTime;;
		Schedule schedule = null;
		List<Schedule> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				schedule = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return schedule;	
	}
	
	public List<Schedule> getByStudentId(int studentId){
		String sql = "select * from aeas_schedule where studentid = " + studentId + " order by ondate,ontime" ;
		List<Schedule> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
		String sql = "select * from aeas_schedule where teacherid = " + teacherId + " order by ondate,ontime";
		List<Schedule> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
		
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
		String sql = "select * from aeas_schedule where onDate = '" + onDate + "'";
		if(onTime >=1){
			sql += " and onTime=" + onTime;
		}
		sql += " order by ondate,ontime";
		
		List<Schedule> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public List<Schedule> getAll(){
		String sql = "select * from aeas_schedule" + " order by ondate,ontime";
		List<Schedule> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public void add(Schedule schedule){
		String sql = "insert into aeas_schedule(ondate,ontime,studentid,courseid,teacherid,addition,description) values(";
		if(schedule.getOnDate() == null){
			sql += "" + "NULL" + ",";
		}
		else{
			sql += "'" +  schedule.getOnDate() +"',";
		}
		
		sql +=	schedule.getOnTime() +",";
		sql +=	schedule.getStudentId() +",";
		sql +=	schedule.getCourseId() +",";
		sql +=	schedule.getTeacherId() +",";
		
		if(schedule.getAddition() == null){
			sql += "'" + "" + "',";
		}
		else{
			sql += "'" +  schedule.getAddition() +"',";
		}
		
		if(schedule.getDescription() == null){
			sql += "'" + "" + "')";
		}
		else{
			sql += "'" +  schedule.getDescription() +"')";
		}
		
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Schedule schedule){
		String sql = "update aeas_schedule set ";
		if(schedule.getOnDate() == null){
			sql += "ondate=" + "" + "NULL" + ",";
		}else{
			sql += "ondate=" + "'" + schedule.getOnDate() +"',";
		}
		
		sql += "ontime=" + schedule.getOnTime() + ",";
		sql += "studentid=" + schedule.getStudentId() + ",";
		sql += "courseid=" + schedule.getCourseId() + ",";
		sql += "teacherid=" + schedule.getTeacherId() + ",";

		if(schedule.getAddition() == null){
			sql += "addition=" + "'" + "',";
		}
		else{
			sql += "addition=" + "'" + schedule.getAddition() +"',";
		}
		
		if(schedule.getDescription() == null){
			sql += "description=" + "'" + "'";
		}
		else{
			sql += "description=" + "'" + schedule.getDescription() +"'";
		}
		
		
		sql += " where id = " + schedule.getId();
		
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void delete(int key){
		String sql = "delete from aeas_schedule where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		DbScheduleOperation operation = new DbScheduleOperation();
		Schedule schedule = new Schedule();
		schedule.setOnDate(Date.valueOf("2014-10-2"));
		schedule.setId(10);
		schedule.setOnTime(2);
		schedule.setStudentId(3);
		schedule.setTeacherId(3);
		schedule.setAddition("5-1");
		operation.update(schedule);
		
		
		
		
	}

}
