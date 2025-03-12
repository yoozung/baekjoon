import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] sangGeuns;
    static int[] nums;
    static int[] cnt = new int[20000001];

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(sb.toString());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer sto = new StringTokenizer(br.readLine());
        sangGeuns = new int[N];
        for (int i=0; i<N; i++) {
            sangGeuns[i] =  Integer.parseInt(sto.nextToken());
            cnt[sangGeuns[i]+10000000]++;
        }
        
        M = Integer.parseInt(br.readLine());
        StringTokenizer sto2 = new StringTokenizer(br.readLine());
        nums = new int[M];
        for (int i=0; i<M; i++) {
            nums[i] =  Integer.parseInt(sto2.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(sangGeuns);
        for (int q : nums) {
            int s = 0;
            int e = N-1;
            int answer = 0;
            
            while (s<=e) {
                int mid = (s+e)/2;
                if (sangGeuns[mid]==q) {
                    answer = cnt[q+10000000];
                    break;
                } else if (sangGeuns[mid]>q) {
                    e = mid-1;
                } else {
                    s = mid+1;
                }
            }
            sb.append(answer).append(" ");
        }
    }
}


