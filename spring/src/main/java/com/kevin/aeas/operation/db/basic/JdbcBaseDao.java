package com.kevin.aeas.operation.db.basic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class JdbcBaseDao<T> extends JdbcTemplate implements RowMapper {

    protected abstract T generateObject(ResultSet rs) throws SQLException;

    protected abstract String getTableName();

    public T get(int key) {
        String sql = "select * from " + getTableName() + " where id =?";
        List<T> list = null;
        list = query(sql, this, new Object[]{key});
        return list.isEmpty() ? null : list.get(0);
    }

    public List<T> getAll() {
        String sql = "select * from " + getTableName();
        List<T> list = null;

        list = query(sql, this);
        return list;
    }


    public void delete(int key) {
        String sql = "delete from " + getTableName() + " where id =?";
        update(sql, new Object[]{key});
    }

    public T mapRow(ResultSet rs, int rowNum) throws SQLException{
        return generateObject(rs);
    }

    protected int mysql_insert_id(){
        String sql = "select last_insert_id()";
        List<Integer> list = query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {

                return rs.getInt(1);
            }
        });
        return list.get(0);
    }

}
