import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        for ( int i = 0 ; i<C; i++) {
            int amt = sc.nextInt();
            int[] points = new int[amt];
            for (int y=0; y< amt; y++){
                points[y] = sc.nextInt();
            }
            Arrays.sort(points);

            int answer = 0;
            // 이진탐색 시작
            for (int j=0; j < amt-1; j++) {
                for (int y=j+1; y<amt; y++) {
                    int firstPoint = points[j];
                    int secondPoint = points[y];
                    int target = (secondPoint-firstPoint) + secondPoint;

                    if (binarySearch(points, y, target, amt-1)) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }


    }

    // 이진탐색
    static boolean binarySearch(int[] arr, int secondPointIdx, int targetVal, int lastIdx ) {

        while (secondPointIdx<=lastIdx) {
            int mid = (secondPointIdx+lastIdx) / 2;
            if (arr[mid]==targetVal) {
                return true;
            }

            if (arr[mid]>targetVal) {
                lastIdx = mid-1;
            } else {
                secondPointIdx = mid+1;
            }
        }

        return false;
    }
}