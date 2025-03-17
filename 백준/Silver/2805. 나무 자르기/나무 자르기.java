import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long N, M, maxHeight;
    static long[] arr ;

    public static void main(String[] args) throws IOException {
         write();
         solve();
    }

    private static void write() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        N = Long.parseLong(sto.nextToken());
        M = Long.parseLong(sto.nextToken());
        arr = new long[(int) N];
        StringTokenizer sto2 = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(sto2.nextToken());
            maxHeight = Math.max(maxHeight, arr[i]);
        }
    }

    private static void solve() {
        long bestHeight = 0;
        long s = 0;
        long e = maxHeight;

        while (s<=e) {
            long mid = (s+e) / 2;
            long woods = getWoods(mid);
            if (woods >= M) {
                bestHeight = mid;
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        System.out.println(bestHeight);
    }

    private static long getWoods(long h) {
        long woods = 0;
        for (long tree : arr) {
            if (tree > h) {
                woods += tree-h;
            }
        }
        return woods;
    }

}
