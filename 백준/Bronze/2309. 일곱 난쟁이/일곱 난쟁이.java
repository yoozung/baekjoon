import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int[] height = new int[9];
        int totalSum = 0;
        for (int i=0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            totalSum += height[i];
        }
        
        Arrays.sort(height);
        
        int left = 0;
        int right = 8;
        
        while (left<right) {
            
            int sum = totalSum- height[left] - height[right];
            if (sum>100) {
                left++;
            } else if (sum<100) {
                right--;
            } else { 
                for(int i=0; i<9;i++) {
                    if (i!=left && i!=right) {
                        sb.append(height[i]).append("\n");
                    }
                    
                }
                break;
            }
            
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        
    }
}