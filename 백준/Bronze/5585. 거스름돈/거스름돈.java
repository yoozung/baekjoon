import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int pay = Integer.parseInt(br.readLine());
        int change = 1000 - pay;
        int answer = 0; 
        int[] money = {500, 100, 50, 10, 5, 1};
            
        for (int i=0; i<6; i++) {
            int minus = 0 ;
            if (change >= money[i]) {
                minus = change/money[i];
                change -= minus*money[i];
                answer += minus;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close(); 
    }

}


