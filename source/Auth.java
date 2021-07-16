import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auth {

    private Scanner input = new Scanner(System.in);
    private String email;
    private String password;

    public Auth() {
        password = "";
        email = "";
    }

    public void start() throws IOException {
        String action = "";
        System.out.println("Welcome to the V.A.J.J. Library System");
        while (!action.equalsIgnoreCase("L") && !action.equalsIgnoreCase("S")) {
            System.out.println(" Please enter L for Login or S for Signup ");
            action = input.nextLine();

            if (!action.equalsIgnoreCase("L") && !action.equalsIgnoreCase("S")) {
                System.out.println("Check your entry and try again");
            } else {
                System.out.println("Thank you");
                System.out.println();
            }
        }
        if (action.equalsIgnoreCase("L")) {
            login();

        } else {
            signUp();
        }

    }

    public void login() {
        boolean isValidated = false;

        while (!isValidated) {
            System.out.println("Enter your Email Address");
            email = input.nextLine();
            isValidated = validateEmail(email);
        }

        while (!passWordValidator(password)) {
            System.out.println("Enter your password");
            password = input.nextLine();
            passWordValidator(password);
            System.out.println(passWordValidator(password));
            if (!passWordValidator(password)) {
                System.out.println(" Password invalid please try again");
            } else if (passWordValidator(password)) {
             Users.validateUser(email, password);
            }

        }

    }


    private void signUp() throws IOException {
        String firstName;
        String lastName;
        //String address = "";
        boolean isEmailValid = false;
        boolean isPasswordValid = false;
        String passwordChk = "";

        System.out.println();
        System.out.println("Welcome New User ");
        System.out.println("Please enter your first name");
        firstName = input.nextLine();
        System.out.println("Please enter your last Name");
        lastName = input.nextLine();
        //System.out.println(" Please enter your address");
        //address = input.nextLine();
        while (!isEmailValid) {
            System.out.println(" Please enter your Email Address");
            email = input.nextLine();
            isEmailValid = validateEmail(email);
            if (!isEmailValid) {
                System.out.println("Not a valid email try again");
            }
        }
        while (!isPasswordValid) {
            while (!password.equals(passwordChk) || password.length() == 0) {
                System.out.println(" Please enter your password,it must be at least 6 characters long" +
                        " and contain one capital letter and one of these special characters @#$%^&+=");
                password = input.nextLine();
                System.out.println(" Please re-enter your password");
                passwordChk = input.nextLine();
                if (!password.equals(passwordChk)) {
                    System.out.println("Passwords did not match try again");
                }
            }
            isPasswordValid = passWordValidator(password);
            if (isPasswordValid) {
                System.out.println("Password Valid");

            } else {
                password = "";
                System.out.println("Password invalid");
            }
        }
        if (firstName.length() == 0 || lastName.length() == 0) {
            System.out.println("You left a space empty try again");
            signUp();
        } else {
            List<Integer> booksCheckedOut = new ArrayList<>();
          Users.createUser(email,password, firstName, lastName,booksCheckedOut);
        }

    }

    public boolean validateEmail(String email) {
        boolean isValidEmail;

        isValidEmail = email.substring(email.length() - 4).equals(".com") || email.length() >= 8 || !email.contains("@");
        return isValidEmail;
    }

    private boolean passWordValidator(String password) {
        String passwordReq = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{6,20}$";

        Pattern compileReq = Pattern.compile(passwordReq);
        Matcher passwordMatch = compileReq.matcher(password);

        return passwordMatch.matches();
    }
}


