import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int check = 1;
    Scanner scan = new Scanner(System.in);
    while(check == 1) {
      int choice = 0;
      double num1 = 0, num2 = 0;
      String ext = "";

      System.out.println("Arithmetic Operations:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulus\n6. Increment\n7. Decrement\n Your choice: ");
      choice = scan.nextInt();
     
      System.out.println("Enter first number: ");
      num1 = scan.nextDouble();

      System.out.println("Enter second number: ");
      num2 = scan.nextDouble();

      switch (choice) {
        case 1:
          System.out.println("Addition: x + y = " + (num1+num2));
          break;
        case 2:
          System.out.println("Subtraction: x - y = " + (num1-num2));
          break;
        case 3:
          System.out.println("Multiplication: x * y = " + (num1*num2));
          break;
        case 4:
          if(num2 != 0) {
            System.out.println("Division: x / y = " + (num1/num2));
          } else {
             System.out.println("Error: Division by zero");
          }
          break;
        case 5:
          if(num2 != 0) {
            System.out.println("Modulus: x % y = " + (num1%num2));
          } else {
             System.out.println("Error: Division by zero");
          }
          break;
        case 6:
          num1++;
          System.out.println("Increment: x++ =" + (num1));
          break;
        case 7:
          num1--;
          System.out.println("Decrement: x-- =" + (num1));
          break;
        default:
          System.out.println("Invalid input");
      }

			System.out.println("Do you want to continue: (YES / NO)");
			ext = scan.next();
			if(ext.equalsIgnoreCase("NO")) {
        System.out.println("Program terminated.\nThank you!");
				check--;
			}

			System.out.println("\n");

    }
  }
}
