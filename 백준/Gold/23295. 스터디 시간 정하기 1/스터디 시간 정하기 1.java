import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer; 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer sto = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(sto.nextToken()); // 참가자 수
        int T = Integer.parseInt(sto.nextToken()); // 찾아야할 시간
        int[] usingTm = new int[100001];
        int lastTm = 0;

        for (int i = 0; i < N; i++) {
            int 참여횟수 = Integer.parseInt(br.readLine());
            for (int y = 0; y < 참여횟수; y++) {
                StringTokenizer sto2 = new StringTokenizer(br.readLine());
                int str = Integer.parseInt(sto2.nextToken());
                int end = Integer.parseInt(sto2.nextToken());
                lastTm = Math.max(lastTm, end);

                usingTm[str]++;
                if (end < usingTm.length) {
                    usingTm[end]--;
                }
            }
        }

        // 시간대별 참여자수 배열, 누적합배열 만들기
        int[] prefixSum = new int[usingTm.length];
        prefixSum[0] = usingTm[0];
        for (int i = 1; i <= lastTm; i++) {
            usingTm[i] += usingTm[i - 1]; // 이모스배열 
            prefixSum[i] = prefixSum[i - 1] + usingTm[i]; // 누적합배열
        }
 
        int maxTm = prefixSum[T-1]; // 0번째부터 T번째 누적합으로 초기화
        int minStartIdx = 0;
        int minEndIdx = T; 

        for (int i = 1; i < lastTm + 1; i++) {  
            if (i+T-1 > lastTm) break;
            int 구간합 = prefixSum[i + T-1] - prefixSum[i - 1] ; 
            if (maxTm < 구간합) {
                maxTm = 구간합; 
                    minStartIdx = i;
                    minEndIdx = i + T; 

            }
        } 

        sb.append(minStartIdx).append(" ").append(minEndIdx);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
