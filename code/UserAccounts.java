import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserAccounts {


    private ArrayList <UserAccounts>allUsers = new ArrayList<>();
    private String firstName ;
    private String lastName;
    private String address;
    private String password;
    private String email;

    public UserAccounts(String firstName, String lastName, String address,String email,String password){
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPassword(password);
        setEmail(email);


    }

    public UserAccounts(){



    }

    public void setFirstName(String firstName){
        this.firstName = firstName;

    }
    public void setLastName(String lastName){
            this.lastName=lastName;
    }
    public void setAddress(String address){
            this.address=address;
    }

    public void setEmail(String email){
        this.email = email;

    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }
    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public ArrayList<UserAccounts> getAllUsers(){
        return allUsers;

    }

    public void AddUserToArray(UserAccounts user){
        allUsers.add(user);
    }

    public static void ValidateUser(String emailAddress,String passwordChk){
            UserAccounts checkingUser = new UserAccounts();
            for(var user : checkingUser.getAllUsers()){
                if(user.email.equals(emailAddress)&& user.password.equals(passwordChk)){
                    System.out.println(user);
                }
                else
                {
                    System.out.println("You have entered the wrong email or password");
                }
            }

    }



    @Override
    public String toString() {
        return "UserAccounts{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
