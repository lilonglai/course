package com.kevin.course.operation.db.basic;

import com.kevin.course.object.Schedule;
import com.kevin.course.operation.db.IScheduleOperation;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcScheduleDao extends JdbcBaseDao<Schedule> implements IScheduleOperation {
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
		String sql = "select * from " + getTableName() + " where studentid = ? and ondate = ? and ontime=?";
		List<Schedule> list = query(sql, this, new Object[]{studentId, onDate, onTime});
		return list.isEmpty()? null: list.get(0);
	}
	
	public List<Schedule> getByStudentId(int studentId){
		String sql = "select * from " + getTableName() + " where studentid = ? order by ondate,ontime";
		return query(sql, this, new Object[]{studentId});
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
		String sql = "select * from " + getTableName() + " where teacherid = ? order by ondate,ontime";
		return query(sql, this, new Object[]{teacherId});
	}
		
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
		String sql = "select * from " + getTableName() + " where ondate = ? ";
        Object args[];
		if(onTime >=1){
			sql += "and ontime=? ";
            args = new Object[]{onDate, onTime};
		}else{
            args = new Object[]{onDate};
        }
		sql += "order by ondate,ontime";

		return query(sql, this, args);
	}
	
	
	public void add(final Schedule schedule){
		String sql = "insert into " + getTableName() + "(ondate,ontime,studentid,courseid,teacherid,addition,description) " +
                "values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setDate(1, schedule.getOnDate());
                ps.setInt(2, schedule.getOnTime());
                ps.setInt(3, schedule.getStudentId());
                ps.setInt(4, schedule.getCourseId());
                ps.setInt(5, schedule.getTeacherId());
                ps.setString(6, schedule.getAddition());
                ps.setString(7, schedule.getDescription());
            }
        };
        update(sql, setter);

        schedule.setId(mysql_insert_id());
	}
	
	public void update(final Schedule schedule){
		String sql = "update " + getTableName() + " set ondate=?, ontime=?, " +
                "studentid=?, courseid=?, teacherid=?, addition=?, description=? " +
                "where id=?";

        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setDate(1, schedule.getOnDate());
                ps.setInt(2, schedule.getOnTime());
                ps.setInt(3, schedule.getStudentId());
                ps.setInt(4, schedule.getCourseId());
                ps.setInt(5, schedule.getTeacherId());
                ps.setString(6, schedule.getAddition());
                ps.setString(7, schedule.getDescription());
                ps.setInt(8, schedule.getId());
            }
        };
        update(sql, setter);
	}

	@Override
	protected String getTableName() {
		return "aeas_schedule";
	}

}
