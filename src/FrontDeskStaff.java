public class FrontDeskStaff extends Staff{

    public FrontDeskStaff(int staffId,String name, String department){
        super(staffId,name,department);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " started Working!");
    }

    public void greet(){
        System.out.println("Welcome to the hotel!");
    }

    public void greet(String guestName){
        System.out.println("Welcome to the hotel, " + guestName + "!");
    }

    @Override
    public String toString(){
        return "Role: Front Desk Staff" +
                "\nStaff Id: " + staffId +
                "\nName: " + name +
                "\nDepartment: " + department + "\n";
    }
}
