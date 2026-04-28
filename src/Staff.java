public abstract class Staff {
    private int staffId;
    private String name,department;

    public Staff(){}

    public Staff(int staffId,String name,String department){
        this.staffId = staffId;
        this.name = name;
        this.department = department;
    }
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract void performDuties();

    @Override
    public String toString(){
        return "Staff Id: " + staffId +
                "\nName: " + name +
                "\nDepartment: " + department + "\n";
    }
}
