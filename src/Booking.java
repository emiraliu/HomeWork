import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private Room reservedRoom;
    private Guest guest;
    private LocalDate checkIn,checkOut;

    public Booking(){}
    public Booking(int bookingId,Room reservedRoom,Guest guest,LocalDate checkIn,LocalDate checkOut){
        this.bookingId = bookingId;
        this.reservedRoom = reservedRoom;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getBookingId() {return bookingId;}
    public Room getReservedRoom(){return reservedRoom;}
    public Guest getGuest(){return guest;}
    public LocalDate getCheckIn(){return checkIn;}
    public LocalDate getCheckOut(){return checkOut;}

    @Override
    public String toString(){
        return "Booking Id: " + bookingId +
                "\nRoom number: " + reservedRoom.getRoomNumber() +
                "\nGuest Name: " + guest.getFirstName() + " " + guest.getLastName() +
                "\nCheck-In: " + checkIn +
                "\nCheck-Out: " + checkOut;
    }

}
