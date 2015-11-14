package DB;
import java.sql.Connection;
import java.sql.DriverManager;

public class BSP_DBTutorial {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
			System.out.println("connection ok");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
