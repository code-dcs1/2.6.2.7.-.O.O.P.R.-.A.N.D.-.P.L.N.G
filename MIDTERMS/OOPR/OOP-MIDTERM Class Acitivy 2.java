import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

class InputChecks { 
    Scanner inputs = new Scanner(System.in);
    
    public int regularInput(String prompt, String guidelines)  {
        int currentInput = 0;
        while(true) {
            try {
                System.out.print(prompt);
                currentInput = inputs.nextInt();
                break;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Input error, try to follow the guidelines for the input\n[ " + guidelines + " ]\n");
                inputs.nextLine();
            }
        }

        return currentInput; 
    } 
}

class Main {
    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);
        InputChecks mainInput = new InputChecks();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM, dd, uuuu");
        
        int bookPage = -1, readPages = -1;
        LocalDate dueDate = null, issueDate = null, currentDate = null;

        String[] bookPrompts = {"How many pages does the book have? ", "The input should be a number "};
        String[] readPrompt = {"How many pages have you read? ", "The input should be a number "};

        String userName = "";
        System.out.print("Enter your name: ");
        userName = inputs.nextLine();

        System.out.println("\nWelcome " + userName + "\n");
        while(true) {
            bookPage = mainInput.regularInput(bookPrompts[0],bookPrompts[1]);
            if(bookPage < 0) {
                System.out.print("Pages read is less than the book pages\n\n");
             } else {
                break;
             }
        }

        System.out.print("\n");
        while(true) {
            readPages = mainInput.regularInput(readPrompt[0],readPrompt[1]);
            if(readPages < 0) {
                System.out.print("Pages read is less than the book pages\n\n");
            } else if (readPages > bookPage) {
                System.out.print("Pages read is more than the book pages\n\n");
            } else {
                break;
            }
        }

        if (inputs.hasNextLine()) {
            inputs.nextLine();
        }
        System.out.print("\n");

        while(true) {
            System.out.print("Issue date (MM, DD, YYYY): ");
            String inputDate = inputs.nextLine().trim();
            try {
                issueDate = LocalDate.parse(inputDate,formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Input error, try to input a proper date time\n");
            }
        }

        System.out.print("\n");

        while(true) {
            System.out.print("Due date (MM, DD, YYYY): ");
            String inputDate = inputs.nextLine().trim();
            try {
                LocalDate tempDate = LocalDate.parse(inputDate,formatter);
                if(!tempDate.isBefore(issueDate)) {
                    dueDate = tempDate;
                } else {
                    throw new IllegalArgumentException("Due date should not be before the issue date");
                }
                break;
            } catch (DateTimeParseException | IllegalArgumentException e) {
                System.out.println("Input error, try to input a proper date time\n");
            }
        }

        float percentRead = ((float) readPages / (float) bookPage) * 100;
        if(percentRead < 100) {
             System.out.printf("\nYou have read %.2f%% of the book.", percentRead);
        } else {
            System.out.print("\nYou have read the book entirely.");
        }

        currentDate = LocalDate.now();
        long daysRemainingToReturn = ChronoUnit.DAYS.between(currentDate, dueDate);
        if (daysRemainingToReturn < 0) {
            System.out.print("\nYou have to return the book today.");
        } else {
            System.out.print("\nYou have " + daysRemainingToReturn + " day/s remaining to return the book.");
        }

        int remainingPages = bookPage - readPages;
        int pagesPerDay = 0;
        if (daysRemainingToReturn > 0) {
            pagesPerDay = (int) Math.ceil((double) remainingPages / daysRemainingToReturn);
            System.out.print("\nYou should read " + pagesPerDay + " pages per day.");
        } else {
            pagesPerDay = remainingPages;
            System.out.print("\nYou should read all of the pages today.");
        }
    }
}
