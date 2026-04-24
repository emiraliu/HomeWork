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

        if (!checkOut.isAfter(checkIn)){
            System.out.println("Invalid dates! Check-out must be after check-in.");
            return;
        }

        boolean isRoomAvailable = true;
        for (Booking booking : bookings){
            if (booking.getReservedRoom().equals(room)){
                boolean overlaps = checkIn.isBefore(booking.getCheckOut()) &&
                        checkOut.isAfter(booking.getCheckIn());
                if (overlaps){
                    isRoomAvailable = false;
                    break;
                }
            }
        }

        if (isRoomAvailable){
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
                bookings.remove(booking);
                System.out.println("Booking "+ bookingId + " cancelled.");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public void displayAllRooms(){
        for (Room room : rooms) {
            System.out.println(room);
        }
    }


//==========================================================
    public void displayAllAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        for (Room room : rooms) {

            boolean available = true;

            for (Booking booking : bookings) {
                if (booking.getReservedRoom().equals(room)) {

                    boolean overlaps =
                            checkIn.isBefore(booking.getCheckOut()) &&
                                    checkOut.isAfter(booking.getCheckIn());

                    if (overlaps) {
                        available = false;
                        break;
                    }
                }
            }

            if (available) {
                System.out.println(room.toString());
            }
        }
    }
//===========================================

    public void displayAllBookings(){
        for (Booking booking : bookings){
            System.out.println(booking + "\n");
        }
        System.out.println(" ");
    }

}
