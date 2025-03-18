import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] aArr = new int[A];
        int[] bArr = new int[B];
        int[] cArr = new int[C];

        for (int i = 0; i < A; i++) aArr[i] = sc.nextInt();
        for (int i = 0; i < B; i++) bArr[i] = sc.nextInt();
        for (int i = 0; i < C; i++) cArr[i] = sc.nextInt();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        Arrays.sort(cArr);

        int answer = Integer.MAX_VALUE;
        for (int a : aArr) {
            int b = findTheClosest(bArr, a);
            int c = findTheClosest(cArr, a);

            int max = Math.max(a, (Math.max(b,c)));
            int min = Math.min(a, (Math.min(b,c)));

            answer = Math.min(answer, (max-min));
        }

        for (int b : bArr) {
            int a = findTheClosest(aArr, b);
            int c = findTheClosest(cArr, b);

            int max = Math.max(a, (Math.max(b,c)));
            int min = Math.min(a, (Math.min(b,c)));

            answer = Math.min(answer, (max-min));
        }
        System.out.println(answer);
    }

    private static int findTheClosest(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int best = arr[0];
        while (s <= e) {
            int mid = (s+e) / 2;
            if (Math.abs(arr[mid] - target) < Math.abs(best - target)) {
                best = arr[mid];
            }
            if (arr[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return best;
    }


}
