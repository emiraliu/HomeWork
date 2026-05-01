package booking;

import exceptions.InvalidBookingDatesException;
import rooms.Room;

import java.time.LocalDate;
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
                    System.out.println("Rooms.Room " + room.getRoomNumber() +
                            " is booked by: " + booking.getGuest().getFirstName() + " " +
                            booking.getGuest().getLastName());
                    found = true;
                    break;
                }
            }
        }
    }

    public void validateBookingDates(String[] checkIns,String[] checkOuts) throws InvalidBookingDatesException {
        for (int i =0;i<checkIns.length;i++){
            LocalDate checkIn = LocalDate.parse(checkIns[i]);
            LocalDate checkOut = LocalDate.parse(checkOuts[i]);
            if (!checkOut.isAfter(checkIn)){
                throw new InvalidBookingDatesException("Invalid dates at index " + i +
                       ": CheckOut must be after CheckIn!" );
            }
        }
    }

    public Room unbookedRoom(Room[] rooms){
        for (Room room : rooms){
            if (room.isAvailable()) return room;
        }
        System.out.println("No Rooms.Room Is Available!");
        return null;
    }
}
