import java.io.IOException;
import java.util.List;

public class Users {
    //private ArrayList <UserAccounts>allUsers = new ArrayList<>();
    private String email;
    private String password;
    private String firstName ;
    private String lastName;
    private List<String> booksCheckedOut;

    public Users(){
    }

    public Users(String email, String password, String firstName, String lastName, List<String> booksCheckedOut) {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setBooksCheckedOut(booksCheckedOut);
    }

    private void setBooksCheckedOut(List<String> booksCheckedOut) {
        this.booksCheckedOut = booksCheckedOut;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
            this.lastName=lastName;
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

    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void AddUserToArray(Users user) throws IOException {
        List<Users> allUsers = FileAccess.getUsers();
        allUsers.add(user);
        FileAccess.setUsers(allUsers);
    }

    public static void ValidateUser(String emailAddress,String passwordChk){
            List<Users> checkingUser = FileAccess.getUsers();
            for(var user : checkingUser){
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
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public List<String> getBooksCheckedOut() {
        return booksCheckedOut;
    }
}
