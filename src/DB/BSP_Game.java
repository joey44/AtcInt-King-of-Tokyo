package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BSP_Game {

	public static void main(String[] args) {

		try{
			// connection to the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root","");
			
			// create database Game
			String dbName = "Game";
			String newDatabaseString = "CREATE DATABASE IF NOT EXISTS " + dbName;
			Statement s = con.createStatement();
			s.executeUpdate(newDatabaseString);

			// create tables
			con.setCatalog(dbName);
			s = con.createStatement();
			s.executeUpdate("create table IF NOT EXISTS User "
					+ "(ID int NOT NULL AUTO_INCREMENT, "
					+ "username varchar(40) NOT NULL, "
					+ "password varchar(40) NOT NULL, " + "PRIMARY KEY (ID))");		
			

			// populate tables
			s.executeUpdate("insert into User (username, password) "
					+ "values ('hans', 'loescher')");
			s.executeUpdate("insert into User (username, password) "
					+ "values ('max', 'mueller')");
			s.executeUpdate("insert into User (username, password) "
					+ "values ('thomas', 'weber')");

		
			// select some students
			ResultSet rs = s.executeQuery("select * from User ");
			while (rs.next()) {
				String username = rs.getString("username");
				System.out.println(username);
			}
			
			
			// s.executeUpdate("drop database IF EXISTS Game");

			// close
			rs.close();
			s.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
