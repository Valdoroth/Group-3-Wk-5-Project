import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class FileAccess {
    private static final Path bookLocation = Path.of(System.getProperty("user.dir")+"/resources/booksTest.csv");
    private static final Path bookLocation2 = Path.of(System.getProperty("user.dir")+"/resources/booksTestWrite.csv");
    private static List<Books> bookList;

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
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(String.valueOf(bookLocation2)));
        //writeToFile.write(String.valueOf(bookList));
        for (Books line : bookList) writeToFile.write(String.valueOf(line));

    }

    public static void main(String[] args) throws IOException {

        List<Books> bookList = getBooks();
        //String lookMeUp = "978-0865165601";
        String[] manyISBN = {"978-0865165601","978-1250252715","978-1250142283"};
        int stockChange;
        /*
        for (Books i : bookList) {
            System.out.println("ISBN: " + i.getISBN() + "\tTitle: " + i.getTitle());
        }
        */
        HashMap<Integer,Books> bookMap = new HashMap<>();
        for (Books k : bookList) bookMap.put(bookList.indexOf(k),k);
//        for(int p = 0; p < 10 ; p++) System.out.println(bookMap.get(p).getPrice());
        bookMap.get(0).checkOutBook();

        System.out.println("=============================");

        for (Books i : bookList) {
            for (String j : manyISBN) {
                if (i.getISBN().equals(j))
                    System.out.println("Title: " + i.getTitle() + "\tAvailable Amount: " + i.getAvailableAmount());// System.out.println("ISBN: " + i.getISBN() + "\tTitle: " + i.getTitle());
                //else System.out.println("Book is not in library.");
            }
        }


        //setBooks(bookList);

    }
}
