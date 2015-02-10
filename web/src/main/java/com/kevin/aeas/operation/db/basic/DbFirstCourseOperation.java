package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kevin.aeas.object.FirstCourse;

public class DbFirstCourseOperation extends DbBaseOperation<FirstCourse> {
	public FirstCourse get(int key) {
		String sql = "select * from " + getTableName() + " where id = " + key;
		FirstCourse firstCourse = null;
		List<FirstCourse> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				firstCourse = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return firstCourse;
	}

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
		String sql = "select * from " + getTableName() + " where grade = " + grade;
		List<FirstCourse> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public List<FirstCourse> getAll() {
		String sql = "select * from " + getTableName();
		List<FirstCourse> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void add(FirstCourse firstCourse) {
		String sql = "insert into " + getTableName() + "(grade,name,shortname,description) values("
				+ firstCourse.getGrade()
				+ ","
				+ "'"
				+ firstCourse.getName()
				+ "'," + "'" + firstCourse.getShortName() + "',";

		if (firstCourse.getDescription() == null) {
			sql += "'" + "" + "')";
		} else {
			sql += "'" + firstCourse.getDescription() + "')";
		}

		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(FirstCourse firstCourse) {
		String sql = "update " + getTableName() + " set " + "grade="
				+ firstCourse.getGrade() + "," + "name=" + "'"
				+ firstCourse.getName() + "'," + "shortname=" + "'"
				+ firstCourse.getShortName() + "',";

		if (firstCourse.getDescription() == null) {
			sql += "description=" + "'" + "'";
		} else {
			sql += "description=" + "'" + firstCourse.getDescription() + "'";
		}

		sql += " where id = " + firstCourse.getId();

		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int key) {
		String sql = "delete from " + getTableName() + " where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected String getTableName() {
		return "aeas_firstcourse";
	}

}
