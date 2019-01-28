import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubarray function below.
    static int kadane(int[] arr) {

        int maxSubarray = arr[0];
        int maxUntilNow = arr[0];

        for(int i = 1; i < arr.length; i++) {
            maxUntilNow = Math.max(maxUntilNow + arr[i], arr[i]);
            maxSubarray = Math.max(maxSubarray, maxUntilNow);
        }

        return maxSubarray;
    }

    static int positiveArray(int[] arr) {
        int sum = 0;

        for(int element: arr) {
            if (element > 0) sum+=element;
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                max = Math.max(max, arrItem);
                arr[i] = arrItem;
            }

            bufferedWriter.write(String.valueOf(kadane(arr) + " "));

            if (max < 0) bufferedWriter.write(String.valueOf(max));
            else bufferedWriter.write(String.valueOf(positiveArray(arr)));

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
