import java.io.IOException;
import java.util.List;

public class Users {
    //private ArrayList <UserAccounts>allUsers = new ArrayList<>();
    private String email;
    private String password;
    private String firstName ;
    private String lastName;
    private List<Integer> booksCheckedOut;

    public Users(String emailInput, String passwordInput, String firstNameInput, String lastNameInput, List<Integer> userBooksCheckedOutInput) {
        this.email = emailInput;
        this.password = passwordInput;
        this.firstName = firstNameInput;
        this.lastName =lastNameInput;
        this.booksCheckedOut = userBooksCheckedOutInput;
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

    public void addUserToArray(Users addedUser) throws IOException {
        List<Users> allUsers = FileAccess.getUsers();
        allUsers.add(addedUser);
        FileAccess.setUsers(allUsers);
        FileAccess.getUsers();
    }

    public List<Integer> getBooksCheckedOut() {
        return booksCheckedOut;
    }
}