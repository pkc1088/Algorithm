import java.io.*;
import java.util.*;

public class BOJ_11659 {
    public static int[] dp = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(st.nextToken()) + dp[i-1];
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(dp[j] - dp[i-1]);
        }

    }
}
