import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Run.startApplication();
        Run.menuScreen();
        Scanner scanner = new Scanner(System.in);

        do {
            int action = 0;

            try {
                if (scanner.hasNextInt()) action = scanner.nextInt();
                Run.menuChoice(action);
            } catch (Exception wrongInput) {
                System.out.println(wrongInput.getMessage() + ": \n" + Arrays.toString(wrongInput.getStackTrace()));
            }
        }
        while (Run.runMe) ;
        System.out.println("Exiting program.");
        scanner.close();
    }
}