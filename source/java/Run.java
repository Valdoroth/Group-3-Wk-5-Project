import java.io.IOException;

public class Run {
    public static boolean runMe;

    public static void startApplication() throws IOException {
        FileAccess.getUsers();
        FileAccess.getBooks();
        Auth newUser = new Auth();
        newUser.start();
    }

    public static void menuScreen(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println(
                """
                        1 - To show all books
                        2 - To check out a book
                        3 - To check in a book
                        4 - Log Out""");
        System.out.println("Enter action: (0 to show available actions)");
    }

    public static void menuChoice(int menuOption) throws IOException {
        switch (menuOption) {
            default -> menuScreen();
            case 1 -> {
                // Show all books
                Books.showAllBooks();
                menuScreen();
                stopRunning("no");
            }
            case 2 -> {
                // Checkout
                CheckOut checkout = new CheckOut();
                checkout.checkOutBook();
                stopRunning("no");
            }
            case 3 -> {
                //Check in
                CheckIn checkInBook = new CheckIn();
                checkInBook.checkInBook();
                stopRunning("no");
            }
            case 4 -> {
                System.out.println("Logging out");
                stopRunning("yes");
            }
        }
    }

    public static void stopRunning(String keepRun) {
        Run.runMe = keepRun.equals("no");
    }
}
