package com.kevin.course.operation.db.basic;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.IFirstCourseOperation;
import com.kevin.course.utils.TableName;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcFirstCourseDao extends JdbcBaseDao<FirstCourse> implements IFirstCourseOperation {
	protected FirstCourse generateObject(ResultSet rs) throws SQLException{
		FirstCourse firstCourse = new FirstCourse();
		firstCourse.setId(rs.getInt("id"));
		firstCourse.setGrade(rs.getInt("grade"));
		firstCourse.setName(rs.getString("name"));
		firstCourse.setShortName(rs.getString("shortname"));
		firstCourse.setDescription(rs.getString("description"));
		return firstCourse;
	}

	public List<FirstCourse> getByGrade(int grade) {
		String sql = "select * from " + getTableName() + " where grade = ?";
		return query(sql, this, new Object[]{grade});
	}

	public void add(final FirstCourse firstCourse) {
        String sql = "insert into " + getTableName() + "(grade,name,shortname,description) values(?, ?, ?, ?)";

		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, firstCourse.getGrade());
				ps.setString(2, firstCourse.getName());
				ps.setString(3, firstCourse.getShortName());
				ps.setString(4, firstCourse.getDescription());
			}
		};
		update(sql, setter);
		firstCourse.setId(mysql_insert_id());

	}

	public void update(final FirstCourse firstCourse) {
        String sql = "update " + getTableName() + " set grade=?, name=?, shortname=?, description=? where id=?";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, firstCourse.getGrade());
				ps.setString(2, firstCourse.getName());
				ps.setString(3, firstCourse.getShortName());
				ps.setString(4, firstCourse.getDescription());
				ps.setInt(5, firstCourse.getId());
			}
		};
		update(sql, setter);

	}

	@Override
	protected String getTableName() {
		return TableName.FIRSTCOURSE;
	}

}
