package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.ITeacherOperation;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTeacherDao extends JdbcBaseDao<Teacher> implements ITeacherOperation{
	protected Teacher generateObject(ResultSet rs) throws SQLException{
		Teacher teacher = new Teacher();
		teacher.setId(rs.getInt("id"));
		teacher.setName(rs.getString("name"));
		teacher.setShortName(rs.getString("shortname"));
		teacher.setPhone(rs.getString("phone"));
		teacher.setIsMaster(rs.getBoolean("ismaster"));	
		return teacher;
	}
	
	public Teacher getByName(String name){
		String sql = "select * from " + getTableName() + " where name = ?";
		List<Teacher> list =query(sql, this, new Object[]{name});
		return list.isEmpty()? null: list.get(0);
	}
	
	
	public Teacher getByShortName(String shortName){
		String sql = "select * from " + getTableName() + " where shortName = ?";
		List<Teacher> list =query(sql, this, new Object[]{shortName});
		return list.isEmpty()? null: list.get(0);
	}
	
	public List<Teacher> getAlive(){
		String sql = "select * from " + getTableName() + "" + " where isalive=true";
		return query(sql, this);
	}
	
	public List<Teacher> getNotAlive(){
		String sql = "select * from " + getTableName() + "" + " where isalive=false";
		return query(sql, this);
	}
	
	public Teacher getByCondition(Teacher condition){
        return null;
	}
	
	public void add(final Teacher teacher){
		String sql = "insert into " + getTableName() + "(name,shortname,phone,ismaster) values("+
                "?, ?, ?, ?)";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, teacher.getName());
                ps.setString(2, teacher.getShortName());
                ps.setString(3, teacher.getPhone());
                ps.setBoolean(4, teacher.getIsMaster());
            }
        };
        update(sql, setter);
        teacher.setId(mysql_insert_id());
	}
	
	public void update(final Teacher teacher){
		String sql = "update " + getTableName() + " set name=?, shortname=?, phone=?, ismaster= ? " +
                " where id = ?";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, teacher.getName());
                ps.setString(2, teacher.getShortName());
                ps.setString(3, teacher.getPhone());
                ps.setBoolean(4, teacher.getIsMaster());
                ps.setInt(5, teacher.getId());
            }
        };
        update(sql, setter);
	}
	
	public void retire(int key){
		String sql = "update " + getTableName() + " set isalive = false" + " where id = :id";
		update(sql, new Object[]{key});
	}

	@Override
	protected String getTableName() {
		return "aeas_teacher";
	}
	

}
