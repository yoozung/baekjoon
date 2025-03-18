import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] hi = new long[N];
        long[] arc = new long[M];

        for (int i = 0; i < N; i++) hi[i] = sc.nextInt();
        for (int i = 0; i < M; i++) arc[i] = sc.nextInt();
        
        Arrays.sort(hi);
        Arrays.sort(arc);
        
        long[] result = new long[3]; 

        for (long target : hi) {
            long win = lowerBound(arc, target);
            long lose = lowerBound(arc, target + 1);

            result[2] += (lose - win);  // 무승부
            result[1] += (M - lose);    // 패배
            result[0] += win;           // 승리
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    // 작거나 같은 수 갯수 찾기
    static int lowerBound(long[] arr, long target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
