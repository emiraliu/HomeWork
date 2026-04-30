import java.util.ArrayList;

public class BookingManager {

    private ArrayList<Booking> bookings;

    public BookingManager() {
        bookings = new ArrayList<>();
    }

    public void printGuestNamesRooms(Room[] rooms){
        for (Room room:rooms){
            boolean found = false;
            for (Booking booking : bookings){
                if (booking.getReservedRoom().equals(room)){
                    System.out.println("Room " + room.getRoomNumber() +
                            " is booked by: " + booking.getGuest().getFirstName() + " " +
                            booking.getGuest().getLastName());
                    found = true;
                    break;
                }
            }
        }
    }

    public Room unbookedRoom(Room[] rooms){
        for (Room room : rooms){
            if (room.isAvailable()) return room;
        }
        System.out.println("No Room Is Available!");
        return null;
    }
}
