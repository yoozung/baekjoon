import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer n = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(n.nextToken());
        
        int[][] arr = new int[N][2];
        
        for (int i=0; i < N; i++) {
            StringTokenizer num = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(num.nextToken()); // 위치
            arr[i][1] = Integer.parseInt(num.nextToken());  // 높이
        }
        
        br.close();
        
        // 위치 기준 오름차순 정렬
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        
//      1. 제일 높은 거 뽑아둠
        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (maxHeight <  arr[i][1] ) {
                maxHeight = arr[i][1];
                maxIdx = i;
            }
        }
        
//      2. 제일 높은거 기준으로 왼쪽/오른쪽 나눠서 면적 구하기
        int area = 0;
        int leftMax = 0;
        for (int i = 0; i <= maxIdx; i++) {
            leftMax = Math.max(leftMax, arr[i][1]);
            if (i < maxIdx) {
                area += leftMax * (arr[i + 1][0] - arr[i][0]);
            }
        }
        
        // 2. 오른쪽 면적 계산
        int rightMax = 0;
        for (int i = N - 1; i >= maxIdx; i--) {
            rightMax = Math.max(rightMax, arr[i][1]);
            if (i > maxIdx) {
                area += rightMax * (arr[i][0] - arr[i - 1][0]);
            }
        }
        
        area += maxHeight;
        bw.write(String.valueOf(area));
        bw.flush();
        bw.close(); 
    }
}