import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class FileAccess {
    private static final Path bookLocation = Path.of(System.getProperty("user.dir")+"/resources/booksTest.csv");
    private static final Path bookLocation2 = Path.of(System.getProperty("user.dir")+"/resources/booksTestWrite.csv");
    private static final Path userAccountLocation = Path.of(System.getProperty("user.dir")+"/resources/userAccountsTest.txt");
    public static List<Books> bookList;
    public static List<Users> users;

    public FileAccess() {
    }

    public static List<Books> getBooks() {
        List<Books> fileAccessBookList = new ArrayList<>();

        try (BufferedReader readThisFile = new BufferedReader(new FileReader(String.valueOf(bookLocation)))) {
            String bookLine;
            while((bookLine = readThisFile.readLine())!= null) {
                String[] books = bookLine.split(",/");
                fileAccessBookList.add(new Books(Integer.parseInt(books[0]), books[1], books[2], books[3], Integer.parseInt(books[4]), Integer.parseInt(books[5]), Double.parseDouble(books[6]), books[7]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FileAccess.bookList = fileAccessBookList;
        return bookList;
    }

    public static void setBooks(List<Books> booksUpdated) throws IOException {
        bookList = booksUpdated;
        FileWriter writeToFile = new FileWriter(String.valueOf(bookLocation));
        for (Books line : bookList) {
            StringBuilder lineToWrite = new StringBuilder();
            lineToWrite.append(line.getID()).append(",/").append(line.getISBN()).append(",/").append(line.getTitle()).append(",/").append(line.getAuthor()).append(",/").append(line.getCheckOutQty()).append(",/").append(line.getTotalStock()).append(",/").append(line.getPrice()).append(",/").append(line.getDescription());
            System.out.println(lineToWrite);
            writeToFile.write(lineToWrite +"\n");
            writeToFile.flush();
        }
    }

    public static List<Users> getUsers() {
        List<Users> userList = new ArrayList<>();

        try (BufferedReader readThisFile = new BufferedReader(new FileReader(String.valueOf(userAccountLocation)))) {
            String userLine;
            while((userLine = readThisFile.readLine())!= null) {
                String[] user = userLine.split("\\|");
                String[] booksCheckedOut = user[4].split(",");
                List<Integer> booksCheckedOutIDs = new ArrayList<>();
                for(String bookID : booksCheckedOut) booksCheckedOutIDs.add(Integer.parseInt(bookID));
                userList.add(new Users(user[0], user[1], user[2], user[3], booksCheckedOutIDs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FileAccess.users = userList;
        return userList;
    }

    public static void setUsers(List<Users> userListInput) throws IOException {
        users = userListInput;
        FileWriter writeToFile = new FileWriter(String.valueOf(userAccountLocation));

        for (Users line : userListInput) {
            StringBuilder booksInSetUsers = new StringBuilder();
            StringBuilder lineToWrite = new StringBuilder();
            for(int itemInBooksInSetUsers : line.getBooksCheckedOut()) {
                booksInSetUsers.append(itemInBooksInSetUsers).append(",");
            }
            lineToWrite.append(line.getEmail()).append("|").append(line.getPassword()).append("|") .append(line.getFirstName()).append("|").append(line.getLastName()).append("|").append(booksInSetUsers).append("\n");
            //System.out.println(lineToWrite);
            writeToFile.write(String.valueOf(lineToWrite));
            writeToFile.flush();
        }
    }


    ///////////////////////////// TEST THIS CLASS METHODS HERE ////////////////////////////////////////
    public static void main(String[] args) throws IOException {

        List<Users> userList = getUsers();
        getBooks();
        for(Users a : getUsers()) {
            System.out.println(a.getEmail() + " has the following books checked out: ");
            for (int i : a.getBooksCheckedOut()) {
                for (Books b : FileAccess.bookList) if (i == b.getID()) System.out.println("\t" + b.getTitle());
            }
            System.out.println("");
        }
    }
}
