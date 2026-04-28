public class HousekeepingStaff extends Staff{

    public HousekeepingStaff(int staffId,String name, String department){
        super(staffId,name,department);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is working!");
    }

    @Override
    public String toString(){
        return "Role: Housekeeping Staff" +
                "\nStaff Id: " + getStaffId() +
                "\nName: " + getName() +
                "\nDepartment: " + getDepartment() + "\n";
    }
}
