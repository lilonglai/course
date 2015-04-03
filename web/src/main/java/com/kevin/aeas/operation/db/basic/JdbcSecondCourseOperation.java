package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.ISecondCourseOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSecondCourseOperation extends JdbcBaseOperation<SecondCourse> implements ISecondCourseOperation{
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
		List<SecondCourse> list = null;
		try {
			list = executeSql(sql, map);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;		
	}
	
	public List<SecondCourse> getByGrade(int grade){
		String sql = "select aeas_secondcourse.* from aeas_firstcourse,aeas_secondcourse "
				+ "where aeas_firstcourse.id=aeas_secondcourse.firstcourseid and grade = :grade"
				+ " order by aeas_secondcourse.firstcourseid";
        HashMap<String, Object> map = new HashMap<>();
        map.put("grade", grade);
		List<SecondCourse> list = null;
		try {
			list = executeSql(sql, map);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;	
	}
	
	public void add(SecondCourse secondCourse){
		String sql = "insert into " + getTableName() + "(name,shortname,firstcourseid,description) values("
				+ ":name, :shortName, :firstCourseId, :description)";
        Map<String, Object> map = createMap(secondCourse);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}

	@Override
	protected String getTableName() {
		return "aeas_secondcourse";
	}

}
