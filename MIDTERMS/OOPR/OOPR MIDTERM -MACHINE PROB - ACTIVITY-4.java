import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Activity[] activities = {
                new PayslipActivity(sc),
                new TuitionActivity(sc),
                new PurchaseOrderActivity(sc),
                new TicketActivity(sc),
                new ReservationActivity(sc),
                new CarRentalActivity(sc),
                new RestaurantActivity(sc),
                new FlowerActivity(sc),
                new KmartActivity(sc),
                new ParkingActivity(sc)
        };

        for (int i = 0; i < activities.length; i++) {
            activities[i].run();
        }

        sc.close();
    }
}

class Customer {
    private String name;
    private String id;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return quantity * price;
    }
}

abstract class Activity {
    private int number;
    private String title;
    private Scanner input;

    public Activity(int number, String title, Scanner input) {
        this.number = number;
        this.title = title;
        this.input = input;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public void run() {
        System.out.println();
        System.out.println("Activity " + number + " - " + title);
        System.out.println();
        readInputs();
        computeResults();
        String receipt = buildReceipt();
        System.out.println();
        System.out.print(receipt);
        saveReceipt(receipt);
    }

    protected abstract void readInputs();

    protected abstract void computeResults();

    protected abstract String buildReceipt();

    private void saveReceipt(String receipt) {
        boolean append = number > 1;
        try (FileWriter writer = new FileWriter("receipts.txt", append)) {
            writer.write("Activity " + number + " - " + title + "\n");
            writer.write(receipt);
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("The receipt could not be saved to the file.");
        }
    }

    protected String readText(String prompt) {
        String text = "";
        while (text.isEmpty()) {
            System.out.print(prompt);
            text = input.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("This field cannot be empty.");
            }
        }
        return text;
    }

    protected double readNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(input.nextLine().trim().replace(",", ""));
                if (value >= 0) {
                    return value;
                }
                System.out.println("The value cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    protected int readInt(String prompt, int min) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(input.nextLine().trim());
                if (value >= min) {
                    return value;
                }
                System.out.println("The value must be at least " + min + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    protected double readPercent(String prompt) {
        while (true) {
            double value = readNumber(prompt);
            if (value <= 100) {
                return value;
            }
            System.out.println("The discount cannot be more than 100.");
        }
    }

    protected String readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = input.nextLine().trim();
            if (text.matches("\\d{4}-\\d{2}-\\d{2}")) {
                int month = Integer.parseInt(text.substring(5, 7));
                int day = Integer.parseInt(text.substring(8, 10));
                if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                    return text;
                }
            }
            System.out.println("Invalid date. Use the format YYYY-MM-DD.");
        }
    }

    protected String readLaterDate(String prompt, String earlierDate) {
        while (true) {
            String date = readDate(prompt);
            if (date.compareTo(earlierDate) >= 0) {
                return date;
            }
            System.out.println("That date cannot be earlier than " + earlierDate + ".");
        }
    }

    protected String readTime(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = input.nextLine().trim();
            if (text.matches("\\d{2}:\\d{2}")) {
                int hour = Integer.parseInt(text.substring(0, 2));
                int minute = Integer.parseInt(text.substring(3, 5));
                if (hour <= 23 && minute <= 59) {
                    return text;
                }
            }
            System.out.println("Invalid time. Use the format HH:MM.");
        }
    }

    protected String readChoice(String prompt, String first, String second) {
        while (true) {
            String text = readText(prompt);
            if (text.equalsIgnoreCase(first)) {
                return first;
            }
            if (text.equalsIgnoreCase(second)) {
                return second;
            }
            System.out.println("Please enter " + first + " or " + second + ".");
        }
    }

    protected Customer readCustomer() {
        String name = readText("Customer Name: ");
        String id = readText("Customer ID: ");
        return new Customer(name, id);
    }

    protected Item[] readItems() {
        int count = readInt("Number of Items (at least 3): ", 3);
        Item[] items = new Item[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Item " + (i + 1));
            String name = readText("  Item Name: ");
            int quantity = readInt("  Quantity: ", 1);
            double price = readNumber("  Price per Item: ");
            items[i] = new Item(name, quantity, price);
        }
        return items;
    }

    protected double sumItems(Item[] items) {
        double sum = 0;
        for (int i = 0; i < items.length; i++) {
            sum = sum + items[i].getTotal();
        }
        return sum;
    }

    protected String itemTable(Item[] items) {
        String text = String.format("%-20s%6s%12s%14s\n", "Item Name", "Qty", "Price", "Total");
        text += drawLine('-');
        for (int i = 0; i < items.length; i++) {
            text += String.format("%-20s%6d%,12.2f%,14.2f\n", items[i].getName(),
                    items[i].getQuantity(), items[i].getPrice(), items[i].getTotal());
        }
        return text;
    }

    protected String drawLine(char symbol) {
        String text = "";
        for (int i = 0; i < 52; i++) {
            text += symbol;
        }
        return text + "\n";
    }

    protected String banner(String title) {
        String text = drawLine('=');
        int space = (52 - title.length()) / 2;
        for (int i = 0; i < space; i++) {
            text += " ";
        }
        text += title + "\n";
        text += drawLine('=');
        return text;
    }

    protected String heading(String title) {
        return title + "\n" + drawLine('-');
    }

    protected String textLine(String label, String value) {
        return String.format("%-28s%24s\n", label, value);
    }

    protected String moneyLine(String label, double amount) {
        return String.format("%-28s%,24.2f\n", label, amount);
    }

    protected String paymentResult(double paid, double due) {
        if (paid >= due) {
            return moneyLine("Change", paid - due);
        }
        return moneyLine("Remaining Balance", due - paid);
    }
}

abstract class DiscountBill extends Activity {
    private double discountPercent;
    private double discountAmount;
    private double totalDue;

    public DiscountBill(int number, String title, Scanner input) {
        super(number, title, input);
    }

    protected void readDiscount() {
        discountPercent = readPercent("Discount (%): ");
    }

    protected void applyDiscount(double subtotal) {
        discountAmount = subtotal * (discountPercent / 100);
        totalDue = subtotal - discountAmount;
    }

    protected String discountLines() {
        String text = textLine("Discount (%)", String.format("%.2f%%", discountPercent));
        text += moneyLine("Discount Amount", discountAmount);
        return text;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getTotalDue() {
        return totalDue;
    }
}

class PayslipActivity extends Activity {
    private String employeeName;
    private String employeeId;
    private String department;
    private double basicSalary;
    private String startDate;
    private String endDate;
    private String payoutDate;
    private double regularHours;
    private double overtimeHours;
    private double absentDays;
    private double riceAllowance;
    private double transportAllowance;
    private double communicationAllowance;
    private double sss;
    private double philHealth;
    private double pagIbig;
    private double tax;
    private double otherDeductions;
    private double regularPay;
    private double overtimePay;
    private double absenceDeduction;
    private double totalAllowances;
    private double grossPay;
    private double totalDeductions;
    private double netPay;

    public PayslipActivity(Scanner input) {
        super(1, "Smart Payslip Generator", input);
    }

    @Override
    protected void readInputs() {
        employeeName = readText("Employee Name: ");
        employeeId = readText("Employee ID: ");
        department = readText("Department: ");
        basicSalary = readNumber("Basic Monthly Salary: ");
        startDate = readDate("Payroll Start Date (YYYY-MM-DD): ");
        endDate = readLaterDate("Payroll End Date (YYYY-MM-DD): ", startDate);
        payoutDate = readDate("Payout Date (YYYY-MM-DD): ");
        regularHours = readNumber("Total Regular Hours Worked: ");
        overtimeHours = readNumber("Overtime Hours Worked: ");
        absentDays = readNumber("Number of Absent Days: ");
        riceAllowance = readNumber("Rice Allowance: ");
        transportAllowance = readNumber("Transportation Allowance: ");
        communicationAllowance = readNumber("Communication Allowance: ");
        sss = readNumber("SSS Contribution: ");
        philHealth = readNumber("PhilHealth Contribution: ");
        pagIbig = readNumber("PAG-IBIG Contribution: ");
        tax = readNumber("Withholding Tax: ");
        otherDeductions = readNumber("Other Deductions: ");
    }

    @Override
    protected void computeResults() {
        double hourlyRate = basicSalary / 160;
        double dailyRate = basicSalary / 20;
        regularPay = regularHours * hourlyRate;
        overtimePay = overtimeHours * (hourlyRate * 1.25);
        absenceDeduction = absentDays * dailyRate;
        totalAllowances = riceAllowance + transportAllowance + communicationAllowance;
        grossPay = regularPay + overtimePay + totalAllowances;
        totalDeductions = sss + philHealth + pagIbig + tax + otherDeductions + absenceDeduction;
        netPay = grossPay - totalDeductions;
    }

    @Override
    protected String buildReceipt() {
        String text = banner("*** Smart Employee Payslip ***");
        text += heading("Employee Details");
        text += textLine("Name", employeeName);
        text += textLine("Employee ID", employeeId);
        text += textLine("Department", department);
        text += "\n";
        text += heading("Payroll Summary");
        text += textLine("Pay Period", startDate + " to " + endDate);
        text += textLine("Payout Date", payoutDate);
        text += "\n";
        text += heading("Earnings");
        text += moneyLine("Regular Pay", regularPay);
        text += moneyLine("Overtime Pay", overtimePay);
        text += moneyLine("Total Allowances", totalAllowances);
        text += moneyLine("Gross Pay", grossPay);
        text += "\n";
        text += heading("Allowances Breakdown");
        text += moneyLine("Rice Allowance", riceAllowance);
        text += moneyLine("Transportation Allowance", transportAllowance);
        text += moneyLine("Communication Allowance", communicationAllowance);
        text += "\n";
        text += heading("Deductions");
        text += moneyLine("SSS", sss);
        text += moneyLine("PhilHealth", philHealth);
        text += moneyLine("PAG-IBIG", pagIbig);
        text += moneyLine("Withholding Tax", tax);
        text += moneyLine("Absence Deduction", absenceDeduction);
        text += moneyLine("Other Deductions", otherDeductions);
        text += moneyLine("Total Deductions", totalDeductions);
        text += "\n";
        text += heading("Net Pay");
        text += moneyLine("Net Pay", netPay);
        text += drawLine('=');
        return text;
    }
}

class TuitionActivity extends Activity {
    private String studentName;
    private String studentId;
    private String course;
    private int yearLevel;
    private int units;
    private double tuitionPerUnit;
    private double miscFee;
    private double labFee;
    private double libraryFee;
    private double otherFees;
    private double downPayment;
    private double scholarship;
    private double tuitionTotal;
    private double grossTotal;
    private double netTotal;
    private double balance;

    public TuitionActivity(Scanner input) {
        super(2, "Student Tuition Fee Billing System", input);
    }

    @Override
    protected void readInputs() {
        studentName = readText("Student Name: ");
        studentId = readText("Student ID: ");
        course = readText("Course/Program (e.g., BSIT, BSCS, BSEMC): ");
        yearLevel = readInt("Year Level: ", 1);
        units = readInt("Number of Units Enrolled: ", 1);
        tuitionPerUnit = readNumber("Tuition Fee per Unit: ");
        miscFee = readNumber("Miscellaneous Fee: ");
        labFee = readNumber("Laboratory Fee: ");
        libraryFee = readNumber("Library Fee: ");
        otherFees = readNumber("Other Fees: ");
        downPayment = readNumber("Down Payment: ");
        scholarship = readNumber("Scholarship Discount (0 if none): ");
    }

    @Override
    protected void computeResults() {
        tuitionTotal = units * tuitionPerUnit;
        double additionalFees = labFee + libraryFee + otherFees;
        grossTotal = tuitionTotal + miscFee + additionalFees;
        netTotal = grossTotal - scholarship;
        balance = netTotal - downPayment;
    }

    @Override
    protected String buildReceipt() {
        String text = banner("*** STUDENT TUITION BILLING SYSTEM ***");
        text += heading("Student Details");
        text += textLine("Name", studentName);
        text += textLine("Student ID", studentId);
        text += textLine("Course", course);
        text += textLine("Year Level", String.valueOf(yearLevel));
        text += "\n";
        text += heading("Enrollment Summary");
        text += textLine("Units Enrolled", String.valueOf(units));
        text += moneyLine("Tuition per Unit", tuitionPerUnit);
        text += moneyLine("Tuition Fee Total", tuitionTotal);
        text += "\n";
        text += heading("Fees Breakdown");
        text += moneyLine("Miscellaneous Fee", miscFee);
        text += moneyLine("Laboratory Fee", labFee);
        text += moneyLine("Library Fee", libraryFee);
        text += moneyLine("Other Fees", otherFees);
        text += moneyLine("Gross Total Fee", grossTotal);
        text += "\n";
        text += heading("Payment Summary");
        text += moneyLine("Scholarship Discount", scholarship);
        text += moneyLine("Net Total Fee", netTotal);
        text += moneyLine("Down Payment", downPayment);
        text += moneyLine("Remaining Balance", balance);
        text += drawLine('=');
        return text;
    }
}

class PurchaseOrderActivity extends DiscountBill {
    private Customer customer;
    private Item[] items;
    private double subtotal;
    private double amountTendered;

    public PurchaseOrderActivity(Scanner input) {
        super(3, "Customer Purchase Order with Receipt System", input);
    }

    @Override
    protected void readInputs() {
        customer = readCustomer();
        items = readItems();
        readDiscount();
        amountTendered = readNumber("Amount Tendered: ");
    }

    @Override
    protected void computeResults() {
        subtotal = sumItems(items);
        applyDiscount(subtotal);
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** CUSTOMER RECEIPT ********");
        text += heading("Customer Details");
        text += textLine("Name", customer.getName());
        text += textLine("Customer ID", customer.getId());
        text += "\n";
        text += heading("Purchased Items");
        text += itemTable(items);
        text += "\n";
        text += heading("Payment Summary");
        text += moneyLine("Subtotal", subtotal);
        text += discountLines();
        text += moneyLine("Total Amount Due", getTotalDue());
        text += moneyLine("Amount Tendered", amountTendered);
        text += paymentResult(amountTendered, getTotalDue());
        text += drawLine('=');
        return text;
    }
}

class TicketActivity extends DiscountBill {
    private Customer customer;
    private String eventName;
    private String ticketType;
    private double ticketPrice;
    private int ticketCount;
    private double totalCost;
    private double amountTendered;

    public TicketActivity(Scanner input) {
        super(4, "Simple Ticketing System", input);
    }

    @Override
    protected void readInputs() {
        customer = readCustomer();
        eventName = readText("Event Name: ");
        ticketType = readText("Ticket Type (e.g., Regular, VIP): ");
        ticketPrice = readNumber("Ticket Price: ");
        ticketCount = readInt("Number of Tickets: ", 1);
        readDiscount();
        amountTendered = readNumber("Amount Tendered: ");
    }

    @Override
    protected void computeResults() {
        totalCost = ticketPrice * ticketCount;
        applyDiscount(totalCost);
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** EVENT TICKET ********");
        text += heading("Customer Details");
        text += textLine("Name", customer.getName());
        text += textLine("Customer ID", customer.getId());
        text += "\n";
        text += heading("Ticket Information");
        text += textLine("Event Name", eventName);
        text += textLine("Ticket Type", ticketType);
        text += moneyLine("Ticket Price", ticketPrice);
        text += textLine("Number of Tickets", String.valueOf(ticketCount));
        text += moneyLine("Total Ticket Cost", totalCost);
        text += "\n";
        text += heading("Payment Summary");
        text += discountLines();
        text += moneyLine("Final Amount Due", getTotalDue());
        text += moneyLine("Amount Tendered", amountTendered);
        text += paymentResult(amountTendered, getTotalDue());
        text += drawLine('=');
        return text;
    }
}

class ReservationActivity extends DiscountBill {
    private Customer customer;
    private String reservationType;
    private int duration;
    private double rate;
    private double foodCharges;
    private double serviceCharges;
    private double otherCharges;
    private double downPayment;
    private double reservationCost;
    private double subtotal;
    private double balance;

    public ReservationActivity(Scanner input) {
        super(5, "Simple Reservation and Billing System", input);
    }

    @Override
    protected void readInputs() {
        customer = readCustomer();
        reservationType = readText("Reservation Type (e.g., Room, Cottage, Table): ");
        duration = readInt("Number of Days / Hours Reserved: ", 1);
        rate = readNumber("Rate per Day / Hour: ");
        foodCharges = readNumber("Food Charges: ");
        serviceCharges = readNumber("Service Charges: ");
        otherCharges = readNumber("Other Charges: ");
        readDiscount();
        downPayment = readNumber("Down Payment: ");
    }

    @Override
    protected void computeResults() {
        reservationCost = duration * rate;
        double additionalCharges = foodCharges + serviceCharges + otherCharges;
        subtotal = reservationCost + additionalCharges;
        applyDiscount(subtotal);
        balance = getTotalDue() - downPayment;
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** RESERVATION BILLING ********");
        text += heading("Customer Details");
        text += textLine("Name", customer.getName());
        text += textLine("Customer ID", customer.getId());
        text += "\n";
        text += heading("Reservation Details");
        text += textLine("Reservation Type", reservationType);
        text += textLine("Duration (Days/Hours)", String.valueOf(duration));
        text += moneyLine("Rate", rate);
        text += moneyLine("Reservation Cost", reservationCost);
        text += "\n";
        text += heading("Charges Breakdown");
        text += moneyLine("Food Charges", foodCharges);
        text += moneyLine("Service Charges", serviceCharges);
        text += moneyLine("Other Charges", otherCharges);
        text += moneyLine("Subtotal", subtotal);
        text += "\n";
        text += heading("Payment Summary");
        text += discountLines();
        text += moneyLine("Total Bill", getTotalDue());
        text += moneyLine("Down Payment", downPayment);
        text += moneyLine("Remaining Balance", balance);
        text += drawLine('=');
        return text;
    }
}

class CarRentalActivity extends DiscountBill {
    private Customer customer;
    private String license;
    private String vehicleType;
    private String vehicleModel;
    private double ratePerDay;
    private int days;
    private String pickupDate;
    private String returnDate;
    private double insuranceFee;
    private double fuelCharge;
    private double otherCharges;
    private double amountPaid;
    private double rentalCost;
    private double subtotal;

    public CarRentalActivity(Scanner input) {
        super(6, "Simple CRS - Car Rental System", input);
    }

    @Override
    protected void readInputs() {
        customer = readCustomer();
        license = readText("Driver's License Number: ");
        vehicleType = readText("Vehicle Type (e.g., Sedan, SUV, Van): ");
        vehicleModel = readText("Vehicle Model: ");
        ratePerDay = readNumber("Rental Rate per Day: ");
        days = readInt("Number of Rental Days: ", 1);
        pickupDate = readDate("Pickup Date (YYYY-MM-DD): ");
        returnDate = readLaterDate("Return Date (YYYY-MM-DD): ", pickupDate);
        insuranceFee = readNumber("Insurance Fee: ");
        fuelCharge = readNumber("Fuel Charge: ");
        otherCharges = readNumber("Other Charges: ");
        readDiscount();
        amountPaid = readNumber("Amount Paid: ");
    }

    @Override
    protected void computeResults() {
        rentalCost = ratePerDay * days;
        double additionalCharges = insuranceFee + fuelCharge + otherCharges;
        subtotal = rentalCost + additionalCharges;
        applyDiscount(subtotal);
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** CAR RENTAL RECEIPT ********");
        text += heading("Customer Details");
        text += textLine("Name", customer.getName());
        text += textLine("Customer ID", customer.getId());
        text += textLine("Driver's License Number", license);
        text += "\n";
        text += heading("Vehicle Information");
        text += textLine("Vehicle Type", vehicleType);
        text += textLine("Vehicle Model", vehicleModel);
        text += moneyLine("Rate per Day", ratePerDay);
        text += "\n";
        text += heading("Rental Summary");
        text += textLine("Pickup Date", pickupDate);
        text += textLine("Return Date", returnDate);
        text += textLine("Number of Days", String.valueOf(days));
        text += moneyLine("Rental Cost", rentalCost);
        text += "\n";
        text += heading("Charges Breakdown");
        text += moneyLine("Insurance Fee", insuranceFee);
        text += moneyLine("Fuel Charge", fuelCharge);
        text += moneyLine("Other Charges", otherCharges);
        text += moneyLine("Subtotal", subtotal);
        text += "\n";
        text += heading("Payment Summary");
        text += discountLines();
        text += moneyLine("Total Amount Due", getTotalDue());
        text += moneyLine("Amount Paid", amountPaid);
        text += paymentResult(amountPaid, getTotalDue());
        text += drawLine('=');
        return text;
    }
}

class RestaurantActivity extends DiscountBill {
    private String customerName;
    private String orderType;
    private Item[] items;
    private double serviceCharge;
    private double packagingFee;
    private double amountTendered;
    private double subtotal;
    private double totalBeforeDiscount;

    public RestaurantActivity(Scanner input) {
        super(7, "Simple ROS - Restaurant Ordering System", input);
    }

    @Override
    protected void readInputs() {
        customerName = readText("Customer Name: ");
        orderType = readChoice("Order Type (Dine-In or Takeout): ", "Dine-In", "Takeout");
        items = readItems();
        serviceCharge = readNumber("Service Charge (0 if Takeout): ");
        packagingFee = readNumber("Packaging Fee (0 if Dine-In): ");
        readDiscount();
        amountTendered = readNumber("Amount Tendered: ");
    }

    @Override
    protected void computeResults() {
        subtotal = sumItems(items);
        if (orderType.equals("Dine-In")) {
            totalBeforeDiscount = subtotal + serviceCharge;
        } else {
            totalBeforeDiscount = subtotal + packagingFee;
        }
        applyDiscount(totalBeforeDiscount);
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** RESTAURANT RECEIPT ********");
        text += heading("Customer Details");
        text += textLine("Name", customerName);
        text += textLine("Order Type", orderType);
        text += "\n";
        text += heading("Order Summary");
        text += itemTable(items);
        text += "\n";
        text += heading("Billing Summary");
        text += moneyLine("Subtotal", subtotal);
        if (orderType.equals("Dine-In")) {
            text += moneyLine("Service Charge", serviceCharge);
        } else {
            text += moneyLine("Packaging Fee", packagingFee);
        }
        text += moneyLine("Total Before Discount", totalBeforeDiscount);
        text += discountLines();
        text += moneyLine("Total Amount Due", getTotalDue());
        text += moneyLine("Amount Tendered", amountTendered);
        text += paymentResult(amountTendered, getTotalDue());
        text += drawLine('=');
        return text;
    }
}

class FlowerActivity extends DiscountBill {
    private Customer customer;
    private String contact;
    private String flowerType;
    private String arrangementType;
    private double pricePerArrangement;
    private int quantity;
    private String reservationDate;
    private String deliveryDate;
    private double deliveryFee;
    private double customizationFee;
    private double otherCharges;
    private double downPayment;
    private double reservationCost;
    private double subtotal;
    private double balance;

    public FlowerActivity(Scanner input) {
        super(8, "Simple Flower Reservation with Billing System", input);
    }

    @Override
    protected void readInputs() {
        customer = readCustomer();
        contact = readText("Contact Number: ");
        flowerType = readText("Flower Type (e.g., Roses, Tulips, Sunflowers): ");
        arrangementType = readText("Arrangement Type (e.g., Bouquet, Vase, Box): ");
        pricePerArrangement = readNumber("Price per Arrangement: ");
        quantity = readInt("Quantity: ", 1);
        reservationDate = readDate("Reservation Date (YYYY-MM-DD): ");
        deliveryDate = readLaterDate("Pickup/Delivery Date (YYYY-MM-DD): ", reservationDate);
        deliveryFee = readNumber("Delivery Fee: ");
        customizationFee = readNumber("Customization Fee: ");
        otherCharges = readNumber("Other Charges: ");
        readDiscount();
        downPayment = readNumber("Down Payment: ");
    }

    @Override
    protected void computeResults() {
        reservationCost = pricePerArrangement * quantity;
        double additionalCharges = deliveryFee + customizationFee + otherCharges;
        subtotal = reservationCost + additionalCharges;
        applyDiscount(subtotal);
        balance = getTotalDue() - downPayment;
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** FLOWER RESERVATION RECEIPT ********");
        text += heading("Customer Details");
        text += textLine("Name", customer.getName());
        text += textLine("Customer ID", customer.getId());
        text += textLine("Contact Number", contact);
        text += "\n";
        text += heading("Reservation Summary");
        text += textLine("Flower Type", flowerType);
        text += textLine("Arrangement Type", arrangementType);
        text += textLine("Quantity", String.valueOf(quantity));
        text += moneyLine("Price per Arrangement", pricePerArrangement);
        text += moneyLine("Reservation Cost", reservationCost);
        text += textLine("Reservation Date", reservationDate);
        text += textLine("Pickup/Delivery Date", deliveryDate);
        text += "\n";
        text += heading("Charges Breakdown");
        text += moneyLine("Delivery Fee", deliveryFee);
        text += moneyLine("Customization Fee", customizationFee);
        text += moneyLine("Other Charges", otherCharges);
        text += moneyLine("Subtotal", subtotal);
        text += "\n";
        text += heading("Payment Summary");
        text += discountLines();
        text += moneyLine("Total Bill", getTotalDue());
        text += moneyLine("Down Payment", downPayment);
        text += moneyLine("Remaining Balance", balance);
        text += drawLine('=');
        return text;
    }
}

class KmartActivity extends DiscountBill {
    private Customer customer;
    private String contact;
    private String productName;
    private String brand;
    private double pricePerPack;
    private int quantity;
    private double packagingFee;
    private double deliveryFee;
    private double cashPayment;
    private double productCost;
    private double subtotal;

    public KmartActivity(Scanner input) {
        super(9, "KMART Korean Noodles Purchase Order with Billing System", input);
    }

    @Override
    protected void readInputs() {
        customer = readCustomer();
        contact = readText("Contact Number: ");
        productName = readText("Product Name (e.g., Shin Ramyun, Chapagetti, Neoguri): ");
        brand = readText("Brand: ");
        pricePerPack = readNumber("Price per Pack: ");
        quantity = readInt("Quantity: ", 1);
        packagingFee = readNumber("Packaging Fee: ");
        deliveryFee = readNumber("Delivery Fee (0 if none): ");
        readDiscount();
        cashPayment = readNumber("Cash Payment: ");
    }

    @Override
    protected void computeResults() {
        productCost = pricePerPack * quantity;
        subtotal = productCost + packagingFee + deliveryFee;
        applyDiscount(subtotal);
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** KMART PURCHASE RECEIPT ********");
        text += heading("Customer Details");
        text += textLine("Name", customer.getName());
        text += textLine("Customer ID", customer.getId());
        text += textLine("Contact Number", contact);
        text += "\n";
        text += heading("Order Summary");
        text += textLine("Product Name", productName);
        text += textLine("Brand", brand);
        text += moneyLine("Price per Pack", pricePerPack);
        text += textLine("Quantity", String.valueOf(quantity));
        text += moneyLine("Total Product Cost", productCost);
        text += "\n";
        text += heading("Charges");
        text += moneyLine("Packaging Fee", packagingFee);
        text += moneyLine("Delivery Fee", deliveryFee);
        text += moneyLine("Subtotal", subtotal);
        text += "\n";
        text += heading("Payment Summary");
        text += discountLines();
        text += moneyLine("Total Bill", getTotalDue());
        text += moneyLine("Cash Payment", cashPayment);
        text += paymentResult(cashPayment, getTotalDue());
        text += drawLine('=');
        return text;
    }
}

class ParkingActivity extends DiscountBill {
    private Customer customer;
    private String contact;
    private String vehicleType;
    private String plateNumber;
    private String entryTime;
    private String exitTime;
    private double hourlyRate;
    private double reservationFee;
    private double overnightFee;
    private double penaltyFee;
    private double cashPayment;
    private double totalHours;
    private double parkingFee;
    private double subtotal;

    public ParkingActivity(Scanner input) {
        super(10, "Car and Motor Parking Reservation and Billing System", input);
    }

    private int toMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        return hour * 60 + minute;
    }

    @Override
    protected void readInputs() {
        customer = readCustomer();
        contact = readText("Contact Number: ");
        vehicleType = readChoice("Vehicle Type (Car or Motorcycle): ", "Car", "Motorcycle");
        plateNumber = readText("Plate Number: ");
        entryTime = readTime("Entry Time (HH:MM): ");
        exitTime = readTime("Exit Time (HH:MM): ");
        hourlyRate = readNumber("Hourly Rate: ");
        reservationFee = readNumber("Reservation Fee: ");
        overnightFee = readNumber("Overnight Fee (0 if none): ");
        penaltyFee = readNumber("Penalty Fee (0 if none): ");
        readDiscount();
        cashPayment = readNumber("Cash Payment: ");
    }

    @Override
    protected void computeResults() {
        int minutes = toMinutes(exitTime) - toMinutes(entryTime);
        if (minutes < 0) {
            minutes = minutes + 24 * 60;
        }
        totalHours = minutes / 60.0;
        parkingFee = totalHours * hourlyRate;
        subtotal = parkingFee + reservationFee + overnightFee + penaltyFee;
        applyDiscount(subtotal);
    }

    @Override
    protected String buildReceipt() {
        String text = banner("******** PARKING RECEIPT ********");
        text += heading("Customer Details");
        text += textLine("Name", customer.getName());
        text += textLine("Customer ID", customer.getId());
        text += textLine("Contact Number", contact);
        text += "\n";
        text += heading("Vehicle Details");
        text += textLine("Vehicle Type", vehicleType);
        text += textLine("Plate Number", plateNumber);
        text += "\n";
        text += heading("Parking Summary");
        text += textLine("Entry Time", entryTime);
        text += textLine("Exit Time", exitTime);
        text += textLine("Total Hours", String.format("%.2f", totalHours));
        text += moneyLine("Hourly Rate", hourlyRate);
        text += moneyLine("Parking Fee", parkingFee);
        text += "\n";
        text += heading("Charges Breakdown");
        text += moneyLine("Reservation Fee", reservationFee);
        text += moneyLine("Overnight Fee", overnightFee);
        text += moneyLine("Penalty Fee", penaltyFee);
        text += moneyLine("Subtotal", subtotal);
        text += "\n";
        text += heading("Payment Summary");
        text += discountLines();
        text += moneyLine("Total Bill", getTotalDue());
        text += moneyLine("Cash Payment", cashPayment);
        text += paymentResult(cashPayment, getTotalDue());
        text += drawLine('=');
        return text;
    }
}
