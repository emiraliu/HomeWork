import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("Grand Hotel");

        Room room101 = new Room(101,"Standard",new BigDecimal("50.00"));
        Room room102 = new Room(102,"Deluxe",new BigDecimal("100.00"));
        Room room103 = new Room(103,"Suite",new BigDecimal("200.00"));

        RoomService cleaningService = new RoomService(1,"Room Cleaning",new BigDecimal("20.00"));
        RoomService foodDelivery = new RoomService(2,"Food Delivery", new BigDecimal("5.00"));
        SpaTreatment spaTreatment = new SpaTreatment(1,"Spa Treatment", new BigDecimal("25.00"));

        FrontDeskStaff frontDeskStaff = new FrontDeskStaff(1,"John","abcd");
        HousekeepingStaff housekeepingStaff = new HousekeepingStaff(1,"Alisa", "abcd");

        hotel.addNewRoom(room101);
        hotel.addNewRoom(room102);
        hotel.addNewRoom(room103);

        hotel.addService(cleaningService);
        hotel.addService(foodDelivery);
        hotel.addService(spaTreatment);

        hotel.addStaff(frontDeskStaff);
        hotel.addStaff(housekeepingStaff);

        Guest guest1 = new Guest(1,"Pers1F","Pers1S","pers1@gmail.com");
        Guest guest2 = new Guest(2,"Pers2F","Pers2S","pers1@gmail.com");
        Guest guest3 = new Guest(3,"Pers3F","Pers3S","pers1@gmail.com");

        hotel.makeBooking(1,room101,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));
        hotel.makeBooking(2,room102,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));
        hotel.makeBooking(3,room103,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));
        hotel.makeBooking(4,room101,guest1,LocalDate.of(2026,6,5),LocalDate.of(2026,6,10));
        hotel.makeBooking(5,room101,guest1,LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));

        hotel.displayAllServices();
        hotel.displayAllStaff();

        hotel.cancelBooking(3);

        hotel.displayAllRooms();
        System.out.println(" ");
        hotel.displayAllBookings();
        System.out.println("=============================");

        hotel.displayAllAvailableRooms(LocalDate.of(2026,5,5),LocalDate.of(2026,5,10));

        System.out.println("=== Staff Duties ===");
        for (Staff staff : hotel.getStaff()){
            staff.performDuties();
        }

        System.out.println("=== Service Costs ===");
        for (HotelService service : hotel.getServices()){
            System.out.println(service.getDescription() + " costs: " + service.calculateCost());
        }

        frontDeskStaff.greet();
        frontDeskStaff.greet(guest1.getFirstName());

        ArrayList<Chargeable> charges = new ArrayList<>();
        charges.add(cleaningService);
        charges.add(spaTreatment);
        System.out.println("Total Charges: " + hotel.calculateTotalCharge(charges));

    }


}
