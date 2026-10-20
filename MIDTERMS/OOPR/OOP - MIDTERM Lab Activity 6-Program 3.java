import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("OUTPUT IN ACTIVITY 3");

        System.out.println("Enter the Dean's details:");
        Dean dean = new Dean(readText("  Name: "), readSalary("  Salary: "), readText("  Department: "));

        System.out.println("Enter the Executive's details:");
        Executive executive = new Executive(readText("  Name: "), readSalary("  Salary: "), readText("  Department: "));

        System.out.println();
        System.out.println(dean);
        System.out.println("--------------------------------");
        System.out.println(executive);
    }

    static double readSalary(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.println("Salary must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("This field cannot be empty.");
        }
    }
}

class Professor {
    protected String name;
    protected double salary;

    Professor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Dean extends Professor {
    protected String department;

    Dean(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    protected String details() {
        return "Name: " + name + "\n"
                + "Department: " + department + "\n"
                + "Salary: " + (long) salary;
    }

    @Override
    public String toString() {
        return "Status\nRank: Dean\n" + details();
    }
}

class Executive extends Dean {
    Executive(String name, double salary, String department) {
        super(name, salary, department);
    }

    @Override
    public String toString() {
        return "Status\nRank: Executive\n" + details();
    }
}
