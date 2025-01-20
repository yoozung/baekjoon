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
        
        int n = Integer.parseInt(sto.nextToken()); // 횡단보도 갯수
        int k = Integer.parseInt(sto.nextToken()); // 연속 돼야 하는 수
        int b = Integer.parseInt(sto.nextToken()); // 고장난 신호등 갯수
        boolean[] arr = new boolean[n+1];
        
        for (int i=0; i < b; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = true;
        }
        
        int minCnt = Integer.MAX_VALUE;
        int left = 1;
        int right = 1;
        int cnt = 0;
        
        while(right <= n) {
            
            if (arr[right]) {
                cnt++;
            }
            
            if (right - left + 1 == k) {
                minCnt = Math.min(cnt, minCnt);
                
                if (arr[left]) {
                    cnt--;
                }
                left++;
                
            }
            right++;
            
        }
        
        bw.write(String.valueOf(minCnt));
        bw.flush();
        bw.close();
        
    }
}