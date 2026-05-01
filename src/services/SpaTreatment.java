package services;

import java.math.BigDecimal;
import java.time.LocalDate;

import interfaces.Bookable;

public class SpaTreatment extends HotelService implements Bookable{

    private boolean isBooked;

    public SpaTreatment(int serviceId,String description,BigDecimal baseCost){

        super(serviceId,description,baseCost);
        isBooked= false;
    }
    @Override
    public BigDecimal calculateCost() {
        return getBaseCost();
    }
    public BigDecimal calculateCost(String tip){
        return getBaseCost().add(new BigDecimal(tip));
    }

    @Override
    public String toString() {
        return "Service Id: " + getServiceId() +
                "\nDescription: " + getDescription() +
                "\nBase Cost: " + getBaseCost() +
                "\nIs Booked: " + isBooked + "\n";
    }

    @Override
    public boolean isBookedForDates(LocalDate checkIn, LocalDate checkOut) {
        return isBooked;
    }

    @Override
    public void markAsBooked() {
        this.isBooked = true;
    }
}
