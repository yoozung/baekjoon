import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int result = Integer.MIN_VALUE;
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k]; 
        
        for (int i=0; i < k ;i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }
        
        Arrays.sort(arr);
        
        for (int i=0; i < k ;i++) {
            result = Math.max(result, arr[i]* (k-i) );
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        
    }
    

}