import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String input = scanner.nextLine();

        for(int x = 0; x < 5; x++) {
          System.out.println(input);
        }
    }
}
