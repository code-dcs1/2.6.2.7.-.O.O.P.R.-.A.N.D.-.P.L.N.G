import java.io.*;

class Main {
    public static void main(String[] args) {
        for(int i = 0; i < 5-1; i++) {
            System.out.print("*");
            for(int j = 0; j <= i; j++) {
                
                if (j < i ) {
                    System.out.print("A*");
                }
            }
            System.out.println();
        }
    }
}