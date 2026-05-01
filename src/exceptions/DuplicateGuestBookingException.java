package exceptions;

public class DuplicateGuestBookingException extends Exception{
    public DuplicateGuestBookingException(){}
    public DuplicateGuestBookingException(String message){
        super(message);
    }
}
