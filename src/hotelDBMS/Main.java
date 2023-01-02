package hotelDBMS;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean menuExit = true;
		while (menuExit) {
			System.out.println("************************");
			System.out.println("Create Tables");
			System.out.println("Insert 10,000 hotels");
			System.out.println("Insert 1 hotel");
			System.out.println("Print 10 hotels");
			System.out.println("Make first 10 hotels 'is_Active' = false");
			System.out.println("Print hotel information by user input");
			System.out.println("************************");
			int option = scanner.nextInt();
			switch (option) {

			case 1:
				Hotels hotel = new Hotels();
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
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

			}

		}

	}

}
