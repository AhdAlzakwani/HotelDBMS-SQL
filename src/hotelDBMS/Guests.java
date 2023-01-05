package hotelDBMS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Guests {
	public static void createGuestsTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sqlDB = "CREATE TABLE Guests " + "(id INTEGER not NULL, " + " guest_name VARCHAR(20) not null, "+ " guest_phone VARCHAR(10) not null, "
		+"guest_accompanying_members INTEGER not NULL,"
		+"guest_payment_amount INTEGER not NULL,"+" room_id INTEGER foreign key references Rooms(id),"+"hotel_id INTEGER foreign key references Hotels(id),"+
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
	public static void readFromTable(int infonum){
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";
		
		

		String sqlDB = "SELECT TOP "+infonum+" * FROM Guests";

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
		
	public static void getById(){
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		System.out.println(" Enter id ?");
		  int id = scanner.nextInt();
		String sqlDB = "SELECT * FROM Guests where id="+id;
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

	public static void updateById(int id){
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";
	try {
		
	    String sqlDBss = "update Guests set is_Active = 'false' where id<="+id;

	    Connection conn = null;

		Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, user, pass);

		Statement st = conn.createStatement();

		int m = st.executeUpdate(sqlDBss);

		if (m >= 1) {
			System.out.println("Values updated in given Table...");

		} else {
			System.out.println(" Values already updated in given database...");
		}

		conn.close();
		  

	} catch (Exception ex) {
		System.err.println(ex);
	}


	String sqlDB = "SELECT TOP 10 * FROM Guests";

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
		
	public static void deleteById() {
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		System.out.println(" Enter id to be deleted ?");
		  int id = scanner.nextInt();
		String sqlDB = "delete from Guests where id ="+id;
		Connection conn = null;
	try {
		Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, user, pass);

		Statement st = conn.createStatement();

		int m = st.executeUpdate(sqlDB);

		if (m >= 1) {
			System.out.println("Row Deleted in given Table...");

		} else {
			System.out.println(" Row already Deleted in given database...");
		}

		conn.close();
		  

	} catch (Exception ex) {
		System.err.println(ex);
	}
	}	

	public static void makeIsActiveFalseById(int id) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(" which row you want to update ? Enter id");
		   id = scanner.nextInt();
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

			String user = "sa";
			String pass = "root";
		    String sqlDBss = "update Guests set is_Active = 'true' where id<="+id;

		    Connection conn = null;

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			int m = st.executeUpdate(sqlDBss);

			if (m >= 1) {
				System.out.println("Values updated in given Table...");

			} else {
				System.out.println(" Values already updated in given database...");
			}

			conn.close();
			  

		} catch (Exception ex) {
			System.err.println(ex);
		}
		
		
	}

	public static void insertIntoTable(int number ){

	try {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";
		
		
		String guest_name = "Kamla";
		String guest_phone = "753567";
		String created_date = "5-9-2022";
		String updated_date = "1-8-2023";
		String is_Active = "true";

	    Random rn = new Random();
		Integer numberToAdd = rn.nextInt(10);
		  for(int i = 10; i<=number; i++ ) {
		String sqlDBss = "INSERT INTO Guests VALUES(" + i+numberToAdd + ",'" + (guest_name ) +"','"+ (guest_phone+1)
				+"',"+i*numberToAdd+","+i*numberToAdd+","+36+","+36
				+ ",'"+ created_date + "','"+updated_date+"','"+is_Active+"')";
		
		

		Connection conn = null;

		Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, user, pass);

		Statement st = conn.createStatement();

		int m = st.executeUpdate(sqlDBss);

		if (m >= 1) {
			System.out.println("Values Inserted in given Table...");

		} else {
			System.out.println(" Values already Inserted in given database...");
		}

		conn.close();
		  }

	} catch (Exception ex) {
		System.err.println(ex);
	}


		
		}

}
