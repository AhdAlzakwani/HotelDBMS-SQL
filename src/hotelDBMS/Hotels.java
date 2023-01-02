package hotelDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Hotels {

public static void createHotalTable() {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
	String user = "sa";
	String pass = "root";

	String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name VARCHAR(20) not null, "
			+ " hotel_location VARCHAR(20), " + " created_date Date  not null, " +"updated_date Date, "+"is_Active VARCHAR(5) CHECK (is_Active in('true','false')) NOT NULL,"+" PRIMARY KEY ( id ))";

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

public static void readFromTable(){
	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	String user = "sa";
	String pass = "root";

	String sqlDB = "SELECT TOP 10 * FROM Hotels";

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
				System.out.println("hotel_name :" + m.getString(2));
				System.out.println("hotel_location :" + m.getString(3));
				System.out.println("created_date :" + m.getDate(4));
				System.out.println("updated_date :" + m.getDate(5));
				System.out.println("is_Active :" + m.getString(6));
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
	
	}

public static void updateById(){
	
	}

public static void deleteById() {
	
	}

public static void makeIsActiveFalseById() {
}

public static void insertIntoTable(int number ){
	Scanner scanner = new Scanner(System.in);
	System.out.println(" how many number of rows are to be inserted");
	 number = scanner.nextInt();
try {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";

	String user = "sa";
	String pass = "root";
	String hotel_name = "AHD";
	String hotel_location = "ZAK";
	String created_date = "1-11-2022";
	String updated_date = "5-2-2023";
	String is_Active = "true";
	
	
	int min = 50;
    int max = 100;
    Random rn = new Random();
	Integer numberToAdd = rn.nextInt(10);
	  for(int i = 0; i<=number; i++ ) {
	String sqlDBss = "INSERT INTO Hotels VALUES(" + i+numberToAdd + ",'" + (hotel_name + i) + "','" + (hotel_location + i) + "','"
			+ created_date + "','"+updated_date+"','"+is_Active+"')";
	

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
