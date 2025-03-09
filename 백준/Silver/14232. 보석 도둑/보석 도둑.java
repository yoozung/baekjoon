import java.io.*;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer sto = new StringTokenizer(br.readLine());
        br.close();
 
        long n = Long.parseLong(sto.nextToken());
        long x = n;
        int amount = 0;

        // 소인수분해
        for (long i = 2; i * i <= n; i++) {
            while (x % i == 0) {
                amount++;
                sb.append(i).append(" ");
                x /= i;
            }
        }

        // 마지막 소인수 추가
        if (x != 1) {
            amount++;
            sb.append(x);
        }

        // 결과 출력
        bw.write(String.valueOf(amount));
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
    }

}
