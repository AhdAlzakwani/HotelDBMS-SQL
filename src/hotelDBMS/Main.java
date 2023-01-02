package hotelDBMS;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Hotels hotel = new Hotels();
		boolean menuExit = true;
		while (menuExit) {
			System.out.println("************************");
			System.out.println("1- Create Tables");
			System.out.println("2- Insert 10,000 hotels");
			System.out.println("3- Insert 1 hotel");
			System.out.println("4- Print 10 hotels");
			System.out.println("5- Make first 10 hotels 'is_Active' = false");
			System.out.println("6- Print hotel information by user input");
			System.out.println("************************");
			int option = scanner.nextInt();
			switch (option) {

			case 1:
				
				hotel.createHotalTable();
				
				Room_Type roomType = new Room_Type();
				roomType.createRoomTypeTable();
				
     			Rooms room = new Rooms();
				room.createRoomTable();
				
				Guests guests = new Guests();
				guests.createGuestsTable();
				
				Employee_Type eType = new Employee_Type();
				eType.createEmployeeTypeTable();
				
				Employees employees = new Employees();
				employees.createEmployeesTable();
				
				
				break;
			case 2:
				
				hotel.insertIntoTable(10000);
				break;
			case 3:
				hotel.insertIntoTable(1);
				break;
			case 4:
				hotel.readFromTable();
				break;
			case 5:
				break;

			}

		}

	}

}
