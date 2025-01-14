import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer sto = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(sto.nextToken());
        int m = Integer.parseInt(sto.nextToken());
        
        int[] arr = new int[n+m];

        StringTokenizer ston = new StringTokenizer(br.readLine());
        
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(ston.nextToken());
        }
        
        StringTokenizer stom = new StringTokenizer(br.readLine());
        
        for (int i=n; i < n+m; i++) {
            arr[i] = Integer.parseInt(stom.nextToken());
        } 
        Arrays.sort(arr);
        
        for (int i = 0; i<n+m; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}