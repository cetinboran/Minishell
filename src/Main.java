import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        Run run = new Run(text);
        run.run();

        // Other
    }
}
