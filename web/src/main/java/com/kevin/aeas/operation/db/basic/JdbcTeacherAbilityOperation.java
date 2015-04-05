package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.ITeacherAbilityOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTeacherAbilityOperation extends JdbcBaseOperation<TeacherAbility> implements ITeacherAbilityOperation{
	protected TeacherAbility generateObject(ResultSet rs) throws SQLException{
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setId(rs.getInt("id"));
		teacherAbility.setTeacherId(rs.getInt("teacherid"));
		teacherAbility.setCourseId(rs.getInt("courseid"));
		return teacherAbility;
	}
	
	public List<TeacherAbility> getAll() {
		String sql = "select aeas_teacherability.*" +
                " from aeas_teacherability,aeas_firstcourse"
				+ " where aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		try {
			return executeSql(sql);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where teacherid = :teacherId and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where courseid = :courseId and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
        HashMap<String, Object> map = new HashMap<>();
        map.put("courseId", courseId);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void add(TeacherAbility teacherAbility){
		String sql = "insert into " + getTableName() + "(teacherid,courseid) values(:teacherId, :courseId)";
        Map<String, Object> map = createMap(teacherAbility);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}	
	}

	public void update(TeacherAbility teacherAbility){
		String sql = "update " + getTableName() + " set "
				+ "teacherid=:teacherId, courseid= :courseId "
                + "where id = :id";
        Map<String, Object> map = createMap(teacherAbility);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from " + getTableName() + " where teacherid = :teacherId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	
	public void deleteByTeacherAndGrade(int teacherId,int grade){
		String sql = "delete t from aeas_teacherability t where t.teacherid = :teacherId"
				+ " and t.courseid in(select c.id from aeas_firstcourse c where c.grade = :grade)";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
        map.put("grade", grade);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
		
	}

	@Override
	protected String getTableName() {
		return "aeas_teacherability";
	}
	
}


