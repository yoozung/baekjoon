import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        StringTokenizer sto2 = new StringTokenizer(br.readLine());
        br.close();

        int n= Integer.parseInt(sto.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sto2.nextToken());
        }

        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();

    }
}
