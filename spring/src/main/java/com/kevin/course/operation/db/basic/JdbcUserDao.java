package com.kevin.course.operation.db.basic;

import com.kevin.course.object.Teacher;
import com.kevin.course.object.User;
import com.kevin.course.operation.db.IUserOperation;
import com.kevin.course.utils.TableName;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcUserDao extends JdbcBaseDao<User> implements IUserOperation {
    public User get(String userName, String userPassword) {
        String sql = "select * from " + getTableName() + " where name = ? and password=password(?)";
        List<User> list = query(sql, this, new Object[]{userName, userPassword});
        return list.isEmpty() ? null : list.get(0);
    }

    public User getByEmail(String userName, String userEmail) {
        String sql = "select * from " + getTableName() + " where name = ? and email= ?";
        List<User> list = query(sql, this, new Object[]{userName, userEmail});
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void add(final User user) {
        String sql = "insert into " + getTableName() + "(name,password,email,qq,phone,description) values(" +
                "?, password(?), ?, ?, ?, ?)";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getQq());
                ps.setString(5, user.getPhone());
                ps.setString(6, user.getDescription());
            }
        };
        update(sql, setter);
        user.setId(mysql_insert_id());
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void updatePassword(final String userName, final String userPassword) {
        String sql = "update " + getTableName() + " set password=password(?)" +
                " where name = ?";
        PreparedStatementSetter setter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, userPassword);
                ps.setString(2, userName);
            }
        };
        update(sql, setter);

    }

    protected User generateObject(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setQq(rs.getString("qq"));
        user.setPhone(rs.getString("phone"));
        user.setDescription(rs.getString("description"));
        return user;
    }

    @Override
    protected String getTableName() {
        return TableName.USER;
    }
}
