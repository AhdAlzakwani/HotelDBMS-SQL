package hotelDBMS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Guests {
	public static void createGuestsTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sqlDB = "CREATE TABLE Guests " + "(id INTEGER not NULL, " + " guest_name VARCHAR(20) not null, "+ " guest_phone VARCHAR(10) not null, "
		+"guest_accompanying_members INTEGER not NULL,"
		+"guest_payment_amount INTEGER not NULL,"+" room_id INTEGER foreign key references Room(id),"+"hotel_id INTEGER foreign key references Hotels(id),"+
		" created_date Date  not null, " +"updated_date Date, "+"is_Active VARCHAR(5) CHECK (is_Active in('true','false')) NOT NULL,"+" PRIMARY KEY ( id ))";

		Connection conn = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}
		

	}


}
