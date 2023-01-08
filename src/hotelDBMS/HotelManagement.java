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

	public static void guestsCount() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "SELECT COUNT(*) FROM Guests JOIN Rooms ON Guests.room_id = Rooms.id JOIN Room_Type ON Room_Type.room_Type_name ='DELUXE'" ;
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			ResultSet m = st.executeQuery(sqlDB);

			if (m.next()) {

				do {
					System.out.println("COUNT : " + m.getInt(1));
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

	public static void roomActive() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "Select * from Rooms Join Room_Type ON Rooms.room_type_id = Room_Type.id Where Room_Type.room_type_name = 'DELUXE' AND Rooms.is_Active ='true'";
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
					System.out.println("Room Type id : " + m.getInt(7));
					System.out.println("Room Type Name :" + m.getString(8));
					
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
	public static void gustActive() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "SELECT * FROM Guests INNER JOIN Rooms ON Guests.room_id = Rooms.id INNER JOIN Employees ON "
				+ "Rooms.id = Employees.room_id INNER JOIN Employee_Type  "
				+ "ON Employees.employee_type_id = Employee_Type.id WHERE Employee_Type.employee_type_name LIKE '%A%'";
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

	public static void countId() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "SELECT COUNT(Rooms.room_type_id), Room_Type.room_type_name FROM Rooms INNER JOIN Room_Type "
				+ "ON Rooms.room_type_id = Room_Type.id GROUP BY room_type_name HAVING COUNT(Rooms.room_type_id) > 5 "
				+ "ORDER BY COUNT(Rooms.room_type_id) DESC";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			ResultSet m = st.executeQuery(sqlDB);

			if (m.next()) {

				do {
					System.out.println("COUNT : " + m.getInt(1));
					System.out.println("ROOM TYPE NAME :" + m.getString(2));
					
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
