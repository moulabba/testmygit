package com.cap.formation.jour4;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class MysqlConnect {
	 
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/formation";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
 
	public static void main(String[] argv) {
 
		try {
			selectRecordsFromTable();
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
	}
 
	private static void selectRecordsFromTable() throws SQLException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String selectSQL = "SELECT nom_serv, ville_serv FROM service WHERE num_sev = 1";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = (PreparedStatement) dbConnection.prepareStatement(selectSQL);
			//preparedStatement.setInt(1,10);
 
			// execute select SQL stetement
			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
 
			while (rs.next()) {
 
				String userid = rs.getString("nom_serv");
				String username = rs.getString("ville_serv");
 
				System.out.println("nom_serv : " + userid);
				System.out.println("ville_serv : " + username);
			}

		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}
 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = (Connection) DriverManager.getConnection(
                             DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
}