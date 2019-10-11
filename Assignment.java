import java.util.*;
import java.util.Collection;
public class Assignment {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> guests = new ArrayList<>();
    ArrayList<Integer> rooms = new ArrayList<>();
    ArrayList<Integer> capacity = new ArrayList<>();
    ArrayList<Integer> startday = new ArrayList<>();
    ArrayList<Integer> endday = new ArrayList<>();
    ArrayList<Integer> noofguests = new ArrayList<>();
    ArrayList<Integer> startmonth = new ArrayList<>();
    ArrayList<Integer> endmonth = new ArrayList<>();
    ArrayList<Integer> startdays = new ArrayList<>();
    ArrayList<Integer> enddays = new ArrayList<>();
 
    public static void main(String args[]){
        
       
        Assignment hotel = new Assignment();
         hotel.startday.add(0);
        hotel.endday.add(0);
        hotel.mainMenu();
        
        
    }
     void addGuest(){
        System.out.println("Please Enter Guest Name");
        String guest_name = sc.next();
        
        guests.add(guest_name);
        int guest_id =guests.indexOf(guest_name)+1; 
        System.out.println("Guest " + guest_name + " has been created with guest ID: " +  guest_id);
        System.out.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
        char choice = sc.next().charAt(0);
        if(choice=='A' || choice=='a'){
            this.addGuest();
        }else if(choice=='r' || choice=='R'){
            this.mainMenu();
        }
        
        
    }
     
     void mainMenu(){
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
         int choice = sc.nextInt();
         if(choice ==1 ) addGuest();
         if(choice==2) addRoom();
         if(choice==3 ) addBooking();
         if(choice==4) viewBookings();
         if(choice==5) quit();
     }
     void quit(){
         System.out.println("Thanks for using FedUni Hotel Bookings");
     }
     static int dateToDayNumber(int month, int day) {
// Catch invalid input and return early
        if (month < 1 || month > 12 || day < 1 || day > 31) return 0;
        if (month == 1 ) return day;
        if (month == 2 ) return 31 + day;
        if (month == 3 ) return 59 + day;
        if (month == 4 ) return 90 + day;
        if (month == 5 ) return 120 + day;
        if (month == 6 ) return 151 + day;
        if (month == 7 ) return 181 + day;
        if (month == 8 ) return 212 + day;
        if (month == 9 ) return 243 + day;
        if (month == 10) return 273 + day;
        if (month == 11) return 304 + day;
        return 334 + day;
}
    

 void addRoom(){
     System.out.println("Please enter room number");
      int room_number = sc.nextInt();
     
     if(!rooms.contains(room_number)){
         
          rooms.add(room_number);
     System.out.println("Please enter room capacity:");
     int room_capacity = sc.nextInt();
     capacity.add(room_capacity);
     System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
     char choice =sc.next().charAt(0);
     if(choice=='a' || choice=='A'){
         this.addRoom();
     }else{
         this.mainMenu();
     }
     }else{
         System.out.println("Room already exists");
         addRoom();
     }
    
}

void addBooking(){
    System.out.println("Please enter guest ID ");
    int guest_id = sc.nextInt();
    while(guest_id>guests.size() || guest_id<=0){
        System.out.println("Guest ID does not exist");
        addBooking();
    }
    System.out.println("Please enter room number: ");
    int roomno = sc.nextInt();
    while(!rooms.contains(roomno)){
        roomnumber();
        roomno = sc.nextInt();
    }
    System.out.println("Please enter number of guests : ");
    int number_of_guests =sc.nextInt();
    int index = rooms.indexOf(roomno);
    while(number_of_guests>capacity.get(index)){
        System.out.println("Number of guests exceeds the capacity of room : " + capacity.get(index));
        
        roomnumber();
        roomno = sc.nextInt();
        System.out.println("Please enter number of guests : ");
        number_of_guests =sc.nextInt();
        
    }
    noofguests.add(index,number_of_guests);
    System.out.println("Please enter check-in month: ");
    int checkin_month = sc.nextInt();
    while(checkin_month>12 || checkin_month<=0){
        System.out.println("Invalid month. Please enter check-in month:");
        checkin_month = sc.nextInt();
    }
    
    System.out.println("Please enter check-in day:");
    int checkin_day = sc.nextInt();
    while(getDays(checkin_month)<checkin_day){
        System.out.println("Invalid day. Please enter check-in day:");
        checkin_day = sc.nextInt();
    }
    int start = dateToDayNumber( checkin_month,checkin_day);
    
   
    
    System.out.println("Please enter check-out month:");
    int checkout_month = sc.nextInt();
    
    System.out.println("Please enter check-out day:");
    int checkout_day = sc.nextInt();
    int end = dateToDayNumber( checkout_month,checkout_day);
    
    if(start>=endday.get(index)){
        System.out.println("*** Booking Successful ***");
        startday.add(index, start);
        endday.add(index,end);
        startdays.add(index,checkin_day);
        enddays.add(index,checkout_day);
        startmonth.add(index,checkin_month);
        endmonth.add(index,checkout_month);
        
    }
    else{
        System.out.println("Room is not available during that period.");
        addBooking();
    }
    endday.add(index+1,0);
    startday.add(index+1,0);
    
    System.out.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");
    
    char choice =sc.next().charAt(0);
     if(choice=='a' || choice=='A'){
         addBooking();
     }else{
         mainMenu();
     }
    

}
void viewBookings(){
    System.out.println("Would you like to view [G]uest bookings, [R]oom booking, or e[X]it?");
    char choice = sc.next().charAt(0);
    if(choice == 'G'){
        guestBooking();
    }else if(choice=='R'){
        roomBooking();
    }else{
        mainMenu();
    }
    
}
void guestBooking(){
    System.out.println("Please enter guest ID:");
    int guest_id = sc.nextInt();
    int ind = guest_id-1;
    if(guests.size()>=ind){
        System.out.println("Guest " + guest_id + " :  " + guests.get(ind));
        System.out.println("Booking : Room " + rooms.get(ind) + " ," +  noofguests.get(ind) + "guest[s] from  " + 
        startmonth.get(ind) + "/" + startdays.get(ind) + " to " + endmonth.get(ind) + "/" + enddays.get(ind));
         
         viewBookings();
    }else{
        System.out.println("Guest does not exist");
        guestBooking();
    }
}
void roomBooking(){
    System.out.println("Please enter room number:");
    int room_number = sc.nextInt();
    
    if(rooms.contains(room_number)){
        int ind = rooms.indexOf(room_number);
        System.out.println("Room " + room_number + " bookings");
        System.out.println("Guest :  " + guests.get(ind) + " ," +  noofguests.get(ind) + "guest[s] from  " + 
        startmonth.get(ind) + "/" + startdays.get(ind) + " to " + endmonth.get(ind) + "/" + enddays.get(ind));
         System.out.println("Would you like to view [G]uest bookings, [R]oom booking, or e[X]it?");
         viewBookings();
        
    }else{
        System.out.println("Room does not exists");
        roomBooking();
    }
}

void roomnumber(){
    System.out.println("Please add room number");
}
int getDays(int month){
    if(month==1 || month==3 || month==5 || month ==7 || month==8 || month==10 || month==12){
        return 31;
    }else if(month==4 || month==6 || month==9 || month==11){
        return 30;
    }else {
        return 28;
    }
}
}
