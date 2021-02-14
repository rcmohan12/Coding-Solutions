package com.rcm.designing.DBConnectionPool;

import java.sql.Connection; // represents the Connection to the DB
import java.sql.DriverManager; // helps with getting the connection to the DB
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionPool implements ConnectionPool {

	private static final int _MAX_POOL_SIZE = 10;
	private static List<Connection> _pool;
	private List<Connection> _usedConnections;
	
	private String _url;
    private String _user;
    private String _pword;
	
	private DBConnectionPool(String url, String user, String pword) {
		_pool = new ArrayList<>();
		_usedConnections = new ArrayList<>();
		_url = url;
		_user = user;
		_pword = pword;
	}
	
	public static DBConnectionPool create(String url, String user, String pword) throws SQLException {
		
		DBConnectionPool dbPool = new DBConnectionPool(url, user, pword);
		
		for(int x = 0; x < _MAX_POOL_SIZE; x++) {
			_pool.add(createConnection(url, user, pword));
		}
		
		return dbPool;
	}
	
	@Override
	public Connection getConnection() throws Exception {
		if (_pool.isEmpty()) {
	        if (_usedConnections.size() < _MAX_POOL_SIZE) {
	            _pool.add(createConnection(_url, _user, _pword));
	        } else {
	            throw new RuntimeException(
	              "Maximum pool size reached, no available connections!");
	        }
	    }

	    Connection connection = _pool.remove(_pool.size() - 1);

	    _usedConnections.add(connection);
	    
	    return connection;
	}

	@Override
	public boolean releaseConnection(Connection con) {
		_pool.add(con);
        return _usedConnections.remove(con);
	}

	private static Connection createConnection(String url, String user, String pword) throws SQLException {
		return DriverManager.getConnection(url, user, pword);
	}
	
}
