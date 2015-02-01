package com.kevin.aeas.utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGetConnection {

	public abstract Connection getConnection() throws SQLException;

}