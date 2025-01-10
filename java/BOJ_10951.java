import java.io.EOFException;
import java.util.*;

import static java.lang.System.exit;

public class BOJ_10951 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            try {
                int H = sc.nextInt();
                int M = sc.nextInt();
                System.out.println(H + M);
            } catch(Exception e){
                exit(0);
            };    
        }
        
    }
}
