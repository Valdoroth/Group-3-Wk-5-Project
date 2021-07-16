import java.io.IOException;
import java.util.List;

public class Users {
    private static List<Integer> booksCheckedOut;
    //private ArrayList <UserAccounts>allUsers = new ArrayList<>();
    private final String email;
    private final String password;
    private final String firstName ;
    private final String lastName;
    public static String currentUser;


    public Users(String emailInput, String passwordInput, String firstNameInput, String lastNameInput, List<Integer> userBooksCheckedOutInput) {
        this.email = emailInput;
        this.password = passwordInput;
        this.firstName = firstNameInput;
        this.lastName =lastNameInput;
        booksCheckedOut = userBooksCheckedOutInput;
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
                System.out.println("RETURNING " + user.email);
                currentUser = user.email;
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

    public static Users createUser(String emailCreate, String passwordCreate, String firstNameCreate, String lastNameCreate, List<Integer> booksCheckedOutCreate) throws IOException {
        Users name = new Users(emailCreate, passwordCreate, firstNameCreate, lastNameCreate, booksCheckedOutCreate);
        name.addUserToArray(name);
        System.out.println(name);
        return name;
    }

    public void addUserToArray(Users user) throws IOException {
        List<Users> allUsers = FileAccess.getUsers();
        allUsers.add(user);
        FileAccess.setUsers(allUsers);
        FileAccess.getUsers();
    }

    public static List<Integer> getBooksCheckedOut() {
        return booksCheckedOut;
    }

    public static void updateCurrentUserBooks(int bookIdIAmCheckingOut) {
        getBooksCheckedOut().add(bookIdIAmCheckingOut);
        booksCheckedOut = getBooksCheckedOut();
        hasCheckedOut();


    }

    //returns book info for the titles this user has checked out. Should be in user class?
    public static void hasCheckedOut() {
        System.out.println("You currently have these titles out: ");
        for(Books i : FileAccess.bookList){
            for (int j : booksCheckedOut){
                if(i.getID() == j){
                    System.out.println("\t" + i.getID() + ". " + i.getTitle() );
                }
            }
        }
    }
}
