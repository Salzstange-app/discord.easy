package net.sta.mysql;

import java.sql.*;

public class MySql {
	public static Connection con;
	private final String host;
	private final String port;
	private final String database;
	private final String username;
	private final String password;

	public MySql(String Host, String Port, String Database, String Username, String Password) {
		this.host = Host;
		this.port = Port;
		this.database = Database;
		this.username = Username;
		this.password = Password;
		MySqlconnection();
	}

	public Connection getConnection() {
		return con;
	}

	public String getDatabase() {
		return database;
	}

	public String getHost() {
		return host;
	}

	public String getPassword() {
		return password;
	}

	public String getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	private void MySqlconnection() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:net.sta.mysql://" + host + ":" + port + "/" + database, username,
						password);
				System.out.println("[MySql] connect");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("connection failed Please check your connection");
		}
	}

	public boolean isConnected() {
		return (con == null ? false : true);
	}

}
