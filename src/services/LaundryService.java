package services;

import java.math.BigDecimal;

public class LaundryService extends HotelService {

    public LaundryService(int serviceId, String description, BigDecimal baseCost){
        super(serviceId,description,baseCost);
    }

    public void checkWeight(double[] weights){
        double weight = 0;
        for (double w : weights){
            weight += w;
        }
        if (weight > 20) System.out.println("The weight is too heavy!");
        else System.out.println("The weight is under 20kg");
    }

    @Override
    public BigDecimal calculateCost() {
        return getBaseCost();
    }

    @Override
    public String toString() {
        return "Service Id: " + getServiceId() +
                "\nDescription: " + getDescription() +
                "\nBase Cost: " + getBaseCost() + "\n";
    }
}
