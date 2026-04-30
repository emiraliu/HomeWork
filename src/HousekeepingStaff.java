public class HousekeepingStaff extends Staff{

    public HousekeepingStaff(int staffId,String name, String department){
        super(staffId,name,department);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is working!");
    }

    public int countDirtyRooms(char[] status){
        int count = 0;

        for (char s : status){
            if (s == 'D') count++;
        }

        return count;
    }

    @Override
    public String toString(){
        return "Role: Housekeeping Staff" +
                "\nStaff Id: " + staffId +
                "\nName: " + name +
                "\nDepartment: " + department + "\n";
    }
}
