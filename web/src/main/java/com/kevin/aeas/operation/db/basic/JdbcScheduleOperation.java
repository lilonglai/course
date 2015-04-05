package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.IScheduleOperation;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcScheduleOperation extends JdbcBaseOperation<Schedule> implements IScheduleOperation{
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
		String sql = "select * from " + getTableName() + " where studentid = :studentId and ondate = :onDate and ontime=:onTime";
        HashMap<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        map.put("onDate", onDate);
        map.put("onTime", onTime);
		List<Schedule> list;
		try {
			list = executeSql(sql, map);
			return list.size() > 0?list.get(0): null;
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<Schedule> getByStudentId(int studentId){
		String sql = "select * from " + getTableName() + " where studentid = :studentId order by ondate,ontime";
        HashMap<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
		String sql = "select * from " + getTableName() + " where teacherid = :teacherId order by ondate,ontime";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
		try {
           return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
		
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
		String sql = "select * from " + getTableName() + " where ondate = :onDate ";
        HashMap<String, Object> map = new HashMap<>();
        map.put("onDate", onDate);
		if(onTime >=1){
			sql += "and ontime=:onTime ";
            map.put("onTime", onTime);
		}
		sql += "order by ondate,ontime";

		try {
            return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}

	}
	
	
	public void add(Schedule schedule){
		String sql = "insert into " + getTableName() + "(ondate,ontime,studentid,courseid,teacherid,addition,description) " +
                "values(:onDate, :onTime, :studentId, :courseId, :teacherId, :addition, :description)";
        Map<String, Object> map = createMap(schedule);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void update(Schedule schedule){
		String sql = "update " + getTableName() + " set ondate=:onDate, ontime=:onTime, " +
                "studentid=:studentId, courseid= courseId, teacherid=:teacherId, addition=:addition, description=:description " +
                "where id=:id";
        Map<String, Object> map = createMap(schedule);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
		
	}

	@Override
	protected String getTableName() {
		return "aeas_schedule";
	}

}
