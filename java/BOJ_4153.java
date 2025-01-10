import java.io.*;
import java.util.*;

public class BOJ_4153 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==0&&b==0&&c==0)
                break;

            a = (int)Math.pow(a, 2);
            b = (int)Math.pow(b, 2);
            c = (int)Math.pow(c, 2);
            if(a>b && a>c) {
               if(a == b+c)
                   System.out.println("right");
               else
                   System.out.println("wrong");
               continue;
            } else if(b>a && b>c) {
                if(b == a+c)
                    System.out.println("right");
                else
                    System.out.println("wrong");
                continue;
            } else {
                if(c == b+a)
                    System.out.println("right");
                else
                    System.out.println("wrong");
                continue;
            }
        }
    }
}
