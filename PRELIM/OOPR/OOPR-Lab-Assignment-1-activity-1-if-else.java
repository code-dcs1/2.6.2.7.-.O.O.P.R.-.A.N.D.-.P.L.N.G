import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int check = 1;
    Scanner scan = new Scanner(System.in);
    while(check == 1) {
      double jscore = 0, sscore = 0, dscore = 0;
      String ext = "";
      String grade= "";

      System.out.println("Input:\nJava Score:");
      jscore = scan.nextDouble();
      System.out.println("C Score:");
      sscore = scan.nextDouble();
      System.out.println("Database Handling Score:");
      dscore = scan.nextDouble();

      double score = (jscore + sscore + dscore) / 3.0;
      int choiceScore = (int) score;

      if (choiceScore >= 90) {
        grade = "A";
      } else if (choiceScore >= 80) {
        grade = "B";
      } else if (choiceScore >= 75) {
        grade = "C";
      } else if (choiceScore >= 0) {
        grade = "F";
      } else {
        System.out.println("Invalid input");
      }

      if(score >= 0 && score <= 100) {
        System.out.println("Grade: " + grade);
        System.out.println("Explanation: The average of the student is " + String.format("%.2f", score) + " so the student's grade is " + grade);
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
