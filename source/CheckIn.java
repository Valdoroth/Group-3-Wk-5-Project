import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CheckIn {
    private static String userLoggedIn;

    public CheckIn() {
        userLoggedIn = Users.currentUser;
    }

    public void checkInBook() throws IOException {
        Users userCheckInBook = null;
        for(Users u : FileAccess.users) {
            if(u.getEmail().equals(Users.currentUser)) userCheckInBook = u;
        }
        assert userCheckInBook != null;
        userCheckInBook.hasCheckedOut();
        System.out.println("=================");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book number to check in that book.\n");
        int bookToCheckIn = input.nextInt();

        for (Users userForCheckIn : FileAccess.users) {
            if (userForCheckIn.getEmail().equals(userLoggedIn)) {
                userForCheckIn.getBooksCheckedOut().remove((Integer) bookToCheckIn);
            } else {
                System.out.print("");//"Key is invalid for book.");
            }
        }
        System.out.println("Book checked in successfully.");
        checkAnotherIn();
        for (Books bookListForCheckIn : FileAccess.bookList) {
            if (bookListForCheckIn.getID() == bookToCheckIn) bookListForCheckIn.setCheckOutQty(-1);
        }
        FileAccess.setBooks(FileAccess.bookList);
        FileAccess.getBooks();
    }

    private int checkAnotherIn() {
        System.out.println("Do you want to check another book out? (y/n)");
        int answer;
        Scanner response = new Scanner(System.in);
        String responseValue = response.next();
        if (responseValue.equals("y")) answer = 3;
        else answer = 0;
        return answer;
    }

    ///////////////////////////// TEST THIS CLASS METHODS HERE ////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        List<Books> bookTestCheckInList = FileAccess.getBooks();
        for (Books a : bookTestCheckInList) {

        }
    }
}
