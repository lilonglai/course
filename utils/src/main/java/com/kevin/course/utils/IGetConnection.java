package com.kevin.course.utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGetConnection {

	public abstract Connection getConnection() throws SQLException;

}