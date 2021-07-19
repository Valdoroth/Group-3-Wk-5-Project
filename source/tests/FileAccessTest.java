import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileAccessTest {

    FileAccess fileAccess;

    @BeforeAll
    static void setUp() {
        //Books testBookItself = new Books(1,"978-1250142283", "Test Title", "Test Author",1,2,10.0,"blank description");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBooks() {
        assertEquals(80,FileAccess.getBooks().size());
        assertEquals(6, FileAccess.getBooks().get(1).getCheckOutQty());
    }

    @Test
    void setBooks() throws IOException {
        List<Books> testBookList = new ArrayList<>();
        testBookList.add(new Books(1,"978-0918091895", "Pre Calculus", "Paul Sisson",2,5,82.28,"Provides the latest tools for students to be able to comput math problems leading into calculus."));
        testBookList.add(new Books(2,"978-0618949922","Understandable Statistics 9th Edition","Brase; Corrinne Pellillo",6,6,193.85,"Provides the latest tools for students to be able to comput math problems leading into calculus."));

        FileAccess.setBooks(testBookList);

        assertEquals(2,FileAccess.getBooks().size());
    }

    @Test
    void getUsers() {
        assertEquals(16,FileAccess.getUsers().size());
        assertEquals(4, FileAccess.getUsers().get(0).getBooksCheckedOut().get(1));
    }

    @Test
    void setUsers() throws IOException {
        List<Integer> testBookInts = new ArrayList<Integer>();
        testBookInts.add(1);
        testBookInts.add(2);
        testBookInts.add(3);
        Users testUser = new Users("test@testing.com","T3stword","testFirst", "testLast", testBookInts);
        FileAccess.getUsers().add(testUser);
        FileAccess.setUsers(FileAccess.getUsers());
        assertEquals("test@testing.com", FileAccess.getUsers().get(FileAccess.getUsers().size()-1).getEmail());
    }

}