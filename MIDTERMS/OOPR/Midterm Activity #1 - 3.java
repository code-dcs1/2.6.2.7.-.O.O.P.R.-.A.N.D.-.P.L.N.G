import java.util.Scanner;

public class DeleteArrayElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = new int[5];
        System.out.print("Enter Data in Array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Stored Data in Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.print("Enter position of Element to Delete: ");
        int pos = scanner.nextInt();
        
        if (pos < 0 || pos >= arr.length) {
            System.out.println("Invalid position");
        } else {
            for (int i = pos; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }

            System.out.print("New data in Array: ");
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
