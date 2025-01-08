import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
 
        int count = 0;  
        int idx = -1;  
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                idx = i;
            }
        }
 
        if (count > 1) {
            System.out.println(0);
            return;
        }
 
        if (count == 0) {
            System.out.println(N);
            return;
        }
 
        int result = 0;
 
        if (isSortedAfterRemoving(nums, idx)) {
            result++;
        }
 
        if (isSortedAfterRemoving(nums, idx + 1)) {
            result++;
        }

        System.out.println(result);
    }
 
    private static boolean isSortedAfterRemoving(int[] nums, int index) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == index) continue;  
            int next = (i + 1 == index) ? i + 2 : i + 1;  
            if (next < nums.length && nums[i] > nums[next]) {
                return false;
            }
        }
        return true;
    }
}
