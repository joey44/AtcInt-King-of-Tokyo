package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BSP_TutorialDBConnection {

	public static void main(String[] args) {

		try{
			// connection to the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root","");
			
			// create database schule
			String dbName = "SCHULE";
			String newDatabaseString = "CREATE DATABASE IF NOT EXISTS " + dbName;
			Statement s = con.createStatement();
			s.executeUpdate(newDatabaseString);

			// create tables
			con.setCatalog(dbName);
			s = con.createStatement();
			s.executeUpdate("create table IF NOT EXISTS STUDENT "
					+ "(ID int NOT NULL AUTO_INCREMENT, "
					+ "PRENAME varchar(40) NOT NULL, "
					+ "LASTNAME varchar(40) NOT NULL, " + "PRIMARY KEY (ID))");		
			
			s.executeUpdate("create table IF NOT EXISTS FACH "
					+ "(ID int NOT NULL AUTO_INCREMENT, "
					+ "NAME varchar(40) NOT NULL, " + "PRIMARY KEY (ID))");
			s.executeUpdate("create table IF NOT EXISTS BELEGT "
					+ "(ID_STUD int NOT NULL, " + "ID_FACH int NOT NULL, "
					+ "Primary Key (ID_Stud, ID_Fach), "
					+ "Foreign Key (ID_Stud) references STUDENT(ID), "
					+ "Foreign Key (ID_Fach) references FACH(ID))");

			// populate tables
			s.executeUpdate("insert into STUDENT (PRENAME, LASTNAME) "
					+ "values ('hans', 'loescher')");
			s.executeUpdate("insert into STUDENT (PRENAME, LASTNAME) "
					+ "values ('max', 'mueller')");
			s.executeUpdate("insert into STUDENT (PRENAME, LASTNAME) "
					+ "values ('thomas', 'weber')");

			s.executeUpdate("insert into FACH (NAME) " + "values ('java')");
			s.executeUpdate("insert into FACH (NAME) " + "values ('mysql')");
			s.executeUpdate("insert into FACH (NAME) " + "values ('xml')");

			s.executeUpdate("insert into BELEGT (ID_STUD, ID_FACH) "
					+ "values (1, 1)");
			s.executeUpdate("insert into BELEGT (ID_STUD, ID_FACH) "
					+ "values (1, 2)");
			s.executeUpdate("insert into BELEGT (ID_STUD, ID_FACH) "
					+ "values (1, 3)");
			s.executeUpdate("insert into BELEGT (ID_STUD, ID_FACH) "
					+ "values (2, 1)");
			s.executeUpdate("insert into BELEGT (ID_STUD, ID_FACH) "
					+ "values (3, 1)");

			// select some students
			ResultSet rs = s.executeQuery("select PRENAME, LASTNAME "
					+ "from STUDENT, FACH, BELEGT "
					+ "where FACH.NAME = 'xml' "
					+ "and STUDENT.ID = BELEGT.ID_STUD "
					+ "and FACH.ID = BELEGT.ID_FACH ");
			while (rs.next()) {
				String prename = rs.getString("PRENAME");
				String lastname = rs.getString(2);
				System.out.println(prename + " " + lastname);
			}

			// update
			s.executeUpdate("update BELEGT set ID_FACH = 3 "
					+ "where ID_STUD = 3 " + "and ID_FACH = 1");

			// select some students again
			rs = s.executeQuery("select PRENAME, LASTNAME "
					+ "from STUDENT, FACH, BELEGT "
					+ "where FACH.NAME = 'xml' "
					+ "and STUDENT.ID = BELEGT.ID_STUD "
					+ "and FACH.ID = BELEGT.ID_FACH ");
			while (rs.next()) {
				String prename = rs.getString("PRENAME");
				String lastname = rs.getString("LASTNAME");
				System.out.println(prename + " " + lastname);
			}

			// drop everything
//			 s.executeUpdate("drop database IF EXISTS SCHULE");

			// close
			rs.close();
			s.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
