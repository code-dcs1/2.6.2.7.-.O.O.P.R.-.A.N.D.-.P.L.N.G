import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];
        System.out.println("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Here is the list of Even number/s: ");
        for (int x = 0; x < numbers.length; x++) {
            if(numbers[x] % 2 == 0) {
                System.out.print(numbers[x] + " ");
            }
        }
        
    }
}