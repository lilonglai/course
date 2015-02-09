package com.kevin.aeas.operation.db.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kevin.aeas.utils.C3Pool;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DbNoPool;
import com.kevin.aeas.utils.IGetConnection;

public abstract class DbBaseOperation {
	private boolean usePool = true;

	private IGetConnection getCon;

	public DbBaseOperation() {
		String usePoolString = ConfigurationManager.getInstance().getProperty(
				"usePool");
		if (usePoolString != null) {
			usePool = Boolean.valueOf(usePoolString);
		}

		if (usePool) {
			getCon = new C3Pool();
		} else {
			getCon = new DbNoPool();
		}
	}

	protected Connection getConnection() throws SQLException {
		return getCon.getConnection();
	}

	protected void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	protected void closeStatement(Statement statement) throws SQLException {
		if (statement != null) {
			statement.close();
		}
	}

	protected void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

	protected abstract Object generateObject(ResultSet rs) throws SQLException;

	protected List executeSql(String sql) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object obj = generateObject(rs);
				list.add(obj);
			}
		} finally {
			closeResultSet(rs);
			closeStatement(statement);
			closeConnection(connection);
		}
		return list;
	}

	protected void executeUpdateSql(String sql) throws SQLException {		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} finally {
			closeResultSet(rs);
			closeStatement(statement);
			closeConnection(connection);
		}
	}
}
