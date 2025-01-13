package BOJ.DynamicProgramming;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1912 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[] dp, arr;
    static boolean[] visited;
    static int n, a, b, c, ans;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        dp = new int[n + 1];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            ans = Math.max(ans, dp[i]);
            System.out.println("dp["+i+"] = "+dp[i]);
        }

        /*ans = dp[1];
        for (int i = 2; i <= n; i++) {
            ans = Math.max(ans, dp[n]);
        }*/

        System.out.println(ans);
    }
}