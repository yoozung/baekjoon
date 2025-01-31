import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] lgs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer sto = new StringTokenizer(br.readLine());
        br.close();

        long start = Long.parseLong(sto.nextToken());
        long end   = Long.parseLong(sto.nextToken());

        for (long st = start; st <= end ; st++) {
            // 소수 검사
            if (isPalin(st)) {
                if (isSmall(st)) {
                    sb.append(st).append("\n");
                }
            }

        }
        sb.append("-1");
        bw.write(sb.toString());
        bw.flush();
    }

    /*소수판별*/
    private static boolean isSmall(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*팰린드롬 판별*/
    private static boolean isPalin(long n) {
        String num = String.valueOf(n);
        int numLen = num.length();
        for (int i = 0; i < numLen/2; i++) { // 인덱스만큼 반복
            if (num.charAt(i)!=num.charAt(numLen-(i+1))) {
                return false;
            }
        }
        return true;
    }

}