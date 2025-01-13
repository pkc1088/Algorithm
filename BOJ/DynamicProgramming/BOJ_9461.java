package BOJ.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9461 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] dp, arr;
    static int N, max = -1, a, b, c, cnt = 0;

    public static void main(String[] args) throws IOException {
        dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= 100; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]);
            //System.out.println("dp["+i+"] = "+dp[i]);
        }
        //st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
        //System.out.println(dp[100]);

    }
}