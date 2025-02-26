import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main { 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int amt = Integer.parseInt(br.readLine());
        
        for (int i=0; i<amt; i++) {
            String line = br.readLine();
            int answer = 0;
            int score = 0;
            for (int y=0; y < line.length(); y++) {
                if ('O'==line.charAt(y)) {
                    score++;
                    answer += score;
                } else {
                    score = 0;
                }
            } 
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
