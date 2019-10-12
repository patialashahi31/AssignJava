public class Room{

    private int roomNumber;
    private int capacity;
    private boolean isBooked;
    

    public Room(int roomNumber, int capacity) {
        
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.isBooked = false;
    }
   
    
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean isBooked) {
        
        this.isBooked = isBooked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return roomNumber == room.roomNumber;
    }

}
