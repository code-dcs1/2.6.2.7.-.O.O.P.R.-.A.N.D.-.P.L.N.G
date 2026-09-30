import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int arrSize = 10;
        
        while(true) {
            try {
                System.out.print("Enter the size of the array: ");
                arrSize = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Input error, defaulting to default 10");
                break;
            }  
        }

        int[] lists = new int[arrSize];
        System.out.println("Enter " + arrSize + " elements into the array");
        for(int i = 0; i < arrSize; i++) {
           try {
                lists[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("0");
                lists[i] = 0;
                scanner.next();
            }  
        }

        System.out.print("Even elements: ");
        for(int i = 0; i < arrSize; i++) {
            if(lists[i] % 2 == 0) {
                System.out.print(lists[i] + " ");
            }
        }

        System.out.println("Odd elements: ");
        for(int i = 0; i < arrSize; i++) {
            if(lists[i] % 2 == 1) {
                System.out.print(lists[i] + " ");
            }
        }
    }
}
