import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sto.nextToken());
        int K = Integer.parseInt(sto.nextToken());
        int[] nums = new int[N];
        StringTokenizer tmp = new StringTokenizer(br.readLine());
        br.close();

        for(int i=0; i < N; i++) {
            nums[i] = Integer.parseInt(tmp.nextToken());
        }
        
        int max= Integer.MIN_VALUE;

        for ( int i=0; i < nums.length; i++) {
            if(i+K>nums.length) break;
            int calc=0;
            for (int y =0; y < K; y++) {
                calc+=nums[i+y];
            }
            max = calc>max ? calc:max;
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}
