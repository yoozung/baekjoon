import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        
        int d = Integer.parseInt(sto.nextToken()); 
        int m = Integer.parseInt(sto.nextToken());  
        LocalDate date = LocalDate.of(2009, m, d);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Monday");
        map.put(2, "Tuesday");
        map.put(3, "Wednesday");
        map.put(4, "Thursday");
        map.put(5, "Friday" );
        map.put(6, "Saturday");
        map.put(7, "Sunday" );
        
        bw.write(map.get(dayOfWeekNumber));
        bw.flush();
        bw.close();
        
    }
}