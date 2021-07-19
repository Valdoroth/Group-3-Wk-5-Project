import java.util.List;
import java.util.Scanner;

public class CheckOut {
    private final List<Books> totalInventory = FileAccess.bookList;

    public CheckOut(){
    }

    //this method will return the books available for checkout
    public void getInventory(){
        List<Books> tempInventory = totalInventory;
        tempInventory.removeIf(i -> i.getAvailableAmount() == 0);
        System.out.println("The following titles are available for checkout: ");

        for(Books i: tempInventory){
            System.out.println(i.getTitle());
        }
    }

    public Boolean isAvailable(int keyNo){
        boolean result = false;
        for(Books i: totalInventory) {
            if(i.getID() == keyNo) {
                if (i.getAvailableAmount() > 0) {
                    result = true;
                    break;
                }
            }
        } return result;
    }

    public void checkOutBook(){
        Users userCheckOutBook = null;
        for(Users u : FileAccess.users) {
            if(u.getEmail().equals(Users.currentUser)) userCheckOutBook = u;
        }
        Books.showAllAvailableBooks();
        System.out.println("=================");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book number to check out that book.\n");
        int keyNo = input.nextInt();

        boolean isAvailable = isAvailable(keyNo);

        if(isAvailable){
            // reduce the quantity of that book in the file using the bookID
            for (Books bookListForCheckOut : FileAccess.bookList) {
                if (bookListForCheckOut.getID() == keyNo) bookListForCheckOut.setCheckOutQty(1);
            }
            assert userCheckOutBook != null;
            userCheckOutBook.addToCurrentUserBooks(keyNo);
            System.out.println("Book checked out successfully.");
            checkAnotherOut();
        } else {
            System.out.println("Key is invalid for book.");
        }
    }

    private int checkAnotherOut() {
        Scanner response = new Scanner(System.in);
        System.out.println("Do you want to check another book out? (y/n)");
        int answer;
        String responseValue = response.next();
        if (responseValue.equals("y")) answer = 2;
        else answer = 0;
        return answer;
    }
}
