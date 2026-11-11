import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];
        System.out.print("Enter five numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        int highest = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > highest) {
                highest = numbers[i];
            }
        }
        System.out.println("the highest is: " + highest);
        
        System.out.println("The difference from the highest are: ");
        for (int x = 0; x < numbers.length; x++) {
            System.out.println(highest + " - " + numbers[x] + " = " + (highest-numbers[x]));
        }
        
    }
}