import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashMap<Long,Long> map = new HashMap<>();
        StringTokenizer sto = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            long mm = Long.parseLong(sto.nextToken());
            map.put(mm,mm);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer sto2 = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            long num = Long.parseLong(sto2.nextToken());

           if (map.get(num) == null) {
               sb.append("0");
           } else {
               sb.append("1");
           }
           sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
