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

    public void setCheckedOut(List<Books> checkedOut) {
        for(Books i: FileAccess.bookList) if(i.getCheckOutQty() == i.getTotalStock()) checkedOut.add(i);
        CheckedOut = checkedOut;
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
        List<Books> books = FileAccess.bookList;
        int totalAvailable = 0;
        for(Books i : books) if(i.getISBN().equals(ISBN))  totalAvailable = (i.getTotalStock()-i.getCheckOutQty());

        return  "Copies available: " + totalAvailable;
    }

    public void checkOut(Books book){


    }

    //returns book info for the titles this user has checked out. Should be in user class?
    public String hasCheckedOut() {

        return "You currently have these titles out: ";
    }

    public static void main(String[] args){
        List<Books> books = FileAccess.getBooks();
        String isbn = "978-0073511450";
        CheckOut test = new CheckOut();
        System.out.println(test.getAvailability(isbn));
    }

}
