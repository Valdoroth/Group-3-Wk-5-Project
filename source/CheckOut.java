import java.util.List;
import java.util.Scanner;

public class CheckOut {

    private List<Books> totalInventory = FileAccess.getBooks();
    private int InventoryQty;
    private int CheckedOutQty;
    //private HashMap<UserAccounts, Books> checkOutMap;

    //this method will return the books available for checkout
    public void getInventory(){
        List<Books> tempInventory = totalInventory;
        tempInventory.removeIf(i -> i.getAvailableAmount() == 0);
        System.out.println("The following titles are available for checkout: ");

        for(Books i: tempInventory){
            System.out.println(i.getTitle());
        }
    }


    //this might belong in User class
    public String validUser(){
        //if user is not violating terms (certain number of books & none over due)
        return "User is eligible for check out.";
    }


    public Boolean isAvailable(int keyNo){
        List<Books> tempInventory = totalInventory;
        for(Books i: tempInventory)
            if(i.getAvailableAmount() > 0)
                return true;

        return false;
    }

    //returns the number of this book available for checkout
    public String getAvailability(String ISBN) {
        List<Books> tempList = FileAccess.getBooks();
        int available = 0;
        for(Books i: tempList) {
            if (i.getISBN().equals(ISBN)){
                available = (i.getTotalStock() - i.getCheckOutQty());
            }
        }
        return  "Copies available: " + available;
    }

//    public void checkOut(int bookID, String email){
//        FileAccess.bookList.forEach(book -> book.getID());
//    }

    public void checkOutBook(){
        Books.showAllBooks();
        System.out.println("=================");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Key No to for the selected book to be Checked Out.");
        int keyNo = input.nextInt();

        boolean isAvailable = isAvailable(keyNo);

        if(isAvailable){
            // reduce the quantity of that book in the file using the bookID
            Books.setCheckOutQty();
            Users.updateCurrentUserBooks(keyNo);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Key is invalid for book.");
        }



    }





}
