package guests;

public class User extends Guest {

    private String role;

    public User(){}
    public User(String role,int guestId,String firstName, String lastName, String email){
        super(guestId,firstName,lastName,email);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String buildGreeting(char[] template){
        String bGreeting = "";
        for (int i = 0; i< template.length;i++){
            if (template[i] == '*') bGreeting += role.charAt(0);
            else bGreeting += template[i];
        }
        return bGreeting;
    }

    @Override
    public String toString(){
        return "\nRole: " + role +
                "\nGuests.Guest Id: " + getGuestId() +
                "\nFirst Name: " + getFirstName() +
                "\nLast Name: " + getLastName() +
                "\nEmail: " + getEmail();
    }
}
