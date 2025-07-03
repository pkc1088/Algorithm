import java.io.*;
import java.util.*;
public class BOJ_15552 {
    static void solve(int t) throws IOException {
        while(t>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a + b + "\n");
            t--;
        }
        bw.flush();
        bw.close();
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        new BOJ_15552().solve(t);
    }

}
