package com.kevin.course.operation.db.basic;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.IFirstCourseOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcFirstCourseOperation extends JdbcBaseOperation<FirstCourse> implements IFirstCourseOperation {
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
		String sql = "select * from " + getTableName() + " where grade = :grade";
        HashMap<String, Object> map = new HashMap<>();
        map.put("grade", grade);
		try {
            return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}



	}

	public void add(FirstCourse firstCourse) {
        String sql = "insert into " + getTableName() + "(grade,name,shortname,description) values(:grade, :name, :shortName, :description)";
        Map<String, Object> map = createMap(firstCourse);
        try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	public void update(FirstCourse firstCourse) {
        String sql = "update " + getTableName() + " set grade=:grade, name=:name, shortname=:shortName, description=:description where id=:id";
        Map<String, Object> map = createMap(firstCourse);
        try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}

	}

	@Override
	protected String getTableName() {
		return "aeas_firstcourse";
	}

}
