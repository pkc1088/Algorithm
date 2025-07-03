import java.io.*;
import java.util.*;

public class NDB_4_1 {
    static int x = 1, y = 1, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            switch(s) {
                case "L" :
                    if(collision_check(y-1))
                        y-=1;
                    break;
                case "R" :
                    if(collision_check(y+1))
                        y+=1;
                    break;
                case "U" :
                    if(collision_check(x-1))
                        x-=1;
                    break;
                case "D" :
                    if(collision_check(x+1))
                        x+=1;
                    break;
            }
        }
        System.out.println(x+" "+y);
    }
    public static boolean collision_check(int c) {
        if(c>=1 && c<=N)
            return true;
        else
            return false;
    }
}
