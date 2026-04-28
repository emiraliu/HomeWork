import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;
    private ArrayList<HotelService> services;
    private ArrayList<Staff> staff;


    public Hotel(){}
    public Hotel(String hotelName){
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.services = new ArrayList<>();
        this.staff = new ArrayList<>();
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

    public void addService(HotelService service){
        this.services.add(service);
    }
    public void addStaff(Staff staff){
        this.staff.add(staff);
    }
    public void displayAllServices(){
        for (HotelService service : services){
            System.out.println(service);
        }
    }
    public void displayAllStaff(){
        for (Staff staff1 : staff){
            System.out.println(staff1);
        }
    }

    public BigDecimal calculateTotalCharge(ArrayList<Chargeable> chargeableItems){
        BigDecimal total = BigDecimal.ZERO;
        for (Chargeable item: chargeableItems){
            total = total.add(item.calculateCost());
        }
        return total;
    }

    public ArrayList<HotelService> getServices() { return services; }
    public ArrayList<Staff> getStaff() { return staff; }
    public ArrayList<Room> getRooms() { return rooms; }

}
