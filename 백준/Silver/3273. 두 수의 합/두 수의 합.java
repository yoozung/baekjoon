import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 배열 수
        int[] arr = new int[N];

        // 배열 입력 받기
        StringTokenizer sto = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(sto.nextToken());
        }
        Arrays.sort(arr);

        int X = Integer.parseInt(br.readLine()); // x 입력 받기
        br.close();

        int s = 0;
        int e = N-1;
        int answer = 0;

        while (s<e) {
            int sum = arr[s] + arr[e];
            if (X<sum) {
                e--;
            } else if (X>sum) {
                s++;
            } else {
                s++;
                e--;
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
