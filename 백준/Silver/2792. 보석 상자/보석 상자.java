import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int child = sc.nextInt(); // 아이 수
        int color = sc.nextInt(); // 색상 수
        int[] arr = new int[color];
        int max = 0;
        for (int i = 0; i < color; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long s = 1, e = max;
        long answer = max;
        while (s <= e) {
            long mid = (s+e)/2;
            long count = check(arr, mid);

            if (count <= child) {
                answer = mid;
                e = mid - 1;
            } else {  
                s = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static long check(int[] arr, long mid) {
        long people = 0;
        for (int i : arr) {
            people += i / mid;
            if (i%mid > 0) people++; // 나머지 있으면 한 명 더 추가
        }
        return people;
    }
}
