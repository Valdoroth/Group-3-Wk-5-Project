import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileAccess.getUsers();
        Auth newUser = new Auth();

        newUser.start();
        FileAccess.getBooks();
        FileAccess.setUsers(FileAccess.getUsers());
    }
}