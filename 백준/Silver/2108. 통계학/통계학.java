import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        double sumForAvg = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCnt = 0;
        int count[] = new int[8001];
        int[] arr = new int[n];
        List<Integer> modeList = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            count[num+4000]++;
            maxCnt = Math.max(maxCnt,count[num+4000]);
            sumForAvg += num;
            min = Math.min(min, num);
            max = Math.max(max, num);

        }

        // 최빈값 찾기
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCnt) {
                modeList.add(i - 4000); // 원래 숫자로 변환
            }
        }

        // 최빈값이 여러 개면 두 번째로 작은 값 선택
        Collections.sort(modeList);
        int mode = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0);

        Arrays.sort(arr);

        sb.append(Math.round(sumForAvg/n)).append("\n");
        sb.append(arr[n/2]).append("\n");
        sb.append(mode).append("\n");
        sb.append(max-min);

        bw.write(sb.toString());
        bw.flush();
    }
}
