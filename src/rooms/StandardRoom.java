package rooms;

import java.math.BigDecimal;

public class StandardRoom extends Room {
    public StandardRoom(){}
    public StandardRoom(int roomNumber, String roomType, BigDecimal nightlyRate){
        super(roomNumber,roomType,nightlyRate);
    }

    public BigDecimal applyDiscounts(char[] codes){
        BigDecimal price = getNightlyRate(); // start with original price

        for (char code : codes){
            switch(code){
                case 'A':
                    price = price.multiply(new BigDecimal("0.90")); // 10% off
                    break;
                case 'B':
                    price = price.multiply(new BigDecimal("0.80")); // 20% off
                    break;
                case 'C':
                    price = price.multiply(new BigDecimal("0.70")); // 30% off
                    break;
                default:
                    System.out.println("Invalid discount code: " + code);
            }
        }
        return price;
    }
    @Override
    public String toString(){
        return "Rooms.Room Type: Standard" +
                "\nRooms.Room Number: " + getRoomNumber() +
                "\nNightly Rate: " + getNightlyRate() +
                "\nIs Available: " + isAvailable();
    }
}
