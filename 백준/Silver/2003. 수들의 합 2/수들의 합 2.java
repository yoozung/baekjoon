import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(sto.nextToken());
        int m = Integer.parseInt(sto.nextToken());
        int cnt = 0;
        int[] arr = new int[n+1];

        StringTokenizer ston = new StringTokenizer(br.readLine());
        
        for (int i=1; i <= n; i++) {
            int num = Integer.parseInt(ston.nextToken());
            arr[i] = num + arr[i-1]; // 누적합
        }
        
        for (int i = 1; i<=n; i++) {
            
            for (int j = 1; j <= n; j++) {
                
                int num = arr[j] - arr[i-1];
                
                if (num == m) {
                    cnt++;
                } else if (num > m) {
                    break;
                }
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        
    }
}