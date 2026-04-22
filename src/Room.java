public class Room {
    private int roomNumber;
    private String roomType;
    private double nightlyRate;
    private boolean isAvailable;

    public Room(){

    }

    public Room(int roomNumber,String roomType,double nightlyRate){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightlyRate = nightlyRate;
        this.isAvailable = true;
    }

    public int getRoomNumber(){return roomNumber;}
    public String getRoomType(){return roomType;}
    public double getNightlyRate(){return nightlyRate;}
    public boolean isAvailable(){return isAvailable;}
    public void setRoomType(String roomType){this.roomType = roomType;}
    public void setNightlyRate(double nightlyRate){this.nightlyRate = nightlyRate;}
    public void setAvailable(boolean isAvailable){this.isAvailable = isAvailable;}

    @Override
    public String toString(){
        return "\nRoom Number: " + roomNumber +
                "\nRoom Type: " + roomType +
                "\nNightly Rate: " + nightlyRate +
                "\nIs Available: " + isAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room other = (Room) obj;
        return this.roomNumber == other.roomNumber;
    }

}
