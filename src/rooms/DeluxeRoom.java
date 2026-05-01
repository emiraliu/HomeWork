package rooms;

import java.math.BigDecimal;

public class DeluxeRoom extends Room {

    private int bedCapacity;

    public DeluxeRoom(int bedCapacity,int roomNumber, String roomType, BigDecimal nightlyRate){
        super( roomNumber, roomType, nightlyRate);
        this.bedCapacity = bedCapacity;
    }

    public boolean checkCapacityViolation(int[] nightlyOccupancy){
        for (int i : nightlyOccupancy){
            if (i > bedCapacity) return true;
        }
        return false;
    }

    public int getBedCapacity(){return bedCapacity;}

    @Override
    public String toString(){
        return "\nRooms.Room Number: " + getRoomNumber() +
                "\nRooms.Room Type: " + getRoomType() +
                "\nNightly Rate: " + getNightlyRate() +
                "\nBed Capacity: " + bedCapacity +
                "\nIs Available: " + isAvailable();
    }
}
