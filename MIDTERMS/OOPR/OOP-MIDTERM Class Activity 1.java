import java.io.*;
import java.util.*;

class Student {
    private static int noOfStudents = 0;
    private String studentNo;
    private String studentName;
    private String dateOfBirth;
    private int tariffPoints;

    public Student() {
        this.studentNo = "not known";
        this.studentName = "not known";
        this.dateOfBirth = "01/01/1995";
        this.tariffPoints = 20;
        noOfStudents++;
    }

    public Student(String studentNo, String studentName, String dateOfBirth, int tariffPoints) {
        setStudentNo(studentNo);
        setStudentName(studentName);
        setDateOfBirth(dateOfBirth);
        setTariffPoints(tariffPoints);

        noOfStudents++;
    }

    public static int getNoOfStudents() {
        return noOfStudents;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        if (studentNo == null || studentNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Student number cant be empty.");
        }
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cant be empty.");
        }
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) {
            throw new IllegalArgumentException("Date of birth cant no value.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getTariffPoints() {
        return tariffPoints;
    }

    public void setTariffPoints(int tariffPoints) {
        if (tariffPoints < 20 || tariffPoints > 280) {
            throw new IllegalArgumentException("Tariff points must be between 20 and 280.");
        }
        this.tariffPoints = tariffPoints;
    }
}

public class Main {
    public static void main(String[] args) {
        
        while(true) {
            Scanner menuScanner = new Scanner(System.in);
        
            System.out.println("=== SELECT A PROGRAM ===");
            System.out.println("1. Positive/Negative Stats & Minimum Value");
            System.out.println("2. Remove Duplicates & Find 2nd Smallest/Largest");
            System.out.println("3. Delete a element in an array from specific position");
            System.out.println("4. Even elements and odd elements in array");
            System.out.println("5. A and Stars");
            System.out.println("6. Student Tariff Points System");
            System.out.println("7. Tab separated data on text");
            System.out.print("Enter your choice (1, 2, 3, 4, 5, 6, or 7): ");
        
            int choice = menuScanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    actOne();
                    break;
                case 2:
                    actTwo();
                    break;
                case 3:
                    actThree();
                    break;
                case 4:
                    actFour();
                    break;
                case 5:
                    actFive();
                    break;
                case 6:
                    actSix();
                    break;
                case 7:
                    actSeven();
                    break;
                default:
                    System.out.println("Invalid choice! Please restart and enter 1 or 2.");
            }
            
            System.out.println("Do you want to continue (Y/N): ");
            String repeatProgram = menuScanner.next();
            
            if(repeatProgram.equals("n")) {
                System.out.println("Exiting the program");
                break;
            }
        }
    }

    public static void actOne() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lists = new int[10];
        int[] calc = {0,0,0,0};
        for(int i = 0; i < 10; i++) {
            try {
                System.out.print("Enter the no." + (i+1) + " number: ");
                lists[i] = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Input error, defaulting to default 0");
                lists[i] = 0;
            }    
        }

        for(int i = 0; i < 10; i++) {
            if(lists[i] >= 0) {
                calc[0] += lists[i];
            }

            if(lists[i] < 0) {
                calc[1] += 1;
            }
        }

        float avg = 0;
        if(calc[0]>0) {
            avg = calc[0]/10;
        } else {
            avg = 0;
        }
        
        System.out.println("\nThe sum of positive numbers is " + calc[0] + " and the average of them is " + avg + " they are the numbers ");

        for(int i = 0; i < 10; i++) {
            if(lists[i] >= 0) {
                 System.out.print(lists[i] + " ");
            }
        }

        System.out.println("\nThe total amount of negative numbers is " + calc[1] + " and they are the numbers ");
        for(int i = 0; i < 10; i++) {
            if(lists[i] < 0) {
                 System.out.print(lists[i] + " ");
            }
        }

        int n = lists.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (lists[j] > lists[j + 1]) {
                    int temp = lists[j];
                    lists[j] = lists[j + 1];
                    lists[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("\nMinimum Value in the array is: " + lists[0]);
    }

    public static void actTwo() {
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
    }

    public static void actThree() {
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
        
        if (pos < -1 || pos >= arr.length) {
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
    }

    public static void actFour() {
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

    public static void actFive() {
        for(int i = 0; i < 5-1; i++) {
            System.out.print("*");
            for(int j = 0; j <= i; j++) {
                
                if (j < i ) {
                    System.out.print("A*");
                }
            }
            System.out.println();
        }
    }

    public static void actSix() {
        Student student1 = new Student();
        Student student2 = new Student("ST10234", "Alice Smith", "2002/5/14", 180);

        System.out.println("Student 1 Name: " + student1.getStudentName()); 
        System.out.println("Student 1 Points: " + student1.getTariffPoints());
        
        System.out.println("Student 2 Name: " + student2.getStudentName());
        System.out.println("Student 2 Points: " + student2.getTariffPoints());

        System.out.println("Total Students Created: " + Student.getNoOfStudents());
    }

    public static void actSeven() {
        // Replace the data.txt with the correct file path
        File file = new File("data.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            System.out.println("--- Reading Data from File ---");
            System.out.println("E No.\tE Name\t\tMobile");
            System.out.println("---------------------------------");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("[,\t]");
                if (data.length == 3) {
                    String eNumber = data[0].trim();
                    String eName = data[1].trim();
                    String mobile = data[2].trim();
                    System.out.println(eNumber + "\t" + eName + "\t\t" + mobile);
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Could not find the file.");
            System.out.println("The location at " + file.getAbsolutePath() + " may not exist");
        }
    }
}
