import java.util.Scanner;

public class OOPR_MidtermLabActivity3 {
    public static void main(String[] args) {
        System.out.println("ACTIVITY #1");
        VowelOrConsonant.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #2");
        DateInWords.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #3");
        Temperature.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #4");
        AircraftLabel.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #5");
        ShipClass.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #6");
        RichterScale.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #7");
        NumberInWords.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #8");
        RomanNumerals.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #9");
        TuitionFee.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #10");
        GradeEquivalent.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #11");
        SquaredNumbers.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #12");
        AlternateSequence.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #13");
        ReverseAlternateSequence.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #14");
        Factorial.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #15");
        Fibonacci.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #16");
        PowerValue.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #17");
        SumOfSquares.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #18");
        SumOfSequence.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #19");
        ReverseNumber.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #20");
        SumOfPowers.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #21");
        RightAngleTriangle.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #22");
        FloydsTriangle.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #23");
        OddPyramid.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #24");
        NumberPyramid.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #25");
        StarPyramid.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #26");
        CountingPyramid.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #27");
        CountingTriangle.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #28");
        RepeatedNumberTriangle.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #29");
        NumberTriangle.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #30");
        Diamond.main(args);
        System.out.println("\n");

        System.out.println("ACTIVITY #31");
        PalindromePyramid.main(args);
        System.out.println("\n");

        System.out.println("ALL 31 ACTIVITIES FINISHED");
    }
}

class VowelOrConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char letter = sc.next().charAt(0);

        if (!Character.isLetter(letter)) {
            System.out.println("Not a letter");
            return;
        }

        System.out.println("1st Solution: if / else if / else");
        if (letter == 'A' || letter == 'a') {
            System.out.println("VOWEL");
        } else if (letter == 'E' || letter == 'e') {
            System.out.println("VOWEL");
        } else if (letter == 'I' || letter == 'i') {
            System.out.println("VOWEL");
        } else if (letter == 'O' || letter == 'o') {
            System.out.println("VOWEL");
        } else if (letter == 'U' || letter == 'u') {
            System.out.println("VOWEL");
        } else {
            System.out.println("CONSONANT");
        }

        System.out.println("2nd Solution: switch / case");
        switch (letter) {
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'I':
            case 'i':
            case 'O':
            case 'o':
            case 'U':
            case 'u':
                System.out.println("VOWEL");
                break;
            default:
                System.out.println("CONSONANT");
        }
    }
}

class DateInWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month day year (example 2 26 1986): ");
        int month = sc.nextInt();
        int day = sc.nextInt();
        int year = sc.nextInt();
        String name = "";

        System.out.println("1st Solution: if / else if / else");
        if (month == 1) {
            name = "January";
        } else if (month == 2) {
            name = "February";
        } else if (month == 3) {
            name = "March";
        } else if (month == 4) {
            name = "April";
        } else if (month == 5) {
            name = "May";
        } else if (month == 6) {
            name = "June";
        } else if (month == 7) {
            name = "July";
        } else if (month == 8) {
            name = "August";
        } else if (month == 9) {
            name = "September";
        } else if (month == 10) {
            name = "October";
        } else if (month == 11) {
            name = "November";
        } else if (month == 12) {
            name = "December";
        } else {
            name = "Invalid month";
        }
        if (name.equals("Invalid month")) {
            System.out.println(name);
        } else {
            System.out.println(name + " " + day + ", " + year);
        }

        System.out.println("2nd Solution: switch / case");
        switch (month) {
            case 1:
                name = "January";
                break;
            case 2:
                name = "February";
                break;
            case 3:
                name = "March";
                break;
            case 4:
                name = "April";
                break;
            case 5:
                name = "May";
                break;
            case 6:
                name = "June";
                break;
            case 7:
                name = "July";
                break;
            case 8:
                name = "August";
                break;
            case 9:
                name = "September";
                break;
            case 10:
                name = "October";
                break;
            case 11:
                name = "November";
                break;
            case 12:
                name = "December";
                break;
            default:
                name = "Invalid month";
        }
        if (name.equals("Invalid month")) {
            System.out.println(name);
        } else {
            System.out.println(name + " " + day + ", " + year);
        }
    }
}

class Temperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the temp: ");
        double temp = sc.nextDouble();

        if (temp < 0) {
            System.out.println("ICE");
        } else if (temp <= 100) {
            System.out.println("WATER");
        } else {
            System.out.println("STEAM");
        }
    }
}

class AircraftLabel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the speed in km/h: ");
        double speed = sc.nextDouble();
        System.out.print("Enter the length in meters: ");
        double length = sc.nextDouble();

        if (speed > 1100 && length > 52) {
            System.out.println("civilian");
        } else if (speed >= 500 && length <= 52) {
            System.out.println("military");
        } else {
            System.out.println("It's a bird");
        }
    }
}

class ShipClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the class ID: ");
        char id = sc.next().charAt(0);

        System.out.println("1st Solution: if / else if / else");
        if (id == 'B' || id == 'b') {
            System.out.println("Battleship");
        } else if (id == 'C' || id == 'c') {
            System.out.println("Cruiser");
        } else if (id == 'D' || id == 'd') {
            System.out.println("Destroyer");
        } else if (id == 'F' || id == 'f') {
            System.out.println("Frigate");
        } else {
            System.out.println("Unknown class ID");
        }

        System.out.println("2nd Solution: switch / case");
        switch (id) {
            case 'B':
            case 'b':
                System.out.println("Battleship");
                break;
            case 'C':
            case 'c':
                System.out.println("Cruiser");
                break;
            case 'D':
            case 'd':
                System.out.println("Destroyer");
                break;
            case 'F':
            case 'f':
                System.out.println("Frigate");
                break;
            default:
                System.out.println("Unknown class ID");
        }
    }
}

class RichterScale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the richter scale: ");
        double n = sc.nextDouble();

        if (n < 5.0) {
            System.out.println("Little or no damage");
        } else if (n < 5.5) {
            System.out.println("Some damage");
        } else if (n < 6.5) {
            System.out.println("Serious damage");
        } else if (n < 7.5) {
            System.out.println("Disaster");
        } else {
            System.out.println("Catastrophe");
        }
    }
}

class NumberInWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number < 0 || number > 3000) {
            System.out.println("Out-of-Range");
            return;
        }
        if (number == 0) {
            System.out.println("zero");
            return;
        }

        String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen" };
        String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        int n = number;
        String words = "";
        if (n >= 1000) {
            words = words + ones[n / 1000] + " thousand ";
            n = n % 1000;
        }
        if (n >= 100) {
            words = words + ones[n / 100] + " hundred ";
            n = n % 100;
        }
        if (n >= 20) {
            words = words + tens[n / 10] + " ";
            n = n % 10;
        }
        if (n > 0) {
            words = words + ones[n] + " ";
        }
        System.out.println(words.trim());
    }
}

class RomanNumerals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number < 1 || number > 3000) {
            System.out.println("Out-of-Range");
            return;
        }

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        String roman = "";
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman = roman + symbols[i];
                number = number - values[i];
            }
        }
        System.out.println(roman);
    }
}

class TuitionFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter tuition fee: ");
        double fee = sc.nextDouble();
        System.out.println("(Press 1 for Cash, 2 for Two-Installment, 3 for Three-Installment)");
        System.out.print("Enter mode of payment: ");
        int mode = sc.nextInt();

        double total = 0;
        if (mode == 1) {
            total = fee - (fee * 0.10);
        } else if (mode == 2) {
            total = fee - (fee * 0.05);
        } else if (mode == 3) {
            total = fee + (fee * 0.10);
        } else {
            System.out.println("Invalid mode of payment");
            return;
        }
        System.out.printf("Your total tuition fee is: %,.2f%n", total);
    }
}

class GradeEquivalent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the percentile grade: ");
        double grade = sc.nextDouble();

        if (grade > 100 || grade < 0) {
            System.out.println("Out-of-Range");
        } else if (grade >= 98) {
            System.out.println("1.00");
        } else if (grade >= 95) {
            System.out.println("1.25");
        } else if (grade >= 92) {
            System.out.println("1.50");
        } else if (grade >= 89) {
            System.out.println("1.75");
        } else if (grade >= 85) {
            System.out.println("2.00");
        } else if (grade >= 82) {
            System.out.println("2.25");
        } else if (grade >= 80) {
            System.out.println("2.50");
        } else if (grade >= 77) {
            System.out.println("2.75");
        } else if (grade >= 75) {
            System.out.println("3.00");
        } else {
            System.out.println("Out-of-Range");
        }
    }
}

class SquaredNumbers {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("1st Solution: for loop");
        System.out.println("Sequence nos.\tSquared");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "\t\t" + (i * i));
        }

        System.out.println("2nd Solution: while loop");
        System.out.println("Sequence nos.\tSquared");
        int w = 1;
        while (w <= n) {
            System.out.println(w + "\t\t" + (w * w));
            w++;
        }

        System.out.println("3rd Solution: do while loop");
        System.out.println("Sequence nos.\tSquared");
        int d = 1;
        do {
            System.out.println(d + "\t\t" + (d * d));
            d++;
        } while (d <= n);
    }
}

class AlternateSequence {
    public static void main(String[] args) {
        System.out.println("1st Solution: for loop");
        for (int a = 1, b = 5; a <= 5; a++, b--) {
            System.out.print(a + ", " + b + ", ");
        }
        System.out.println();

        System.out.println("2nd Solution: while loop");
        int a2 = 1;
        int b2 = 5;
        while (a2 <= 5) {
            System.out.print(a2 + ", " + b2 + ", ");
            a2++;
            b2--;
        }
        System.out.println();

        System.out.println("3rd Solution: do while loop");
        int a3 = 1;
        int b3 = 5;
        do {
            System.out.print(a3 + ", " + b3 + ", ");
            a3++;
            b3--;
        } while (a3 <= 5);
        System.out.println();
    }
}

class ReverseAlternateSequence {
    public static void main(String[] args) {
        System.out.println("1st Solution: for loop");
        for (int a = 5, b = 1; a >= 1; a--, b++) {
            System.out.print(a + ", " + b + ", ");
        }
        System.out.println();

        System.out.println("2nd Solution: while loop");
        int a2 = 5;
        int b2 = 1;
        while (a2 >= 1) {
            System.out.print(a2 + ", " + b2 + ", ");
            a2--;
            b2++;
        }
        System.out.println();

        System.out.println("3rd Solution: do while loop");
        int a3 = 5;
        int b3 = 1;
        do {
            System.out.print(a3 + ", " + b3 + ", ");
            a3--;
            b3++;
        } while (a3 >= 1);
        System.out.println();
    }
}

class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. ");
        int n = sc.nextInt();
        if (n < 1 || n > 20) {
            System.out.println("Enter a number from 1 to 20");
            return;
        }
        long f;
        String steps;

        System.out.println("1st Solution: for loop");
        f = 1;
        steps = "";
        for (int i = 1; i <= n; i++) {
            f = f * i;
            steps = steps + i;
            if (i < n) {
                steps = steps + "*";
            }
        }
        System.out.println("Factorial value : " + f);
        System.out.println("( The computation is : " + steps + "=" + f + ")");

        System.out.println("2nd Solution: while loop");
        f = 1;
        steps = "";
        int w = 1;
        while (w <= n) {
            f = f * w;
            steps = steps + w;
            if (w < n) {
                steps = steps + "*";
            }
            w++;
        }
        System.out.println("Factorial value : " + f);
        System.out.println("( The computation is : " + steps + "=" + f + ")");

        System.out.println("3rd Solution: do while loop");
        f = 1;
        steps = "";
        int d = 1;
        do {
            f = f * d;
            steps = steps + d;
            if (d < n) {
                steps = steps + "*";
            }
            d++;
        } while (d <= n);
        System.out.println("Factorial value : " + f);
        System.out.println("( The computation is : " + steps + "=" + f + ")");
    }
}

class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. ");
        int n = sc.nextInt();
        if (n < 1 || n > 90) {
            System.out.println("Enter a number from 1 to 90");
            return;
        }
        long a;
        long b;

        System.out.println("1st Solution: for loop");
        System.out.print("Fibonacci series: ");
        a = 1;
        b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
        }
        System.out.println();

        System.out.println("2nd Solution: while loop");
        System.out.print("Fibonacci series: ");
        a = 1;
        b = 1;
        int w = 1;
        while (w <= n) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            w++;
        }
        System.out.println();

        System.out.println("3rd Solution: do while loop");
        System.out.print("Fibonacci series: ");
        a = 1;
        b = 1;
        int d = 1;
        do {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            d++;
        } while (d <= n);
        System.out.println();
    }
}

class PowerValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base no. ");
        int base = sc.nextInt();
        System.out.print("Enter exponent no. ");
        int exp = sc.nextInt();
        if (exp < 1) {
            System.out.println("The exponent must be 1 or more");
            return;
        }
        long result;
        String steps;

        System.out.println("1st Solution: for loop");
        result = 1;
        steps = "";
        for (int i = 1; i <= exp; i++) {
            result = result * base;
            steps = steps + base;
            if (i < exp) {
                steps = steps + " * ";
            }
        }
        System.out.println("Power value: " + result);
        System.out.println("( The computation is : " + base + "^" + exp + " = " + steps + " = " + result + ")");

        System.out.println("2nd Solution: while loop");
        result = 1;
        steps = "";
        int w = 1;
        while (w <= exp) {
            result = result * base;
            steps = steps + base;
            if (w < exp) {
                steps = steps + " * ";
            }
            w++;
        }
        System.out.println("Power value: " + result);
        System.out.println("( The computation is : " + base + "^" + exp + " = " + steps + " = " + result + ")");

        System.out.println("3rd Solution: do while loop");
        result = 1;
        steps = "";
        int d = 1;
        do {
            result = result * base;
            steps = steps + base;
            if (d < exp) {
                steps = steps + " * ";
            }
            d++;
        } while (d <= exp);
        System.out.println("Power value: " + result);
        System.out.println("( The computation is : " + base + "^" + exp + " = " + steps + " = " + result + ")");
    }
}

class SumOfSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Enter a number greater than 0");
            return;
        }
        long sum;
        String steps;

        System.out.println("1st Solution: for loop");
        sum = 0;
        steps = "";
        for (int i = 1; i <= n; i++) {
            sum = sum + (i * i);
            steps = steps + (i * i);
            if (i < n) {
                steps = steps + " + ";
            }
        }
        System.out.println("Sum of squares: " + sum);
        System.out.println(steps + " = " + sum);

        System.out.println("2nd Solution: while loop");
        sum = 0;
        steps = "";
        int w = 1;
        while (w <= n) {
            sum = sum + (w * w);
            steps = steps + (w * w);
            if (w < n) {
                steps = steps + " + ";
            }
            w++;
        }
        System.out.println("Sum of squares: " + sum);
        System.out.println(steps + " = " + sum);

        System.out.println("3rd Solution: do while loop");
        sum = 0;
        steps = "";
        int d = 1;
        do {
            sum = sum + (d * d);
            steps = steps + (d * d);
            if (d < n) {
                steps = steps + " + ";
            }
            d++;
        } while (d <= n);
        System.out.println("Sum of squares: " + sum);
        System.out.println(steps + " = " + sum);
    }
}

class SumOfSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Enter a number greater than 0");
            return;
        }
        long sum;
        String steps;

        System.out.println("1st Solution: for loop");
        sum = 0;
        steps = "";
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            steps = steps + i;
            if (i < n) {
                steps = steps + " + ";
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println(steps + " = " + sum);

        System.out.println("2nd Solution: while loop");
        sum = 0;
        steps = "";
        int w = 1;
        while (w <= n) {
            sum = sum + w;
            steps = steps + w;
            if (w < n) {
                steps = steps + " + ";
            }
            w++;
        }
        System.out.println("Sum: " + sum);
        System.out.println(steps + " = " + sum);

        System.out.println("3rd Solution: do while loop");
        sum = 0;
        steps = "";
        int d = 1;
        do {
            sum = sum + d;
            steps = steps + d;
            if (d < n) {
                steps = steps + " + ";
            }
            d++;
        } while (d <= n);
        System.out.println("Sum: " + sum);
        System.out.println(steps + " = " + sum);
    }
}

class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Enter a number greater than 0");
            return;
        }
        int rev;

        System.out.println("1st Solution: for loop");
        rev = 0;
        for (int t = n; t > 0; t = t / 10) {
            rev = rev * 10 + t % 10;
        }
        System.out.println("Reverse number: " + rev);

        System.out.println("2nd Solution: while loop");
        rev = 0;
        int w = n;
        while (w > 0) {
            rev = rev * 10 + w % 10;
            w = w / 10;
        }
        System.out.println("Reverse number: " + rev);

        System.out.println("3rd Solution: do while loop");
        rev = 0;
        int d = n;
        do {
            rev = rev * 10 + d % 10;
            d = d / 10;
        } while (d > 0);
        System.out.println("Reverse number: " + rev);
    }
}

class SumOfPowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (n < 1 || n > 15) {
            System.out.println("Enter a number from 1 to 15");
            return;
        }
        long sum;
        long power;
        String steps;

        System.out.println("1st Solution: for loop");
        sum = 0;
        steps = "";
        for (int i = 1; i <= n; i++) {
            power = 1;
            for (int j = 1; j <= i; j++) {
                power = power * i;
            }
            sum = sum + power;
            steps = steps + power;
            if (i < n) {
                steps = steps + " + ";
            }
        }
        System.out.println("Sum of powers: " + sum);
        System.out.println(steps + " = " + sum);

        System.out.println("2nd Solution: while loop");
        sum = 0;
        steps = "";
        int w = 1;
        while (w <= n) {
            power = 1;
            int x = 1;
            while (x <= w) {
                power = power * w;
                x++;
            }
            sum = sum + power;
            steps = steps + power;
            if (w < n) {
                steps = steps + " + ";
            }
            w++;
        }
        System.out.println("Sum of powers: " + sum);
        System.out.println(steps + " = " + sum);

        System.out.println("3rd Solution: do while loop");
        sum = 0;
        steps = "";
        int d = 1;
        do {
            power = 1;
            int y = 1;
            do {
                power = power * d;
                y++;
            } while (y <= d);
            sum = sum + power;
            steps = steps + power;
            if (d < n) {
                steps = steps + " + ";
            }
            d++;
        } while (d <= n);
        System.out.println("Sum of powers: " + sum);
        System.out.println(steps + " = " + sum);
    }
}

class RightAngleTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

class FloydsTriangleA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}

class OddPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int s = 1; s <= 2 * (rows - i); s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

class NumberPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int s = 1; s <= rows - i; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class StarPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int s = 1; s <= rows - i; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

class CountingPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        int counter = 1;
        for (int i = 1; i <= rows; i++) {
            for (int s = 1; s <= rows - i; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
}

class CountingTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        int counter = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
}

class RepeatedNumberTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class NumberTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

class Diamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int s = 1; s <= 2 * (rows - i); s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int s = 1; s <= 2 * (rows - i); s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

class PalindromePyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows : ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            for (int s = 1; s <= 2 * (rows - i); s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}