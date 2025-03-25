import java.util.Arrays;
import java.util.Scanner; 

public class Main {
    static int n, m;
    static int[] nums;         // 진수로 쓸 숫자들
    static int[] printArr;     // 결과 저장용
    static boolean[] visited;  // 중복 체크용
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();  // 숫자 갯수
        m = sc.nextInt();  // 진수

        printArr = new int[m];
        nums = new int[n];
        visited = new boolean[n];

        for (int i = 0 ; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        
        recur(0, 0);
        System.out.println(sb.toString());
    }

    static void recur(int cur, int start) {
        if (cur == m) {
            for (int num : printArr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            
            if (visited[i]) continue;
            
            if (start!=0&&printArr[cur-1]>nums[i]) {
                continue;
            }

            printArr[cur] = nums[i];
            visited[i] = true;
            recur(cur + 1, start+1);
            visited[i] = false; 
        }
    }

}
