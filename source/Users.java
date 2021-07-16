import java.io.IOException;
import java.util.List;

public class Users {
    //private ArrayList <UserAccounts>allUsers = new ArrayList<>();
    private String email;
    private String password;
    private String firstName ;
    private String lastName;
    private List<Integer> booksCheckedOut;

    public Users(String email, String password, String firstName, String lastName, List<Integer> userBooksCheckedOut) {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setBooksCheckedOut(userBooksCheckedOut);
    }

    private void setBooksCheckedOut(List<Integer> booksCheckedOut) {
        this.booksCheckedOut = booksCheckedOut;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
            this.lastName= lastName;
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
        this.password = password;
    }

    public static void validateUser(String emailAddress, String passwordChk){
            List<Users> checkingUser = FileAccess.getUsers();
            for(var user : checkingUser){
                if(user.email.equals(emailAddress)&& user.password.equals(passwordChk)){
                    System.out.println("Successfully logged in.");
                }
                else
                {
                    System.out.println("You have entered the wrong email or password");
                }
                break;
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

    public static void createUser(String emailCreate, String passwordCreate, String firstNameCreate, String lastNameCreate, List<Integer> booksCheckedOutCreate) throws IOException {
        Users name = new Users(emailCreate, passwordCreate, firstNameCreate, lastNameCreate, booksCheckedOutCreate);
        name.addUserToArray(name);
        System.out.println(name);
    }

    public void addUserToArray(Users user) throws IOException {
        List<Users> allUsers = FileAccess.getUsers();
        allUsers.add(user);
        FileAccess.setUsers(allUsers);
        FileAccess.getUsers();
    }

    public List<Integer> getBooksCheckedOut() {
        return booksCheckedOut;
    }
}
