import java.util.Scanner;

public class Main {
    static long answer = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long busAmount = sc.nextInt();
        long arrivedTime = sc.nextInt();

        for ( int i = 0 ; i<busAmount; i++) {
            long firstTime = sc.nextInt(); // 첫차시간
            long term = sc.nextInt(); // 배차간격
            long amt = sc.nextInt(); // 버스 대수

            // 영식이 고속터미널 도착시간 == 첫차시간
            if (firstTime==arrivedTime) {
                System.out.println(0);
                return;
            }

            // 이진탐색
            binarySearch(amt-1, arrivedTime, firstTime, term);
        }

        if (answer==Long.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);

    }

    // 이진탐색
    static void binarySearch(long maxIdx, long arrivedTime, long firstTime, long term) {
        long s=0;
        long e=maxIdx;

        while (s<=e) {
            long mid = (s+e) / 2;
            long midVal = firstTime + (mid * term);

            if (midVal < arrivedTime) {
                s = mid+1;
            } else {
                e = mid-1;
            }

            long watingTime = midVal- arrivedTime;
            if (watingTime >= 0) {
                answer = Math.min(watingTime,answer);
            }
        }

    }
}