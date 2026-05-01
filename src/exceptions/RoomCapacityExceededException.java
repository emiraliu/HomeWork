package exceptions;

public class RoomCapacityExceededException extends Exception{
    public RoomCapacityExceededException(){}
    public RoomCapacityExceededException(String message){
        super(message);
    }

}
