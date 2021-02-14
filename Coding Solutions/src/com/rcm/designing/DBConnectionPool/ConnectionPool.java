package com.rcm.designing.DBConnectionPool;

import java.sql.Connection;

public interface ConnectionPool {
	Connection getConnection() throws Exception;
	boolean releaseConnection(Connection con);
}
