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

    public void handleComplaints(String[] complaints){
        for (String complaint : complaints){
            switch (complaint){
                case "wifi":
                    System.out.println("We will fix the wifi immediately!");
                    break;
                case "cleanliness":
                    System.out.println("We will send housekeeping right away!");
                    break;
                case "noise":
                    System.out.println("We will address the noise issue!");
                    break;
                default:
                    System.out.println("We will look into your complaint");
                    break;
            }
        }
    }

    @Override
    public String toString(){
        return "Role: Front Desk Staff" +
                "\nStaff Id: " + staffId +
                "\nName: " + name +
                "\nDepartment: " + department + "\n";
    }
}
