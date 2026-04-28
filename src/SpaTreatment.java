import java.math.BigDecimal;

public class SpaTreatment extends HotelService{

    public SpaTreatment(int serviceId,String description,BigDecimal baseCost){
        super(serviceId,description,baseCost);
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
                "\nBase Cost: " + getBaseCost() + "\n";
    }
}
