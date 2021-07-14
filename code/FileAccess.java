import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class FileAccess {
    private static final Path bookLocation = Path.of(System.getProperty("user.dir")+"/resources/booksTest.csv");
    private static final Path bookLocation2 = Path.of(System.getProperty("user.dir")+"/resources/booksTestWrite.csv");
    private static final Path userAccountLocation = Path.of(System.getProperty("user.dir")+"/resources/userAccountsTest.csv");
    private static List<Books> bookList;
    private static List<UserAccounts> users;

    public FileAccess() {
    }

    public static List<Books> getBooks() {
        List<Books> bookList = new ArrayList<>();

        try (BufferedReader readThisFile = new BufferedReader(new FileReader(String.valueOf(bookLocation)))) {
            String bookLine;
            while((bookLine = readThisFile.readLine())!= null) {
                String[] books = bookLine.split(",/");
                bookList.add(new Books(books[0], books[1], books[2], Integer.parseInt(books[3]), Integer.parseInt(books[4]), Double.parseDouble(books[5]), books[6]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FileAccess.bookList = bookList;
        return bookList;
    }

    public static void setBooks(List<Books> booksUpdated) throws IOException {
        bookList = booksUpdated;
        FileWriter writeToFile = new FileWriter(String.valueOf(bookLocation2));
        //writeToFile.write(String.valueOf(bookList));
        StringBuilder lineToWrite = new StringBuilder();
        for (Books line : bookList) {
            lineToWrite.append(line.getISBN()).append(",/").append(line.getTitle()).append(",/").append(line.getAuthor()).append(",/").append(line.getCheckOutQty()).append(",/").append(line.getTotalStock()).append(",/").append(line.getPrice()).append(",/").append(line.getDescription()).append("\n");
            System.out.println(lineToWrite);
            writeToFile.write(String.valueOf(lineToWrite));
        }
    }
/*
    public static List<Books> getUsers() {
        List<Books> bookList = new ArrayList<>();

        try (BufferedReader readThisFile = new BufferedReader(new FileReader(String.valueOf(userAccountLocation)))) {
            String userLine;
            while((userLine = readThisFile.readLine())!= null) {
                String[] user = userLine.split(",");
                userList.add(new UserAccounts(user[0], user[1], user[2], user[3], user[4]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FileAccess.users = userList;
        return bookList;
    }

    public static void setUsers(List<UserAccounts> userList) throws IOException {
        users = userList;
        FileWriter writeToFile = new FileWriter(String.valueOf(userAccountLocation));
        StringBuilder lineToWrite = new StringBuilder();
        for (UserAccounts line : userList) {
            lineToWrite.append(line.getUsername()).append(",").append(line.getPassword()).append(",") .append(line.getFirstName()).append(",").append(line.getLastName()).append(",").append(line.getBooks());
            System.out.println(lineToWrite);
            writeToFile.write(String.valueOf(lineToWrite));
        }
    }


 */
    public static void main(String[] args) {

        List<Books> bookList = getBooks();
        //String lookMeUp = "978-0865165601";
        //String[] manyISBN = {"978-0865165601","978-1250252715","978-1250142283"};
        //int stockChange;

        //for (Books i : bookList) {
        //    System.out.println("ISBN: " + i.getISBN() + "\tTitle: " + i.getTitle());
        //}

        HashMap<Integer,Books> bookMap = new HashMap<>();
        for (Books k : bookList) bookMap.put(bookList.indexOf(k),k);
        for(int p = 0; p < 10 ; p++) {
            System.out.println(bookMap.get(p).getPrice());
        }
        bookMap.get(0).checkOutBook();

        System.out.println("=============================");

        //for (Books i : bookList) {
        //    for (String j : manyISBN) {
        //        if (i.getISBN().equals(j))
        //            System.out.println("Title: " + i.getTitle() + "\tAvailable Amount: " + i.getAvailableAmount());// System.out.println("ISBN: " + i.getISBN() + "\tTitle: " + i.getTitle());
                //else System.out.println("Book is not in library.");
         //   }
        //}


        //setBooks(bookList);

    }
}
