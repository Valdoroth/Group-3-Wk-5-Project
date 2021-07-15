import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckOut {

    private List<Books> totalInventory = FileAccess.getBooks();
    private int InventoryQty;
    private int CheckedOutQty;
    private HashMap<UserAccounts, Books> checkOutMap;

    //this method will return the books available for checkout
    public void getInventory(){
        List<Books> tempInventory = totalInventory;
        for(Books i: tempInventory){
            if(i.getAvailableAmount()==0){
                tempInventory.remove(i);
            }
        }
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


    public Boolean isAvailable(){
        List<Books> tempInventory = totalInventory;
        for(Books i: tempInventory)
            if(i.getAvailableAmount()==0)
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

    public void checkOut(Books book){



    }

    //returns book info for the titles this user has checked out. Should be in user class?
    public String hasCheckedOut() {

        return "You currently have these titles out: ";
    }





}