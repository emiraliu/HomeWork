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

    public void completeSteps(char[] steps){
        int step = 0;
        while (step < steps.length){
            steps[step] = 'X';
            step++;
        }
        step = 0;
        while (step < steps.length){
            System.out.print(steps[step] + " ");
            step++;

        }
    }

    @Override
    public String toString() {
        return "Service Id: " + getServiceId() +
                "\nDescription: " + getDescription() +
                "\nBase Cost: " + getBaseCost() + "\n";
    }

}
