package com.kevin.course.operation.db.basic;

import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.ISecondCourseOperation;
import com.kevin.course.utils.TableName;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcSecondCourseDao extends JdbcBaseDao<SecondCourse> implements ISecondCourseOperation {
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
		String sql = "select * from " + getTableName() + " where firstcourseid = ?";
		return query(sql, this, new Object[]{firstCourseId});
	}
	
	public List<SecondCourse> getByGrade(int grade){
		String sqlFormat= "select %2$s.* from %1$s,%2$s "
				+ "where %1$s.id=%2$s.firstcourseid and grade = ?"
				+ " order by %1$s.firstcourseid";
		String sql = String.format(sqlFormat, TableName.FIRSTCOURSE, TableName.SECONDCOURSE);
		return query(sql, this, new Object[]{grade});
	}
	
	public void add(final SecondCourse secondCourse){
		String sql = "insert into " + getTableName() + "(name,shortname,firstcourseid,description) values("
				+ "?, ?, ?, ?)";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, secondCourse.getName());
                ps.setString(2, secondCourse.getShortName());
                ps.setInt(3, secondCourse.getFirstCourseId());
                ps.setString(4, secondCourse.getDescription());
            }
        };
        update(sql, setter);

        secondCourse.setId(mysql_insert_id());
	}
	
	public void update(final SecondCourse secondCourse){
		String sql = "update " + getTableName() + " set "
				+ "name=?,shortname=?, firstcourseid=?, description=? "
                + "where id = ?";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, secondCourse.getName());
                ps.setString(2, secondCourse.getShortName());
                ps.setInt(3, secondCourse.getFirstCourseId());
                ps.setString(4, secondCourse.getDescription());
                ps.setInt(5, secondCourse.getId());
            }
        };
        update(sql, setter);
	}

	@Override
	protected String getTableName() {
		return TableName.SECONDCOURSE;
	}

}
