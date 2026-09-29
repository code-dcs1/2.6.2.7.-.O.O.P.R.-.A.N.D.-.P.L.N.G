import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word1 = "", word2 = "", word3 = "";

        try {
            System.out.print("Enter first word: ");
            word1 = reader.readLine();
            
            System.out.print("Enter second word: ");
            word2 = reader.readLine();
            
            System.out.print("Enter third word: ");
            word3 = reader.readLine();
            
            System.out.println(word1 + " " + word2 + " " + word3);
        } catch (IOException e) {
            System.out.println("Input error");
        }
    }
}
