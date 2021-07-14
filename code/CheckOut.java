import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckOut {

    private List<Books> CheckedOut;
    private int InventoryQty;
    private int CheckedOutQty;
    private HashMap<UserAccounts, Books> checkOutMap;

    //this method will return the books available for checkout
    public List getInventory(){
        List<Books> inventory = new ArrayList<>();

        inventory = FileAccess.getBooks();

        inventory.removeAll(CheckedOut);

        return inventory;
    }


    //this might belong in User class
    public String validUser(){

        return "User is eligible for check out.";
    }


    public Boolean isAvailable(){
        if(InventoryQty>CheckedOutQty)
            return true;
        else
            return false;
    }

    //returns the number of this book available for checkout
    public String getAvailability(String ISBN) {
        return  "Copies available: " + (InventoryQty - CheckedOutQty);
    }

    public void checkOut(Books book){


    }

    //returns book info for the titles this user has checked out. Should be in user class?
    public String hasCheckedOut() {

        return "You currently have these titles out: ";
    }





}
