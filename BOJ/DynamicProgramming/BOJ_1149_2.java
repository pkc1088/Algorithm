package BOJ.DynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ_1149_2 {

    static int n;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n + 1][4];
        dp = new int[n + 1][4];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i][1] = Integer.parseInt(st.nextToken()); // R
            cost[i][2] = Integer.parseInt(st.nextToken()); // G
            cost[i][3] = Integer.parseInt(st.nextToken()); // B
        }

        // dp[x]=y ...... x번째 집까지 칠했을때 최소값 y.
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        dp[1][3] = cost[1][3];

        for (int i = 2; i < n + 1; i++) {
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + cost[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][3];
        }

        System.out.println(Math.min(Math.min(dp[n][1], dp[n][2]), dp[n][3]));
    }
}
