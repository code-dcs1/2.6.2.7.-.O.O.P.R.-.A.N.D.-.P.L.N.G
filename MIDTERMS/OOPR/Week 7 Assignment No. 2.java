import java.util.Scanner;

public class VowelConsonantChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a letter: ");
        String input = scanner.next();

        if (input.length() != 1) {
            System.out.println("Please enter a single letter.");
            return;
        }

        char ch = input.charAt(0);
        if (!Character.isLetter(ch)) {
            System.out.println("That is not a valid letter.");
        } else {
            char smallChar = Character.toLowerCase(ch);

            if (smallChar == 'a' || smallChar == 'e' || smallChar == 'i' || smallChar == 'o' || smallChar == 'u') {
                System.out.println("It's a vowel!");
            } else {
                System.out.println("It's a consonant!");
            }
        }

        scanner.close();
    }
}
