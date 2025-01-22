import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer; 
public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer sto2 = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(sto2.nextToken());
        }
        
        int max = 0;
        int str = 0;
        int end = n-1;
        
        while (str<end) {
            
            int abt = (end-str-1) * Math.min(arr[str], arr[end]);
            
            if ( arr[str] < arr[end] ) {
                str++;
            } else {
                end--;
            }
            
            max = Math.max(max, abt);
            
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        
    }
}