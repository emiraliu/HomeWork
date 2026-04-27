public class FrontDeskStaff extends Staff{
    @Override
    public void performDuties() {

    }

    @Override
    public String toString(){
        return null;
    }

    public void greet(){
        System.out.println("Welcome to the hotel!");
    }
    public void greet(String guestName){
        System.out.println("Welcome to the hotel, " + guestName + "!");
    }
}
