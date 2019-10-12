public class Booking {
    private int guestId;
    private int roomNumber;
    private int numberOfGuests;
    private int startDay, startMonth, endDay, endMonth, start, end;

    public Booking(int guestId, int roomNumber, int numberOfGuests) {
        this.guestId = guestId;
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
        startDay=0;
        startMonth=0;
        endDay = 0;
        endMonth=0;
        start=0;
        end=0;
    }

    public int getGuestId() {
        return guestId;
    }
    
    

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
    
    
    
}
