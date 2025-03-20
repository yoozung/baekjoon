import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer sto = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(sto.nextToken());
            int B = Integer.parseInt(sto.nextToken());
            int answer = 0;
            
            if (A==0&B==0) break;
            
            int[] arrA = new int[A];
            int[] arrB = new int[B];
            
            for ( int i = 0 ; i<A; i++) arrA[i] = Integer.parseInt(br.readLine());
            for ( int i = 0 ; i<B; i++) arrB[i] = Integer.parseInt(br.readLine());
            
            for (int cd : arrA) {
                if (binarySearch(arrB, cd, B)) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
    
    static boolean binarySearch(int[] arr, int target, int B) {
        int s = 0;
        int e = B;
        while (s<=e) {
            int mid = (s+e) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid]>target) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return false;
    }
}
