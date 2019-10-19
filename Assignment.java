import java.util.*;

public class Assignment {

    private Scanner scan;
    ArrayList<Guest> guests = new ArrayList<Guest>();
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ArrayList<Integer> startday = new ArrayList<Integer>();
    ArrayList<Integer> endday = new ArrayList<Integer>();
    ArrayList<Booking> bookings = new ArrayList<Booking>();

    public Assignment() {
        scan = new Scanner(System.in);
        
            
        
        
        mainMenu();
    }

    public static void main(String args[]) {
        Assignment hotel = new Assignment();

    }

    void addGuest() {
        System.out.println("Please Enter Guest Name");
        String guestName = scan.nextLine();
        int guestId = 0;
        if (guests.isEmpty()) {
            guestId = 1;
        } else {
            guestId = guests.get(guests.size() - 1).getId() + 1;
        }
        guests.add(new Guest(guestName, guestId));
        System.out.println("Guest " + guestName + " has been created with guest ID: " + guestId);
        System.out.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
        char choice = scan.nextLine().toLowerCase().charAt(0);
        if (choice == 'a') {
            addGuest();
        } else if (choice == 'r') {
            mainMenu();
        } else {
            System.out.println("Invalid Input!");
        }

    }

    private void mainMenu() {
        System.out.println("Welcome to FedUni Hotel");
        System.out.println("");
        System.out.println("");
        System.out.println("Main Menu - please select an option:");
        System.out.println("");
        System.out.println("1. Add Guest");
        System.out.println("2. Add Room");
        System.out.println("3. Add Booking");
        System.out.println("4. View Bookings");
        System.out.println("5. Quit");
        System.out.print("Enter Choice: ");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            addGuest();
        } else if (choice == 2) {
            addRoom();
        } else if (choice == 3) {
            addBooking();
        } else if (choice == 4) {
            viewBookings();
        } else if (choice == 5) {
            quit();
        } else {
            System.out.println("Invalid Input!");
        }
    }

    void quit() {
        System.out.println("Thanks for using FedUni Hotel Bookings");
    }

    static int dateToDayNumber(int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return 0;
        }
        if (month == 1) {
            return day;
        }
        if (month == 2) {
            return 31 + day;
        }
        if (month == 3) {
            return 59 + day;
        }
        if (month == 4) {
            return 90 + day;
        }
        if (month == 5) {
            return 120 + day;
        }
        if (month == 6) {
            return 151 + day;
        }
        if (month == 7) {
            return 181 + day;
        }
        if (month == 8) {
            return 212 + day;
        }
        if (month == 9) {
            return 243 + day;
        }
        if (month == 10) {
            return 273 + day;
        }
        if (month == 11) {
            return 304 + day;
        }
        return 334 + day;
    }

    void addRoom() {
        System.out.println("Please enter room number");
        int roomNumber = scan.nextInt();
        Room temp = new Room(roomNumber, 0);
        if (!rooms.contains(temp)) {
            System.out.println("Please enter room capacity:");
            int roomCapacity = scan.nextInt();
            scan.nextLine();
            rooms.add(new Room(roomNumber, roomCapacity));
            System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
            char choice = scan.nextLine().toLowerCase().charAt(0);
            while(true){
            if (choice == 'a') {
                addRoom();
                break;
            } else if (choice == 'r') {
                mainMenu();
                break;
            } else {
                System.out.println("Invalid Input!");
                System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
                choice = scan.nextLine().toLowerCase().charAt(0);
                
            }
        } }else {
            System.out.println("Room already exists");
            addRoom();
        }
    }

    void addBooking() {
        System.out.println("Please enter guest ID ");
        int guestId = scan.nextInt();
        while (guestId > guests.size() || guestId <= 0) {
            System.out.println("Guest ID does not exist");
            addBooking();
        }
          
        Room selectedRoom = null;
        while (true) {
            System.out.println("Please enter room number: ");
            int roomNumber = scan.nextInt();
            Room temp = new Room(roomNumber, 0);
            if(rooms.contains(temp)) {
                selectedRoom = rooms.get(rooms.indexOf(temp));
                break;
            } else {
                System.out.println("This Room number not exist!");
            }
            
        }
        
        Booking booking = null;
        while (true) {
            System.out.println("Please enter number of guests : ");
            int numberOfGuests = scan.nextInt();
            if(numberOfGuests > selectedRoom.getCapacity()) {
                System.out.println("Number of guests exceeds the capacity of room : " + selectedRoom.getCapacity());
                addBooking();
            } else {
                booking = new Booking(guestId, selectedRoom.getRoomNumber(), numberOfGuests);
                break;
            }
        }
        
        System.out.println("Please enter check-in month: ");
        int checkinMonth = scan.nextInt();
        while (checkinMonth > 12 || checkinMonth <= 0) {
            System.out.println("Invalid month. Please enter check-in month:");
            checkinMonth = scan.nextInt();
        }

        System.out.println("Please enter check-in day:");
        int checkinDay = scan.nextInt();
        while (getDays(checkinMonth) < checkinDay) {
            System.out.println("Invalid day. Please enter check-in day:");
            checkinDay = scan.nextInt();
        }
        int start = dateToDayNumber(checkinMonth, checkinDay);

        System.out.println("Please enter check-out month:");
        int checkoutMonth = scan.nextInt();

        System.out.println("Please enter check-out day:");
        int checkoutDay = scan.nextInt();
        scan.nextLine();
        int end = dateToDayNumber(checkoutMonth, checkoutDay);
        
        
        
        
       if (isBook(selectedRoom.getRoomNumber(),start,end)) {
            System.out.println("*** Booking Successful ***");
            booking.setStart(start);
            booking.setEnd(end);
            booking.setStartDay(checkinDay);
            booking.setEndDay(checkoutDay);
            booking.setStartMonth(checkinMonth);
            booking.setEndMonth(checkoutMonth);
            bookings.add(booking);
            numbers.add(selectedRoom.getRoomNumber());
            rooms.add(selectedRoom);

        } else {
            System.out.println("Room is not available during that period.");
            addBooking();
       }
        

        System.out.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");

        char choice = scan.nextLine().toLowerCase().charAt(0);
        while(true){
        if (choice == 'a') {
            addBooking();
        } else if(choice == 'r') {
            mainMenu();
        } else {
            System.out.println("Invalid Input!");
            System.out.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");
            choice = scan.nextLine().toLowerCase().charAt(0);
        }
        }
    }

    void viewBookings() {
        System.out.println("Would you like to view [G]uest bookings, [R]oom booking, or e[X]it?");
        char choice = scan.nextLine().toLowerCase().charAt(0);
        if (choice == 'g') {
            guestBooking();
        } else if (choice == 'r') {
            roomBooking();
        } else if (choice == 'x'){
            mainMenu();
        } else {
            System.out.println("Invalid Input!");
        }

    }

    void guestBooking() {
        System.out.println("Please enter guest ID:");
        int guestId = scan.nextInt();
        scan.nextLine();
        int ind = guestId - 1;
        if (guests.size() >= ind) {
            System.out.println("Guest " + guestId + " :  " + guests.get(ind).getName());
            Booking booking = getBookingByGuestId(guestId);
            System.out.println("Booking : Room " + booking.getRoomNumber() + " ," + booking.getNumberOfGuests() + "guest[s] from  "
                    + booking.getStartMonth() + "/" + booking.getStartDay()+ " to " + booking.getEndMonth() + "/" + booking.getEndDay());
            viewBookings();
        } else {
            System.out.println("Guest does not exist");
            guestBooking();
        }
    }

    void roomBooking() {
        System.out.println("Please enter room number:");
        int roomNumber = scan.nextInt();
        scan.nextLine();
        Booking booking = getBookingByRoom(roomNumber);
        
        if (booking.getRoomNumber()==roomNumber) {
              int ind = rooms.indexOf(roomNumber);
              
             System.out.println("Room " + roomNumber + " bookings");
             System.out.println("Guest :  " + booking.getGuestId() + " ," + booking.getNumberOfGuests() + "guest[s] from  "
                    + booking.getStartMonth() + "/" + booking.getStartDay() + " to " + booking.getEndMonth() + "/" + booking.getEndDay());
            
            viewBookings();

        } else {
            System.out.println("Room does not exists");
            roomBooking();
        }
    }

    int getDays(int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 28;
        }
    }

    private Booking getBookingByGuestId(int guestId) {
        for (Booking booking : bookings) {
            if(booking.getGuestId() == guestId) {
                return booking;
            }
        }
        return null;
    }
    private Booking getBookingByRoom(int room) {
        for (Booking booking : bookings) {
            if(booking.getRoomNumber() == room) {
                return booking;
            }
        }
        return null;
    }
    private boolean isBook(int room, int start,int end){
        if(!numbers.contains(room)){
            return true;
        }
        for(Booking booking : bookings){
            if(booking.getRoomNumber()==room){
                
                
                if(booking.getStart()<start && booking.getEnd()<end && booking.getEnd()<start && booking.getStart()<end){
                    return true;
                }
                else if(booking.getStart()>start && booking.getEnd()>end && booking.getEnd()>start && booking.getStart()>end){
                    return true;
                }
            }
        }
        
        return false;
    }
}
