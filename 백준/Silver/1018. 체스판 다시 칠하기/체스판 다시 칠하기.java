import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        
        int result = Integer.MAX_VALUE;
        int row = Integer.parseInt(sto.nextToken());
        int col = Integer.parseInt(sto.nextToken());
        String[] arr = new String[row];
        
        for (int i=0; i < row ;i++) {
            arr[i] = br.readLine();
        }
        
        // 1. 체스판 자르기
        for (int i = 0; i <= row-8; i++) { // 2
            for (int y=0; y <= col-8; y++ ) { // 5
                result = Math.min(getCount(arr, i, y), result);
            }
        }
       
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        
    }
    
    private static int getCount(String[] board, int row, int col) {
        int blackFirst = 0;
        
        String www = "WBWBWBWB";
        String bbb = "BWBWBWBW";
        
        boolean isBlackTurn = false;
        
        for (int i = row ; i < row+8; i++) {
            String onerow = board[i];
            
            for (int y = col; y <col+8; y++) {
                if (isBlackTurn) {
                    if (onerow.charAt(y)!=bbb.charAt(y-col)) {
                        blackFirst++;
                    }
                } else {
                    if (onerow.charAt(y)!=www.charAt(y-col)) {
                        blackFirst++;
                    }
                }
            }
            isBlackTurn = !isBlackTurn;
            
        }
        
        int whiteFirst = 64-blackFirst;
        
        return Math.min(blackFirst, whiteFirst);
    }
    
}