import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Room room101 = new Room(1,"Mega Lukës",15000);
        System.out.println(room101);
        Guest cali = new Guest(1,"Fejsal","Zurapi","protexkingi@gmail.com");
        System.out.println(cali);
        Booking booking1 = new Booking(1,room101,cali, LocalDate.now(),LocalDate.of(2026,5,10));
        System.out.println("=================================");
        System.out.println(booking1);

    }


}
