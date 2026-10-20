import java.time.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<PatientWithAge> patients = new ArrayList<>();
        boolean running = true;

        System.out.println("OUTPUT IN ACTIVITY 2");
        while (running) {
            System.out.println();
            System.out.println("1. Insert New Patient");
            System.out.println("2. Display all Patient");
            System.out.println("3. Display pediatric patient");
            System.out.println("4. Exit");
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1:
                    PatientWithAge p = new PatientWithAge();
                    p.inputData();
                    patients.add(p);
                    System.out.println("Patient added.");
                    break;
                case 2:
                    if (patients.isEmpty()) {
                        System.out.println("No patients in the database.");
                    }
                    for (PatientWithAge pt : patients) {
                        pt.display();
                    }
                    break;
                case 3:
                    boolean found = false;
                    for (PatientWithAge pt : patients) {
                        if (pt.getAge() < 12) {
                            pt.display();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No pediatric patients found.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1 to 4.");
            }
        }
        System.out.println("Goodbye!");
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
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

    static Date readDate(String label) {
        while (true) {
            System.out.println(label);
            int year = readInt("  Year: ");
            int month = readInt("  Month: ");
            int day = readInt("  Day: ");
            try {
                LocalDate.of(year, month, day);
                return new Date(year, month, day);
            } catch (DateTimeException e) {
                System.out.println("Invalid date. Please try again.");
            }
        }
    }
}

class Date {
    int year;
    int month;
    int day;

    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

class Patient {
    protected String name;
    protected Date admissionDate;
    protected String disease;
    protected Date dischargeDate;

    public void inputData() {
        name = Main.readText("Name of the patient: ");
        admissionDate = Main.readDate("Date of admission:");
        disease = Main.readText("Disease: ");
        dischargeDate = Main.readDate("Date of discharge:");
    }

    public void display() {
        System.out.println("--------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Date of admission: " + admissionDate);
        System.out.println("Disease: " + disease);
        System.out.println("Date of discharge: " + dischargeDate);
    }
}

class PatientWithAge extends Patient {
    private int age;

    public int getAge() {
        return age;
    }

    @Override
    public void inputData() {
        super.inputData();
        while (true) {
            age = Main.readInt("Age: ");
            if (age >= 0 && age <= 150) {
                break;
            }
            System.out.println("Age must be between 0 and 150.");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Age: " + age);
    }
}
