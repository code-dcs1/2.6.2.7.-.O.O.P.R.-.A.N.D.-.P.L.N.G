import java.util.*;
import java.io.*;

public class Main {
    public static int Exam_Score_Statistics() {
        Scanner scanner = new Scanner(System.in);
        int arraySize;
        System.out.print("Students: ");

        while (true) {
            try {
                arraySize = scanner.nextInt();

                if (arraySize <= 0) {
                    throw new IllegalArgumentException("Array size must be greater than 0.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer: ");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Array size can't be 0 or negative. Re-enter: ");
            }
        }

        float[] numbers = new float[arraySize];
        
    
        scanner.useDelimiter("[\\s,\\r\\n]+");
        for (int i = 0; i < numbers.length; i++) {
            while(true) {
                try {
                    System.out.print("Score " + (i+1) + ": ");
                    numbers[i] = scanner.nextFloat();

                    if (numbers[i] >= 0 && numbers[i] <= 100) {
                        break; 
                    } else {
                        System.out.print("Wrong Input, re input again: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Invalid type! Please enter a number: ");
                    scanner.next();
                }
            }
        }
        
        float highest = numbers[0];
        float lowest = numbers[0];
        float total = 0;
        int failing = 0;
        int passing = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > highest) {
                highest = numbers[i];
            }
            if(numbers[i] < lowest) {
                lowest = numbers[i];
            }
            if(numbers[i] >= 75) {
                passing++;
            } else {
                failing++;
            }
            total = total + numbers[i];
        }

        System.out.printf("Average: %.2f%n", (total/arraySize));
        System.out.printf("Highest: %.2f \t Lowest: %.2f%n", highest, lowest);
        System.out.printf("Passed: %d \t Failed: %d%n", passing, failing);
        System.out.println("Top student numbers: " + passing);      
        return 0;
    }

    public static int Store_Stock_Reorder_Report() {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Notebook", "Pen", "Folder", "USB"};
        int[] orders = {5, 10, 5, 2};
        int[] target = {20, 30, 20, 10};
        int[] stock = new int[names.length];

        for(int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " stock: ");
            while (true) {
                try {
                    stock[i] = scanner.nextInt();

                    if (stock[i] <= orders[i]) {
                        throw new IllegalArgumentException("Stock cannot be greater than reorders");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid integer: ");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println("Stock cannot be greater than reorders. Re-enter: ");
                }
            }
        }

        int totalStock = 0;
        int totalOrder = 0;
        for(int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " stock=" + stock[i] + " orders=" + (target[i]-stock[i]) +"\n");
            totalStock = totalStock + stock[i];
            totalOrder = totalOrder + (target[i]-stock[i]);
        }
        
        System.out.println("Total stock: " + totalStock);
        System.out.println("Total suggested orders: " + totalOrder);
        return 0;
    }

    public static int Branch_Sales_Matrix() {
        Scanner scanner = new Scanner(System.in);
        int[][] sales = new int[3][5];

        int grand = 0;
        int[] dailies = new int[6];
        int[] branches = new int[3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.printf("Branch %d day %d: ",(i+1),(j+1));
                while (true) {
                    try {
                        sales[i][j] = scanner.nextInt();

                        if (sales[i][j] <= 0 &&sales[i][j] >= 1000000) {
                            throw new IllegalArgumentException("Array size must be greater than 0.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid integer: ");
                        scanner.next();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Array size can't be 0 or negative. Re-enter: ");
                    }
                }

                branches[i] = branches[i] + sales[i][j];
                dailies[j] = dailies[j] + sales[i][j];
                grand = grand + sales[i][j];
            }
        }
        for(int i = 0; i < 3; i++) {
            System.out.printf("Branch %d PHP %d \n",(i+1), branches[i]);
        }
        for(int i = 0; i < 5; i++) {
            System.out.printf("Day %d PHP %d \n",(i+1), dailies[i]);
        }
        System.out.printf("Top branch %d", branches.length);
        return 0;
    }

    public static void main(String[] args) {
        Branch_Sales_Matrix();
    }
}