package hotelDBMS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HotelManagement {
	public static void Guestswho() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "SELECT * FROM Guests where guest_name LIKE '%E'";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			ResultSet m = st.executeQuery(sqlDB);

			if (m.next()) {

				do {

					System.out.println("id : " + m.getInt(1));
					System.out.println("guest_name :" + m.getString(2));
					System.out.println("guest_phone :" + m.getString(3));
					System.out.println("guest_accompanying_members : " + m.getInt(4));
					System.out.println("guest_payment_amount : " + m.getInt(5));
					System.out.println("room_id : " + m.getInt(6));
					System.out.println("hotel_id : " + m.getInt(7));
					System.out.println("created_date :" + m.getDate(8));
					System.out.println("updated_date :" + m.getDate(9));
					System.out.println("is_Active :" + m.getString(10));
					System.out.println("*********************************");
					
					
					
					

				} while (m.next());

			} else {
				System.out.println("No such user id is already registered");
			}

			conn.close();
		}
		

		catch (Exception ex) {
			System.err.println(ex);
		}

		
		
	}
	
	
	public static void roomsPaying() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "SELECT * FROM Rooms INNER JOIN Guests ON Rooms.id = Guests.room_id WHERE Guests.guest_payment_amount > 100";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			ResultSet m = st.executeQuery(sqlDB);

			if (m.next()) {

				do {
					System.out.println("id : " + m.getInt(1));
					System.out.println("room_type_id :" + m.getInt(2));
					System.out.println("hotel_id : " + m.getInt(3));
					System.out.println("created_date :" + m.getDate(4));
					System.out.println("updated_date :" + m.getDate(5));
					System.out.println("is_Active :" + m.getString(6));
					System.out.println("id : " + m.getInt(7));
					System.out.println("guest_name :" + m.getString(8));
					System.out.println("guest_phone :" + m.getString(9));
					System.out.println("guest_accompanying_members : " + m.getInt(10));
					System.out.println("guest_payment_amount : " + m.getInt(11));
					System.out.println("room_id : " + m.getInt(12));
					System.out.println("*********************************");
					
					

				} while (m.next());

			} else {
				System.out.println("No such user id is already registered");
			}

			conn.close();
		}
		

		catch (Exception ex) {
			System.err.println(ex);
		}

		
		
	}
}
