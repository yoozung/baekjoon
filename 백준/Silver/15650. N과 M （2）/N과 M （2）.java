import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 진수
        m = sc.nextInt(); // 자릿수

        arr = new int[m];

        recur(0, 1);
    }

    static void recur(int cur, int start) {
        if (cur == m) {
            printArr();
            return;
        }
        
        for (int i = start; i <= n; i++) {
            arr[cur] = i;
            recur(cur + 1, i + 1);
        }
    }

    static void printArr() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
