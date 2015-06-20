package com.kevin.course.operation.db.basic;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.ITeacherAbilityOperation;
import com.kevin.course.utils.TableName;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTeacherAbilityDao extends JdbcBaseDao<TeacherAbility> implements ITeacherAbilityOperation {
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
		return query(sql, this);
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where teacherid = ? and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		return query(sql, this, new Object[]{teacherId});
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where courseid = ? and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		return query(sql, this, new Object[]{courseId});
	}
	
	public void add(final TeacherAbility teacherAbility){
		String sql = "insert into " + getTableName() + "(teacherid,courseid) values(?, ?)";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, teacherAbility.getTeacherId());
				ps.setInt(2, teacherAbility.getCourseId());
			}
		};
		update(sql, setter);
		teacherAbility.setId(mysql_insert_id());
	}

	public void update(final TeacherAbility teacherAbility){
		String sql = "update " + getTableName() + " set "
				+ "teacherid=?, courseid= ? "
                + "where id = ?";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, teacherAbility.getTeacherId());
				ps.setInt(2, teacherAbility.getCourseId());
				ps.setInt(3, teacherAbility.getId());
			}
		};
		update(sql, setter);
	}
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from " + getTableName() + " where teacherid = ?";
		update(sql, new Object[]{teacherId});
	}
	
	
	public void deleteByTeacherAndGrade(int teacherId,int grade){
		String sql = "delete t from aeas_teacherability t where t.teacherid = ?"
				+ " and t.courseid in(select c.id from aeas_firstcourse c where c.grade = ?)";
		update(sql, new Object[]{teacherId, grade});
		
	}

	@Override
	protected String getTableName() {
		return TableName.TEACHERABILITY;
	}
	
}


