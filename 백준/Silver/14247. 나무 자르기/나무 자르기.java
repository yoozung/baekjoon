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
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer sto = new StringTokenizer(br.readLine());
        StringTokenizer sto2 = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        long result = 0;
        
        for (int i=0; i < n; i++) {
            result += Integer.parseInt(sto.nextToken());
            arr[i] = Integer.parseInt(sto2.nextToken());
        }

        Arrays.sort(arr);

        for (int i=0; i < n; i++) {
           result += arr[i] * i;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        
    }

}