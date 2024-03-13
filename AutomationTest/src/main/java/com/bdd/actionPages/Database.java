package com.bdd.actionPages;

import java.sql.*;
public class Database {

	Connection connection =null;
	public void connectToDataBase(String server, String dataBase, String userName, String password) throws ClassNotFoundException, SQLException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionString ="jdbc:sqlserver://"+server+";database="+dataBase+";user="+userName+";password="+password;
		connection = DriverManager.getConnection(connectionString);
	}

	public ResultSet executeQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()){
			rs.getInt(1);
			rs.getString(2);
			rs.getInt(3);
		}
		return rs;

	}
}
