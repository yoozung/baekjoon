import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer sto = new StringTokenizer(br.readLine());
        br.close();
        
        for (int i=0; i < N; i++) {
            nums[i] = Integer.parseInt(sto.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int closestSum = Integer.MAX_VALUE; 
        int ansLeft = 0; 
        int ansRight = 0; 
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                ansLeft = left;
                ansRight = right;
            }
            
            if (sum < 0) {
                left++; 
            } else if (sum > 0) {
                right--; 
            } else {
                break;
            }
        }
        
        sb.append(nums[ansLeft]).append(" ").append(nums[ansRight]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}