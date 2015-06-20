package com.kevin.course.operation.db.basic;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.ISecondCourseOperation;
import com.kevin.course.utils.TableName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSecondCourseOperation extends JdbcBaseOperation<SecondCourse> implements ISecondCourseOperation {
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
		String sql = "select * from " + getTableName() + " where firstcourseid = :firstCourseId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("firstCourseId", firstCourseId);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<SecondCourse> getByGrade(int grade){
		String sql = "select aeas_secondcourse.* from aeas_firstcourse,aeas_secondcourse "
				+ "where aeas_firstcourse.id=aeas_secondcourse.firstcourseid and grade = :grade"
				+ " order by aeas_secondcourse.firstcourseid";
        HashMap<String, Object> map = new HashMap<>();
        map.put("grade", grade);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void add(SecondCourse secondCourse){
		String sql = "insert into " + getTableName() + "(name,shortname,firstcourseid,description) values("
				+ ":name, :shortName, :firstCourseId, :description)";
        Map<String, Object> map = createMap(secondCourse);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}		
	}
	
	public void update(SecondCourse secondCourse){
		String sql = "update " + getTableName() + " set "
				+ "name=:name,shortname=:shortName, firstcourseid=:firstCourseId, description=:description "
                + "where id = :id";
        Map<String, Object> map = createMap(secondCourse);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	@Override
	protected String getTableName() {
		return TableName.SECONDCOURSE;
	}

}
