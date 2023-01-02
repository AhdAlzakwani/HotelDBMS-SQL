package hotelDBMS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee_Type {
	public static void createEmployeeTypeTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sqlDB = "CREATE TABLE Employee_Type " + "(id INTEGER not NULL, " + " employee_type_name VARCHAR(20) not null, "
		+" created_date Date  not null, " +"updated_date Date, "+"is_Active VARCHAR(5) CHECK (is_Active in('true','false')) NOT NULL,"+" PRIMARY KEY ( id ))";

		
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