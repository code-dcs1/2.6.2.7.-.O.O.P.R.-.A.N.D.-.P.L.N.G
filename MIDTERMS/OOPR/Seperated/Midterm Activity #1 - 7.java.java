import java.io.File;
import java.util.Scanner;

public class Mavenproject1 {
    public static void main(String[] args) {
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
