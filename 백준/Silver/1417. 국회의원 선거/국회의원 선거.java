import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        int usr = 0;
        int cnt = 0;
        
        for (int i=0; i < n; i++) {
            if (i==0) {
                usr = Integer.parseInt(br.readLine());
            } else {
                pq.add(Integer.parseInt(br.readLine()));
            }
        }
        
        if (pq.size()>0) {
            boolean isWin = false; 
            while (!isWin) {
                int pp = pq.peek();
                
                if (pp >= usr) {
                    cnt++;
                    usr++;
                    pq.poll();
                    pq.add(pp-1);
                    
                } else {
                    isWin = true;
                }
            }
        }
   
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close(); 
    }

}