package main;

import booking.BookingManager;
import exceptions.*;
import guests.Guest;
import guests.User;
import hotel.Hotel;
import interfaces.Bookable;
import interfaces.Chargeable;
import rooms.DeluxeRoom;
import rooms.Room;
import rooms.StandardRoom;
import services.HotelService;
import services.LaundryService;
import services.RoomService;
import services.SpaTreatment;
import staff.FrontDeskStaff;
import staff.HousekeepingStaff;
import staff.Staff;

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
        StandardRoom standardRoom = new StandardRoom(104, "Standard", new BigDecimal("75.00"));
        DeluxeRoom deluxeRoom = new DeluxeRoom(4, 105, "Deluxe", new BigDecimal("150.00"));

        hotel.addNewRoom(room101);
        hotel.addNewRoom(room102);
        hotel.addNewRoom(room103);
        hotel.addNewRoom(standardRoom);
        hotel.addNewRoom(deluxeRoom);

        // ===== GUESTS & USERS =====
        Guest guest1 = new Guest(1, "John", "Doe", "john@gmail.com");
        Guest guest2 = new Guest(2, "Jane", "Smith", "jane@gmail.com");
        Guest guest3 = new Guest(3, "Bob", "Brown", "bob@gmail.com");
        User user1 = new User("Manager", 4, "Alice", "Johnson", "alice@gmail.com");

        // ===== SERVICES =====
        RoomService cleaningService = new RoomService(1, "Room Cleaning", new BigDecimal("20.00"));
        RoomService foodDelivery = new RoomService(2, "Food Delivery", new BigDecimal("5.00"));
        SpaTreatment spaTreatment = new SpaTreatment(3, "Spa Treatment", new BigDecimal("25.00"));
        LaundryService laundryService = new LaundryService(4, "Laundry", new BigDecimal("15.00"));

        hotel.addService(cleaningService);
        hotel.addService(foodDelivery);
        hotel.addService(spaTreatment);
        hotel.addService(laundryService);

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
            hotel.makeBooking(2, room102, guest2, LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 2 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(3, room103, guest3, LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 3 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(4, room101, guest1, LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 4 failed: " + e.getMessage());
        }

        // ===== DISPLAY ALL =====
        System.out.println("\n========== ALL ROOMS ==========");
        hotel.displayAllRooms();

        System.out.println("\n========== ALL BOOKINGS ==========");
        hotel.displayAllBookings();

        System.out.println("\n========== ALL SERVICES ==========");
        hotel.displayAllServices();

        System.out.println("\n========== ALL STAFF ==========");
        hotel.displayAllStaff();

        System.out.println("\n========== AVAILABLE ROOMS (May 5 - May 10) ==========");
        hotel.displayAllAvailableRooms(LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10));

        // ===== PART 1 DEMOS =====

        // Task 1.1 - Room: weekly occupancy check
        System.out.println("\n========== TASK 1.1 - WEEKLY OCCUPANCY ==========");
        boolean[] occupancy = {true, true, false, false, false, true, true};
        System.out.println("Has 3 consecutive vacant days: " + room101.hasThreeConsecutiveVacantDays(occupancy));

        // Task 1.2 - User: greeting template
        System.out.println("\n========== TASK 1.2 - GREETING TEMPLATE ==========");
        char[] template = {'H', 'e', 'l', 'l', 'o', ' ', '*', '!'};
        System.out.println(user1.buildGreeting(template));

        // Task 1.3 - Staff: highest priority task
        System.out.println("\n========== TASK 1.3 - HIGHEST PRIORITY TASK ==========");
        int[] priorities = {3, 1, 4, 1, 5, 2};
        System.out.println("Highest priority task index: " + frontDeskStaff.getHighestPriorityTask(priorities));

        // Task 1.4 - StandardRoom: apply discounts
        System.out.println("\n========== TASK 1.4 - APPLY DISCOUNTS ==========");
        char[] codes = {'A', 'B', 'C'};
        System.out.println("Original price: " + standardRoom.getNightlyRate());
        System.out.println("Price after discounts: " + standardRoom.applyDiscounts(codes));

        // ===== PART 2 DEMOS =====

        // Task 2.5 - Hotel: bookings by user
        System.out.println("\n========== TASK 2.5 - BOOKINGS FOR USER ==========");
        hotel.printBookingForUser(user1);

        // Task 2.6 - BookingManager: first unbooked room
        System.out.println("\n========== TASK 2.6 - FIRST UNBOOKED ROOM ==========");
        BookingManager bookingManager = new BookingManager();
        Room[] allRooms = {room101, room102, room103, standardRoom, deluxeRoom};
        Room firstUnbooked = bookingManager.unbookedRoom(allRooms);
        if (firstUnbooked != null) {
            System.out.println("First unbooked room: " + firstUnbooked.getRoomNumber());
        }

        // Task 2.7 - Hotel: service cost for user
        System.out.println("\n========== TASK 2.7 - SERVICE COST ==========");
        HotelService[] serviceArray = {cleaningService, spaTreatment, laundryService};
        System.out.println("Total service cost: " + hotel.calculateServiceCostForUser(serviceArray));

        // Task 2.8 - HousekeepingStaff: count dirty rooms
        System.out.println("\n========== TASK 2.8 - DIRTY ROOMS COUNT ==========");
        char[] cleanStatus = {'C', 'D', 'C', 'D', 'D'};
        System.out.println("Rooms needing cleaning: " + housekeepingStaff.countDirtyRooms(cleanStatus));

        // ===== PART 3 DEMOS =====

        // Task 3.9 - FrontDeskStaff: handle complaints
        System.out.println("\n========== TASK 3.9 - HANDLE COMPLAINTS ==========");
        String[] complaints = {"wifi", "noise", "cleanliness", "parking"};
        frontDeskStaff.handleComplaints(complaints);

        // Task 3.10 - DeluxeRoom: capacity violation
        System.out.println("\n========== TASK 3.10 - CAPACITY VIOLATION ==========");
        int[] nightly = {2, 3, 5, 4};
        System.out.println("Capacity violation: " + deluxeRoom.checkCapacityViolation(nightly));

        // Task 3.11 - LaundryService: weight check
        System.out.println("\n========== TASK 3.11 - WEIGHT CHECK ==========");
        double[] weights = {5.5, 8.0, 4.0, 6.0};
        laundryService.checkWeight(weights);

        // Task 3.12 - RoomService: complete steps
        System.out.println("\n========== TASK 3.12 - COMPLETE STEPS ==========");
        char[] steps = {'-', 'P', '-', 'C', '-'};
        cleaningService.completeSteps(steps);

        // ===== PART 4 DEMOS =====

        // Task 4.13 - Hotel: add room safe
        System.out.println("\n\n========== TASK 4.13 - DUPLICATE ROOM CHECK ==========");
        try {
            hotel.addRoomSafe(new Room(101, "Standard", new BigDecimal("50.00")));
        } catch (DuplicateRoomException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            hotel.addRoomSafe(new Room(106, "Suite", new BigDecimal("250.00")));
            System.out.println("Room 106 added successfully!");
        } catch (DuplicateRoomException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Task 4.14 - Hotel: check room pricing
        System.out.println("\n========== TASK 4.14 - ROOM PRICING CHECK ==========");
        Room[] pricingCheck = {
                new Room(201, "Standard", new BigDecimal("0.00")),
                new Room(202, "Deluxe", new BigDecimal("-50.00")),
                new Room(203, "Suite", new BigDecimal("150.00"))
        };
        hotel.checkRoomPricing(pricingCheck);

        // Task 4.15 - HotelService: validate discount codes
        System.out.println("\n========== TASK 4.15 - VALIDATE DISCOUNT CODES ==========");
        char[] discountCodes = {'A', 'b', '1', 'C', '@'};
        cleaningService.validateDiscountCodes(discountCodes);

        // Task 4.16 - BookingManager: print guest names
        System.out.println("\n========== TASK 4.16 - GUEST NAMES PER ROOM ==========");
        bookingManager.printGuestNamesRooms(allRooms);

        // Task 4.17 - Hotel: room capacity check
        System.out.println("\n========== TASK 4.17 - ROOM CAPACITY CHECK ==========");
        Room[] capacityRooms = {room101, deluxeRoom};
        try {
            hotel.checkRoomCapacity(capacityRooms, 3);
        } catch (RoomCapacityExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Task 4.18 - BookingManager: validate booking dates
        System.out.println("\n========== TASK 4.18 - VALIDATE BOOKING DATES ==========");
        // valid dates
        String[] validCheckIns  = {"2026-05-01", "2026-06-01"};
        String[] validCheckOuts = {"2026-05-10", "2026-06-15"};
        try {
            bookingManager.validateBookingDates(validCheckIns, validCheckOuts);
            System.out.println("All dates are valid!");
        } catch (InvalidBookingDatesException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // invalid dates - exception triggered
        String[] invalidCheckIns  = {"2026-05-01", "2026-06-01", "2026-07-10"};
        String[] invalidCheckOuts = {"2026-05-10", "2026-05-30", "2026-07-08"};
        try {
            bookingManager.validateBookingDates(invalidCheckIns, invalidCheckOuts);
            System.out.println("All dates are valid!");
        } catch (InvalidBookingDatesException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Task 4.19 - HotelService: apply tier discounts
        System.out.println("\n========== TASK 4.19 - TIER DISCOUNTS ==========");
        double[] costs = {100.0, 200.0, 150.0};
        char[] tiers = {'A', 'B', 'C'};
        HotelService.applyTierDiscount(costs, tiers);

        // Task 4.20 - Hotel: duplicate guest bookings
        System.out.println("\n========== TASK 4.20 - DUPLICATE GUEST BOOKINGS ==========");
        try {
            hotel.checkDuplicateGuestBookings(allRooms);
        } catch (DuplicateGuestBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ===== POLYMORPHISM =====
        System.out.println("\n========== STAFF DUTIES ==========");
        for (Staff s : hotel.getStaff()) {
            s.performDuties();
        }

        System.out.println("\n========== SERVICE COSTS ==========");
        for (HotelService service : hotel.getServices()) {
            System.out.println(service.getDescription() + " costs: " + service.calculateCost());
        }

        // ===== GREETINGS =====
        System.out.println("\n========== GREETINGS ==========");
        frontDeskStaff.greet();
        frontDeskStaff.greet(guest1.getFirstName());

        // ===== TOTAL CHARGES =====
        System.out.println("\n========== TOTAL CHARGES ==========");
        ArrayList<Chargeable> charges = new ArrayList<>();
        charges.add((Chargeable) cleaningService);   // cast to Chargeable
        charges.add((Chargeable) spaTreatment);      // cast to Chargeable
        charges.add((Chargeable) laundryService);    // cast to Chargeable
        System.out.println("Total Charges: " + hotel.calculateTotalCharge(charges));

        // ===== UNIQUE COST CALCULATIONS =====
        System.out.println("\n========== UNIQUE COST CALCULATIONS ==========");
        System.out.println("Room Cleaning with fee: " + cleaningService.calculateCost("1.20"));
        System.out.println("Spa Treatment with tip: " + spaTreatment.calculateCost("10.00"));

        // ===== SPA BOOKING =====
        System.out.println("\n========== BOOKING SPA TREATMENT ==========");
        Bookable bookableSpa = (Bookable) spaTreatment; // cast to Bookable
        System.out.println("Is spa booked? " + bookableSpa.isBookedForDates(
                LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10)));
        bookableSpa.markAsBooked();
        System.out.println("After booking - Is spa booked? " + bookableSpa.isBookedForDates(
                LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 10)));
    }
}