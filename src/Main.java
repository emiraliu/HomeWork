import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("H");

        Room room101 = new Room(101,"Standard",new BigDecimal("50.00"));
        Room room102 = new Room(102,"Deluxe",new BigDecimal("100.00"));
        Room room103 = new Room(103,"Suite",new BigDecimal("200.00"));

        hotel.addNewRoom(room101);
        hotel.addNewRoom(room102);
        hotel.addNewRoom(room103);

        Guest guest1 = new Guest(1,"Pers1F","Pers1S","pers1@gmail.com");
        Guest guest2 = new Guest(2,"Pers2F","Pers2S","pers1@gmail.com");
        Guest guest3 = new Guest(3,"Pers3F","Pers3S","pers1@gmail.com");

        hotel.makeBooking(1,room101,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));
        hotel.makeBooking(2,room102,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));
        hotel.makeBooking(3,room103,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));
        hotel.makeBooking(4,room101,guest1,LocalDate.of(2026,6,5),LocalDate.of(2026,6,10));
        hotel.makeBooking(5,room101,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));

        hotel.cancelBooking(3);

        hotel.displayAllRooms();
        System.out.println(" ");
        hotel.displayAllBookings();
        System.out.println("=============================");

        hotel.displayAllAvailableRooms(LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));

    }


}
