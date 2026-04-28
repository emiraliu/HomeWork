import java.math.BigDecimal;

public class RoomService extends HotelService{

    public RoomService(int serviceId,String description,BigDecimal baseCost){
        super(serviceId,description,baseCost);
    }

    @Override
    public BigDecimal calculateCost() {
        return getBaseCost();
    }

    public BigDecimal calculateCost(String fee) {
        return getBaseCost().multiply(new BigDecimal(fee));
    }

    @Override
    public String toString() {
        return "Service Id: " + getServiceId() +
                "\nDescription: " + getDescription() +
                "\nBase Cost: " + getBaseCost() + "\n";
    }
}
