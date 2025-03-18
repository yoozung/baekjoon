import java.util.Arrays;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int max = 0;
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        if (max==0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        long s = 1;
        long e = max;
        long answer = 0;

        while (s<=e) {
            long mid = (s+e)/2;
            if (canDivide(arr, N, K, mid)) {
                answer = mid; 
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        System.out.println(answer);

    }


    private static boolean canDivide(int[] jugs, int N, int K, long mid) {
        int count = 0;
        for (int jug : jugs) {
            count += jug / mid;
        }
        return count >= K;
    }

}
