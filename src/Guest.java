public class Guest {

    private int guestId;
    private String firstName,lastName,email;

    public Guest(){

    }
    public Guest(int guestId,String firstName, String lastName, String email){
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getGuestId(){return guestId;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setEmail(String email){this.email = email;}

    @Override
    public String toString(){
        return "\nGuest Id: " + guestId +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email;
    }
}
