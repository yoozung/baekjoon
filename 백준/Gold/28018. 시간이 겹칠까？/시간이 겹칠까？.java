import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 학생수 N
        int[] useTm = new int[1000001];

        for (int i = 0 ; i < N; i++) {
            StringTokenizer sto = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(sto.nextToken());
            int end = Integer.parseInt(sto.nextToken());

            useTm[str]++;
            if (end + 1 < useTm.length) {
                useTm[end + 1]--;
            }
        }

        for(int i=1; i < useTm.length; i++) {
            useTm[i] += useTm[i-1];
        }
 
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer sto2 = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < Q;i++) {
            sb.append(useTm[Integer.parseInt(sto2.nextToken())]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
