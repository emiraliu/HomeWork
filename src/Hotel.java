import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel(){}
    public Hotel(String hotelName){
        this.hotelName = hotelName;
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    public void addNewRoom(Room room){
        rooms.add(room);
    }

    public void makeBooking(int bookingId, Room room, Guest guest, LocalDate checkIn, LocalDate checkOut){
        if (room.isAvailable()){
            room.setAvailable(false);
            Booking booking = new Booking(bookingId,room,guest,checkIn,checkOut);
            bookings.add(booking);
            System.out.println("Booking Successful.");
        }else {
            System.out.println("Room " + room.getRoomNumber() + " is not Available!");
        }
    }
    public void cancelBooking(int bookingId){
        for (Booking booking : bookings){
            if (booking.getBookingId() == bookingId){
                booking.getReservedRoom().setAvailable(true);
                bookings.remove(booking);
                System.out.println("Booking "+ bookingId + " cancelled.");
                return;
            }
        }
        System.out.println("Booking not found!");
    }
    public void displayAllRooms(){
        for (Room room : rooms) {
           if (room.isAvailable()) System.out.println("Room Number: " + room.getRoomNumber());
        };
    }
    public void displayAllBookings(){
        for (Booking booking : bookings){
            booking.toString();
        }
    }
}
