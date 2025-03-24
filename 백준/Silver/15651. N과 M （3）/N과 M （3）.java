import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 진수
        m = sc.nextInt(); // 자릿수

        arr = new int[m];

        recur(0);
        System.out.println(sb.toString());
        
    }

    static void recur(int cur) {
        if (cur == m) {
            printArr();
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            arr[cur] = i;
            recur(cur + 1);
        }
    }

    static void printArr() {
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}
