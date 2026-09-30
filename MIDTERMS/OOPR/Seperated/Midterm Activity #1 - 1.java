import java.io.*;

class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lists = new int[10];
        int[] calc = {0,0,0,0};
        for(int i = 0; i < 10; i++) {
            try {
                System.out.print("Enter the no." + (i+1) + " number: ");
                lists[i] = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Input error, defaulting to default 0");
                lists[i] = 0;
            }    
        }

        for(int i = 0; i < 10; i++) {
            if(lists[i] >= 0) {
                calc[0] += lists[i];
            }

            if(lists[i] < 0) {
                calc[1] += 1;
            }
        }

        float avg = 0;
        if(calc[0]>0) {
            avg = calc[0]/10;
        } else {
            avg = 0;
        }
        
        System.out.println("\nThe sum of positive numbers is " + calc[0] + " and the average of them is " + avg + " they are the numbers ");

        for(int i = 0; i < 10; i++) {
            if(lists[i] >= 0) {
                 System.out.print(lists[i] + " ");
            }
        }

        System.out.println("\nThe total amount of negative numbers is " + calc[1] + " and they are the numbers ");
        for(int i = 0; i < 10; i++) {
            if(lists[i] < 0) {
                 System.out.print(lists[i] + " ");
            }
        }

        int n = lists.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (lists[j] > lists[j + 1]) {
                    int temp = lists[j];
                    lists[j] = lists[j + 1];
                    lists[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("\nMinimum Value in the array is: " + lists[0]);
    }
}
