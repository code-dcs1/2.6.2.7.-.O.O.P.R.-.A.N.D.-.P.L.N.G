import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[8];

        System.out.println("Enter 8 integer numbers:");
        for (int i = 0; i < 8; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int[] uNum = Arrays.stream(numbers).distinct().toArray();
        
        System.out.println("\nOriginal Array: " + Arrays.toString(numbers));
        System.out.println("Array after removing duplicates: " + Arrays.toString(uNum));

        if (uNum.length < 2) {
            System.out.println("\nThe numbers here are less than 2 unique numbers.");
        } else {
            Arrays.sort(uNum);
            int sSmall = uNum[1];
            int sLarge = uNum[uNum.length - 2];

            System.out.println("Second smallest element: " + sSmall);
            System.out.println("Second largest element: " + sLarge);
        }

        scanner.close();
    }
}
