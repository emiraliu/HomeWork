import java.math.BigDecimal;

public abstract class HotelService implements Chargeable{
    private int serviceId;
    private String description;
    private BigDecimal baseCost;

    public HotelService(){

    }

    public HotelService(int serviceId,String description,BigDecimal baseCost){
        this.serviceId = serviceId;
        this.description = description;
        this.baseCost = baseCost;
    }



    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    public abstract BigDecimal calculateCost();

    @Override
    public String toString() {
        return "Service Id: " + serviceId +
                "\nDescription: " + description +
                "\nBase Cost: " + baseCost + "\n";
    }
}
