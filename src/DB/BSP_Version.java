package DB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSP_Version {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/unternehmen";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("select AHVNr, NName, Gebtag from angestellter");

			while (rs.next()) {

				// Retrieve by column name
				int id = rs.getInt("AHVNr");
				String NName = rs.getString("NName");
				Date GebDate = rs.getDate("Gebtag");

				// Display values
				System.out.print("AHVNr: " + id);
				System.out.print(", NName: " + NName);
				System.out.println(", GebDate: " + GebDate);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(BSP_Version.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(BSP_Version.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}
}