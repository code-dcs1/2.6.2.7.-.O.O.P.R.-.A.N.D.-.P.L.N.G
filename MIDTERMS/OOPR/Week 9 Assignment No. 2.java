import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = "";

        while(true) {
          System.out.print("Enter a number from 1-10: ");
          int input = scanner.nextInt();

          switch(input) {
            case 1:
              value = "One";
              break;
            case 2:
              value = "Two";
              break;
            case 3:
              value = "Three";
              break;
            case 4:
              value = "Four";
              break;
            case 5:
              value = "Five";
              break;
            case 6:
              value = "Six";
              break;
            case 7:
              value = "Seven";
              break;
            case 8:
              value = "Eight";
              break;
            case 9:
              value = "Nine";
              break;
            case 10:
              value = "Ten";
              break;
            default:
              value = "Invalid Number";
          }

          System.out.println(value);
          System.out.println("Again? y/n: ");
          String choiceInput = scanner.next();

          if(choiceInput.equals("n")) {
            System.out.println("Exiting...");
            break;
          }
        }
    }
}
