package BOJ_Quiz.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10870 {
    public static void main(String[] args) throws IOException {
        int a = 0, b = 1, c = 0, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        if(n == 0) { System.out.println(0); return; }
        if(n == 1) { System.out.println(1); return;}
        while(n-- > 1) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
