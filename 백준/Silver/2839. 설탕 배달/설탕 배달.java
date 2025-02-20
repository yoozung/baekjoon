import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dv5 = n/5;
        int left = n%5;
         
        if (dv5==0 && n/3==0) {
            System.out.println(-1);
            return;
        }
         
        if (left==0) {
            System.out.println(dv5);
            return;
        }
        
        int min = 0; 
        for (int i = 1; i <= dv5; i++) {
            int num = n-(i*5);
            if (num%3==0) {
                min = (num/3) + i;
            } 
        }
        
        if (min!=0) {
            System.out.println(min);
            return;
        } else {
            System.out.println(n%3==0 ? n/3 : -1); 
        } 
    }

}


