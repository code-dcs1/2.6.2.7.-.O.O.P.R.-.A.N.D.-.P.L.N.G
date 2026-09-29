import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = "", word2 = "", word3 = "";

        System.out.print("Enter first word: ");
        word1 = scanner.next();
        
        System.out.print("Enter second word: ");
        word2 = scanner.next();
        
        System.out.print("Enter third word: ");
        word3 = scanner.next();
        
        System.out.println(word1 + " " + word2 + " " + word3);
        scanner.close();
    }
}
