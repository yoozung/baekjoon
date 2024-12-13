import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer sto = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(sto.nextToken());
        int M = Integer.parseInt(sto.nextToken());

        int[] nums = new int[N+1];
        int[] calNums = new int[N+1];

        StringTokenizer num = new StringTokenizer(br.readLine());

        for (int i=1; i <= N; i++) {
            nums[i] = Integer.parseInt(num.nextToken());
        }

        for (int i=1; i <= N; i++) {
            calNums[i] = nums[i] + calNums[i-1];
        }

        for ( int i=0; i<M; i++) {
            StringTokenizer iNum = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(iNum.nextToken());
            int ed = Integer.parseInt(iNum.nextToken());
            int ans = calNums[ed] - calNums[st-1];
            sb.append(ans).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();



    }
}