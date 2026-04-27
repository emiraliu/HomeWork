import java.math.BigDecimal;

public abstract class HotelService implements Chargeable{
    private int id;
    private String description;
    private BigDecimal cost;

    public abstract BigDecimal calculateCost();
}
