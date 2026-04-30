import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // ===== HOTEL INITIALIZATION =====
        Hotel hotel = new Hotel("Grand Hotel");

        // ===== ROOMS =====
        Room room101 = new Room(101, "Standard", new BigDecimal("50.00"));
        Room room102 = new Room(102, "Deluxe", new BigDecimal("100.00"));
        Room room103 = new Room(103, "Suite", new BigDecimal("200.00"));

        hotel.addNewRoom(room101);
        hotel.addNewRoom(room102);
        hotel.addNewRoom(room103);

        // ===== GUESTS =====
        User guest1 = new User("Guest",1, "Pers1F", "Pers1S", "pers1@gmail.com");
        Guest guest2 = new Guest(2, "Pers2F", "Pers2S", "pers2@gmail.com");
        Guest guest3 = new Guest(3, "Pers3F", "Pers3S", "pers3@gmail.com");

        // ===== SERVICES =====
        RoomService cleaningService = new RoomService(1, "Room Cleaning", new BigDecimal("20.00"));
        RoomService foodDelivery = new RoomService(2, "Food Delivery", new BigDecimal("5.00"));
        SpaTreatment spaTreatment = new SpaTreatment(3, "Spa Treatment", new BigDecimal("25.00"));

        hotel.addService(cleaningService);
        hotel.addService(foodDelivery);
        hotel.addService(spaTreatment);

        // ===== STAFF =====
        FrontDeskStaff frontDeskStaff = new FrontDeskStaff(1, "John", "Front Desk");
        HousekeepingStaff housekeepingStaff = new HousekeepingStaff(2, "Alisa", "Housekeeping");

        hotel.addStaff(frontDeskStaff);
        hotel.addStaff(housekeepingStaff);

        // ===== BOOKINGS =====
        try {
            hotel.makeBooking(1, room101, guest1, LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 1 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(2, room102, guest1, LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 2 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(3, room103, guest1, LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 3 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(4, room101, guest1, LocalDate.of(2026, 6, 5), LocalDate.of(2026, 6, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 4 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(5, room101, guest1, LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 5 failed: " + e.getMessage());
        }
        hotel.cancelBooking(3);

        // ===== DISPLAY =====
        System.out.println("========== ALL ROOMS ==========");
        hotel.displayAllRooms();

        System.out.println("\n========== ALL BOOKINGS ==========");
        hotel.displayAllBookings();

        System.out.println("========== ALL SERVICES ==========");
        hotel.displayAllServices();

        System.out.println("========== ALL STAFF ==========");
        hotel.displayAllStaff();

        System.out.println("========== AVAILABLE ROOMS (May 5 - May 10) ==========");
        hotel.displayAllAvailableRooms(LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));

        // ===== POLYMORPHISM =====
        System.out.println("\n========== STAFF DUTIES ==========");
        for (Staff staff : hotel.getStaff()) {
            staff.performDuties();
        }

        System.out.println("\n========== SERVICE COSTS ==========");
        for (HotelService service : hotel.getServices()) {
            System.out.println(service.getDescription() + " costs: " + service.calculateCost());
        }

        // ===== GREETINGS =====
        System.out.println("\n========== GREETINGS ==========");
        frontDeskStaff.greet();
        frontDeskStaff.greet(guest1.getFirstName());

        System.out.println("\n========== TOTAL CHARGES ==========");
        ArrayList<Chargeable> charges = new ArrayList<>();
        charges.add(cleaningService);
        charges.add(spaTreatment);
        System.out.println("Total Charges: " + hotel.calculateTotalCharge(charges));

        System.out.println("============================================");
        hotel.printBookingForUser(guest1);
    }
}