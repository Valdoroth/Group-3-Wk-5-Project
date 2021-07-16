import java.io.IOException;
import java.util.List;

public class CheckIn {
    private int bookToCheckIn;
    private static String userLoggedIn;

    private CheckIn(int inputBookID, String inputUserLoggedIn) {
        this.bookToCheckIn = inputBookID;
        userLoggedIn = inputUserLoggedIn;
    }


    ///////////////////////////// TEST THIS CLASS METHODS HERE ////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        List<Books> bookTestCheckInList = FileAccess.getBooks();
        for (Books a : bookTestCheckInList) {

        }
    }
}
