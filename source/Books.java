import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Books {
    private int id;
    private String ISBN;
    private String title;
    private String author;
    private int checkOutQty;
    private int totalStock;
    private double price;
    private String description;

    public Books(int idOfBook, String bookISBN, String bookTitle, String bookAuthor, int bookCheckOutQty, int bookTotalStock, double bookPrice, String bookDescription) {
        this.id = idOfBook;
        this.ISBN = bookISBN;
        this.title = bookTitle;
        this.author = bookAuthor;
        this.checkOutQty = bookCheckOutQty;
        this.totalStock = bookTotalStock;
        this.price = bookPrice;
        this.description = bookDescription;
    }


    public void showAllBooks(){
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        List<Books> booksList = FileAccess.getBooks();

        for (Books k : booksList) System.out.println("No.: " + k.getID() + " " + k.title);
    }

    public boolean isAvailable(int keyNo){
        // Lookup the keyNo in the file to get the qty
        // if book qty > 0 then return true
        if(id == keyNo && getAvailableAmount() > 0){
            System.out.println("Book(s) quantity available is " + getAvailableAmount());
            return true;
        }

        // return false if the qty is less than 0
        return false;
    }

/*
This method displays all books in the system and asks user what book they want to check out.
It'll check that the key is valid or not.
 */
    public void checkOutBook(){
        showAllBooks();
        System.out.println("=================");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Key No to for the selected book to be Checked Out.");
        int keyNo = 0;
        try {
            keyNo = input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid key");
        }

        boolean bookIsAvailable = isAvailable(keyNo);
        if(bookIsAvailable){
            // reduce the quantity of that book in the file using the isbnNo
            setCheckOutQty();
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Key is invalid for book.");
        }
    }

    public int getID() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public double getPrice() {
        return price;
    }

    public int getCheckOutQty() {
        return checkOutQty;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableAmount(){
        return getTotalStock() - getCheckOutQty();
    }

    public void setCheckOutQty() {
        this.checkOutQty += 1;
    }

    ///////////////////////////// TEST THIS CLASS METHODS HERE ////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        List<Books> bookTestCheckInList = FileAccess.getBooks();
        for (Books a : bookTestCheckInList) {

        }
    }
}
