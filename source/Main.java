import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        startApplication();
        menuScreen();
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while(!quit){

            int action;

            try {
                action = scanner.nextInt();

                switch(action){
                    case 0:
                        menuScreen();
                        break;
                    case 1:
                        // Show all books
                        Books.showAllBooks();
                        break;
                    case 2:
                        // Checkout
                        CheckOut checkout = new CheckOut();
                        checkout.checkOutBook();
                        break;
                    case 3:
                        //
                        break;
                    case 4:
                        System.out.println("Logging out");
                        quit = true;
                        scanner.close();
                        break;
                }
            }catch(Exception e){
                System.out.println("Enter valid number");
                menuScreen();
                scanner.nextLine();
            }
            System.out.println("\n Enter action: ");

        }

    }


    public static void startApplication() throws IOException {
        Auth newUser = new Auth();
        newUser.start();
    }


    public static void menuScreen(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println(
                "1 - To show all books\n" +
                        "2 - To checkout a book\n" +
                        "3 - Nothing\n" +
                        "4 - Log Out");
        System.out.println("choose your actions: ");
    }
}