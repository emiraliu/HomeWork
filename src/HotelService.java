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

    public void validateDiscountCodes(char[] codes){
        for (char code : codes){
            if(code >= 'A' && code <= 'Z'){
                System.out.println(code + " is a valid discount code.");
            }else {
                System.out.println(code + " is not a valid discount code!");
            }
        }
    }

    @Override
    public String toString() {
        return "Service Id: " + serviceId +
                "\nDescription: " + description +
                "\nBase Cost: " + baseCost + "\n";
    }
}
