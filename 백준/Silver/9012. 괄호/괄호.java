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
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sto.nextToken());

        for (int i = 0 ; i < n ; i++) {
            boolean is = false;
            int open = 0;
            int close = 0;
            String inp = br.readLine();
            
            for (int y = 0; y < inp.length(); y++) {
                
                if ("(".equals(String.valueOf(inp.charAt(y)))) {
                    open++;
                } else {
                    close++;
                }
                
                if (close>open) {
                    break;
                }
               
                if (y+1 == inp.length()) {
                    if (close==open) {
                        is = true;
                    }
                }
            }
            
            if (is) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
            
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}