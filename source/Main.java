import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileAccess.getUsers();
        Auth newUser = new Auth();
        boolean logStatus = true;
        newUser.start();
        FileAccess.getBooks();
        FileAccess.setUsers(FileAccess.getUsers());

        while(logStatus){
            /*

            ask user what they want to do. switch method to direct to the functions.

            while(lookAtBooks) {
                a while loop checking out book until checkout complete.
                see books to check out
                May require another method.
                This section should not be long in the main and run by other classes' methods
            }
            while(checkABookIn) {
                includes small loop asking if they want to check in more books IF they have anymore.
                check in book
                set books, update files. Once this is run, you should run FileAccess.getBooks();

            }

            log out ---- pretty straight forward. This simply changes the logStatus to false and will exit the program
             */
        }
    }
}