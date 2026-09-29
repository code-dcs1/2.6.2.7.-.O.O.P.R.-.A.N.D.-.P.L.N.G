import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0, c = 0;

        System.out.print("Enter first number: ");
        a = scanner.nextInt();
        System.out.print("Enter second number: ");
        b = scanner.nextInt();
        System.out.print("Enter third number: ");
        c = scanner.nextInt();

        int firstCheck = Math.max(b, c);
        int lastCheck = Math.max(a, firstCheck);

        System.out.println("The highest number is " + lastCheck);
        scanner.close();
    }
}
