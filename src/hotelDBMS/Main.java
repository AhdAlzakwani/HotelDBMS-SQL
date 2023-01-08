package hotelDBMS;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Hotels hotel = new Hotels();
		boolean menuExit = true;
		boolean submenuExit = true;
		while (menuExit) {
			System.out.println("************************");
			System.out.println("1- Create Tables");
			System.out.println("2- Insert 10,000 hotels");
			System.out.println("3- Insert 1 hotel");
			System.out.println("4- Print 10 hotels");
			System.out.println("5- Make first 10 hotels 'is_Active' = false");
			System.out.println("6- Print hotel information by user input");
			System.out.println("7- NEW SUB MENU");
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
				System.out.println(" how many number of rows are to be inserted");
				int number = scanner.nextInt();
				hotel.insertIntoTable(number);
				break;
			case 3:
				
				hotel.insertIntoTable(1);
				break;
			case 4:
				hotel.readFromTable(10);
				break;
			case 5:
				System.out.println(" which row you want to update ? Enter id");
				int id = scanner.nextInt();
				hotel.updateById(id);
				break;
			case 6:
				System.out.println(" how many informatoin You want");
				int infonumbers = scanner.nextInt();
				hotel.readFromTable(infonumbers);
				break;
			case 7:
				while (submenuExit) {
					HotelManagement hm = new HotelManagement();

					System.out.println("************************");
					System.out.println("1- Guests who's name end with 'E'");
					System.out.println("2- Rooms where guests are paying more than 1000");
					System.out.println("3- Count of guests who are staing in 'DELUXE' rooms");
					System.out.println("4- Guests who are staing in rooms and served by employee who have 'A' in their name");
					System.out.println("5- All rooms which are not active but room type is 'Deluxe'");
					System.out.println("6- All room type in hotels who's name have 'H' or are active but have more than 5 rooms.");
					System.out.println("7- BACK TO BIG MENU");
					System.out.println("************************");
					int options = scanner.nextInt();
					switch (options) {

					case 1:
							hm.Guestswho();
						break;
					case 2:
						hm.roomsPaying();;

						break;
					case 3:
						hm.guestsCount();
						break;
					case 4:
						hm.gustActive();
						break;
					case 5:
						hm.roomActive();

						break;
					case 6:
						hm.countId();
						break;
					case 7:
						submenuExit = false;
						menuExit = true;
						break;
					}
				}
				break;
			case 8:
//				Employees employee = new Employees();
//				employee.insertIntoTable(20);
//				Rooms rooms = new Rooms();
//				rooms.insertIntoTable(5);
				Room_Type room_Type = new Room_Type();
				int room_type_number = scanner.nextInt();
				room_Type.insertIntoTable(room_type_number);

				break;
			case 9:
				Guests guest = new Guests();
				guest.insertIntoTable(20);
				break;
			

			}

		}

	}

}
