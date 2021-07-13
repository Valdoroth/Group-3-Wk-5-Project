import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAccess {
    //private Books book = new Books();
    private static final Path bookLocation = Path.of(System.getProperty("user.dir")+"/resources/booksTest.csv");
    private static final Path bookLocation2 = Path.of(System.getProperty("user.dir")+"/resources/booksTestWrite.csv");
    private static List<List<String>> bookList;

    public FileAccess() {
    }

    public static List<List<String>> getBooks() {
        List<List<String>> bookList = new ArrayList<>();

        try (BufferedReader readThisFile = new BufferedReader(new FileReader(String.valueOf(bookLocation)))) {
            String bookLine;
            while((bookLine = readThisFile.readLine())!= null) {
                String[] books = bookLine.split(",");
                bookList.add(Arrays.asList(books));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FileAccess.bookList = bookList;
        return bookList;
    }

    public static void setBooks(List<List<String>> booksUpdated) throws IOException {
        bookList = booksUpdated;
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(String.valueOf(bookLocation2)));
        //writeToFile.write(String.valueOf(bookList));
        for (List<String> line : bookList) writeToFile.write(String.valueOf(line));

    }

    public static void main(String[] args) throws IOException {

        List<List<String>> bookList = getBooks();

        for (List<String> i : bookList) {
            System.out.println(i.get(1));
        }
        setBooks(bookList);

    }
}
