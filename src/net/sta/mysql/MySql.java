package net.sta.mysql;

import lombok.Getter;

import java.sql.*;

public class MySql {
	@Getter public static Connection con;
	@Getter private final String host;
	@Getter private final String port;
	@Getter private final String database;
	@Getter private final String username;
	@Getter private final String password;

	public MySql(String Host, String Port, String Database, String Username, String Password) {
		this.host = Host;
		this.port = Port;
		this.database = Database;
		this.username = Username;
		this.password = Password;
		MySqlconnection();
	}

	private void MySqlconnection() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:net.sta.mysql://" + host + ":" + port + "/" + database, username,
						password);
				System.out.println("[MySql] connect");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.err.println("connection failed Please check your connection");
		}
	}

	public boolean isConnected() {
		return (con != null);
	}

}
