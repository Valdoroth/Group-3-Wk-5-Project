import java.util.Scanner;

public class Books {
    private String ISBN;
    private String Title;
    private String Author;
    private int CheckOutQty;
    private int totalStock;
    private double Price;
    private String Description;
    Scanner input = new Scanner(System.in);

    public Books(String ISBN, String title, String author, int checkOutQty, int totalStock, double price, String description) {
        this.ISBN = ISBN;
        Title = title;
        Author = author;
        CheckOutQty = checkOutQty;
        this.totalStock = totalStock;
        Price = price;
        Description = description;
    }

    public Books() {

    }

    public void showAllBooks(){
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");

        // for loop through the book.csv file to display the list
    }

    public void searchByAuthorName(){
        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
        input.nextLine();
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        // check against the books.csv file
    }

    public boolean isAvailable(String isbnNo){
        // Lookup the isbnNo in the file to get the qty
        // if book qty > 0 then return true

        // return false if the qty is less than 0
        return false;
    }

    public void checkOutBook(){
        System.out.println("Enter ISBN No of Book to be Checked Out.");
        String isbnNo = input.nextLine();

        boolean isAvailable = isAvailable(isbnNo);

        if(isAvailable){
            // reduce the quantity of that book in the file using the isbnNo

            System.out.println("Book checked out successfully");
        } else {
            System.out.println("Book " + isbnNo + " " + "doesn't not exist");
        }
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public double getPrice() {
        return Price;
    }

    public int getCheckOutQty() {
        return CheckOutQty;
    }

    public String getDescription() {
        return Description;
    }

    public void setCheckOutQty(int checkOutQty) {
        CheckOutQty = checkOutQty;
    }
}
