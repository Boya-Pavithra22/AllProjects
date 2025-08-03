package com.wipro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectivity {


	
	public static void main(String[] args) {
		// Load MySQL JDBC Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establishing the connection to MySQL database
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjavacode", "root",
					"pavithra");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {

				// Display the column headers
				System.out.println("ID\tName\t\tAge\tsal");
				System.out.println("-----------------------------------------------------------");

				// Iterate through the ResultSet and print each student record
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String course = rs.getString("course");
					double marks = rs.getDouble("marks");

					// Print student information
					System.out.println(id + "\t" + name + "\t\t" + age + "\t" + course + "\t\t" + marks);
				}

			} catch (SQLException e) {
				System.out.println("SQL error: " + e.getMessage());
			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not found: " + e.getMessage());
		}
	}

}
