import java.io.IOException;
import java.util.List;

public class Books {
    private final int id;
    private final String ISBN;
    private final String title;
    private final String author;
    private int checkOutQty;
    private final int totalStock;
    private final double price;
    private final String description;

    public Books(int idOfBook, String bookISBN, String bookTitle, String bookAuthor, int bookCheckOutQty, int bookTotalStock, double bookPrice, String bookDescription) {
        this.id = idOfBook;
        this.ISBN = bookISBN;
        this.title = bookTitle;
        this.author = bookAuthor;
        checkOutQty = bookCheckOutQty;
        this.totalStock = bookTotalStock;
        this.price = bookPrice;
        this.description = bookDescription;
    }

    public static void showAllBooks(){
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        List<Books> booksList = FileAccess.getBooks();
        for (Books k : booksList) System.out.println("No. " + k.getID() + " " + k.title);
    }

    public static void showAllAvailableBooks(){
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        List<Books> booksList = FileAccess.getBooks();
        for (Books k : booksList) {
            if (k.getAvailableAmount() > 0) System.out.println("No. " + k.getID() + " " + k.title);
        }
    }

    public int getID() { return id;}

    public String getISBN() { return ISBN;}

    public String getTitle() { return title;}

    public String getAuthor() { return author;}

    public int getTotalStock() { return totalStock;}

    public double getPrice() { return price;}

    public int getCheckOutQty() { return checkOutQty;}

    public String getDescription() { return description;}

    public int getAvailableAmount(){ return getTotalStock() - getCheckOutQty();}

    public void setCheckOutQty(int i) { this.checkOutQty += i;}

    ///////////////////////////// TEST THIS CLASS METHODS HERE ////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        List<Books> bookTestCheckInList = FileAccess.getBooks();
        for (Books a : bookTestCheckInList) {
        }
    }
}
