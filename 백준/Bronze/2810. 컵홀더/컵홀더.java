import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        String seat = br.readLine();
        for (int i = 0; i<n; i++) {
            answer++;
            if ('L'==seat.charAt(i)) i+=1;
            if (i==n-1) answer++;
        }
        
        if (answer > n) {
            bw.write(String.valueOf(n));
        } else {
            bw.write(String.valueOf(answer));
        }
        
        bw.flush();
        bw.close();
    }

}


