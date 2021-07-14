import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Books {
    private String ISBN;
    private String title;
    private String author;
    private int checkOutQty;
    private int totalStock;
    private double price;
    private String description;
    private HashMap<Integer,Books> bookMap = new HashMap<>();

    public Books(String ISBN, String title, String author, int checkOutQty, int totalStock, double price, String description) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.checkOutQty = checkOutQty;
        this.totalStock = totalStock;
        this.price = price;
        this.description = description;
    }


    public void showAllBooks(){
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        List<Books> booksList = FileAccess.getBooks();

        for (Books k : booksList) bookMap.put(booksList.indexOf(k),k);
        bookMap.forEach((key,value)-> System.out.println("Key: " + key + " " + value.title));
    }

//    public void searchByAuthorName(){
//        Scanner input = new Scanner(System.in);
//        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
//        input.nextLine();
//        System.out.println("Enter Author Name:");
//        String authorName = input.nextLine();
//
//        // check against the books.csv file
//    }

    public boolean isAvailable(int keyNo){
        // Lookup the keyNo in the file to get the qty
        // if book qty > 0 then return true
        if(bookMap.containsKey(keyNo) && bookMap.get(keyNo).getAvailableAmount() > 0){
            System.out.println("Book available is " + bookMap.get(keyNo).getAvailableAmount());
            return true;
        }

        // return false if the qty is less than 0
        return false;
    }


    public void checkOutBook(){
        showAllBooks();
        System.out.println("=================");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Key No to for the selected book to be Checked Out.");
        int keyNo = input.nextInt();

        boolean isAvailable = isAvailable(keyNo);

        if(isAvailable){
            // reduce the quantity of that book in the file using the isbnNo
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Key is invalid for book.");
        }
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

    public void setCheckOutQty(int checkOutQty) {
        this.checkOutQty = checkOutQty;
    }

}
