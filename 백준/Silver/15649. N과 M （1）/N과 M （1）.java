import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // N 진수
        m = sc.nextInt(); // M 자릿수

        arr = new int[m];               // m크기의 배열 선언 
        visited = new boolean[n + 1];   // 쓰인 수인지 확인하는 부린 배열

        recur(0);
    }

    static void recur(int depth) {
        if (depth == m) {                // m자리수만큼 채워졌으면 프린트
            printArr();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {          // 쓰인 수가 아니면 
                visited[i] = true;      // 쓰임으로 플래그 변경
                arr[depth] = i;         // depth 자리의 값을 i로 변경 
                recur(depth + 1);       // 재귀 호출
                visited[i] = false;     // 사용상태 초기화 시켜줌
            }
        }
    }

    static void printArr() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
