import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int answer = 0;
        
        for (int i=0; i < n; i++) {
            arr[i] =  Integer.parseInt(br.readLine());
        }
        
        for (int i = n-2; i>=0; i--) {
            if (arr[i] > arr[i+1] ) {
                int num = ( arr[i] - arr[i+1] ) + 1;
                arr[i] -= num;
                answer += num;
                
            } else if (arr[i]==arr[i+1]) {
                arr[i]--;
                answer++;
            }
        } 
        System.out.println(answer);
        
    }

}


