import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.UUID.randomUUID;

public class Auth {

    Scanner input = new Scanner(System.in);
    String email;
    String password;

    public Auth() {
        password = "";
        email = "";



    }

    public void Start() {
        String action = "";
        System.out.println("Welcome to the V.A.J.J. Library System");
        while (!action.toUpperCase().equals("L") && !action.toUpperCase().equals("S")) {
            System.out.println(" Please enter L for Login or S for Signup ");
            action = input.nextLine();

            if (!action.toUpperCase().equals("L") && !action.toUpperCase().equals("S")) {
                System.out.println("Check your entry and try again");
            } else {
                System.out.println("Thank you");
                System.out.println();
            }

        }
        if (action.toUpperCase().equals("L")) {
            Login();
        } else {

            SignUp();
        }

    }

    public void Login() {

        boolean isValidated = false;




        while (isValidated==false) {
            System.out.println("Enter your Email Address");
            email = input.nextLine();
            isValidated = ValidateEmail(email);

        }

        while (PassWordValidator(password) == false) {
            System.out.println("Enter your password");
            password = input.nextLine();
            PassWordValidator(password);
            System.out.println(PassWordValidator(password));
            if (PassWordValidator(password) == false) {
                System.out.println(" Password inValid please try again");
            } else if (PassWordValidator(password) == true) {

                UserAccounts.ValidateUser(email, password);

            }


        }


    }


    public void SignUp() {
        String firstName = "";
        String lastName = "";
        String address = "";
        boolean isEmailValid = false;
        boolean isPasswordValid = false;
        String passwordChk = "";

        System.out.println();
        System.out.println("Welcome New User ");
        System.out.println("Please enter your first name");
        firstName = input.nextLine();
        System.out.println("Please enter your last Name");
        lastName = input.nextLine();
        System.out.println(" Please enter your address");
        address = input.nextLine();
        while (isEmailValid == false) {
            System.out.println(" Please enter your Email Address");
            email = input.nextLine();
            isEmailValid = ValidateEmail(email);
            if (isEmailValid == false) {
                System.out.println("Not a valid email try again");
            }
        }
        while (isPasswordValid == false) {
            while (!password.equals(passwordChk) || password.length() == 0 || passwordChk.length() == 0) {
                System.out.println(" Please enter your password,it must be at least 6 characters long" +
                        " and contain one capital letter and one of these special characters @#$%^&+=");
                password = input.nextLine();
                System.out.println(" Please re-enter your password");
                passwordChk = input.nextLine();
                if (!password.equals(passwordChk)) {
                    System.out.println("Passwords did not match try again");
                }
            }
            isPasswordValid = PassWordValidator(password);
            if (isPasswordValid == true) {
                System.out.println("Password Valid");

            } else {
                password = "";
                System.out.println("Password invalid");
            }
        }
        if (firstName.length() == 0 || lastName.length() == 0 || address.length() == 0) {
            System.out.println("You left a space empty try again");
            SignUp();
        } else {
            CreateUser(firstName, lastName, address, email, password);
        }


    }

    public boolean ValidateEmail(String email) {
        boolean isValidEmail;

        if (!email.substring(email.length() - 4).equals(".com") && email.length() < 8 && email.contains("@")) {
            isValidEmail = false;

        } else {
            isValidEmail = true;
        }
        return isValidEmail;
    }

    public boolean PassWordValidator(String password) {

        String passwordReq = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{6,20}$";

        Pattern compileReq = Pattern.compile(passwordReq);

        Matcher passwordMatch = compileReq.matcher(password);

        return passwordMatch.matches();

    }

    public void CreateUser(String firstName, String lastName, String address, String email, String password) {

        UserAccounts name = new UserAccounts(firstName, lastName, address, email, password);
        name.AddUserToArray(name);
        System.out.println(name);
    }


}


