package BOJ.DynamicProgramming;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2156 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[][] dpp;
    static int[] dp;
    static int[] arr;
    static boolean[][] visited;
    static int n, a, b, c, ans, cnt = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = -10000;
        dp[1] = arr[1];
        if(n == 1) {
            System.out.println(dp[1]);
            System.exit(0);
        }
        dp[2] = arr[1] + arr[2];
        if (n == 2) {
            System.out.println(dp[2]);
            System.exit(0);
        }
        dp[3] = Math.max(arr[1] + arr[2], Math.max(arr[2] + arr[3], arr[1] + arr[3]));
        if (n == 3) {
            System.out.println(dp[3]);
            System.exit(0);
        }

        ans = dp[3];
        /*
         9가 기준이라 칠때 9인 arr[4]를 포함시
         dp[1] + arr[3] + arr[4]
         //dp[1] + arr[2] + arr[4]
         dp[2] + arr[4]
         미포함시
         arr[i-1] + arr[i-2] + dp[i-4]
         dp[2] + arr[3]

        ~, 10, 9 = 25
        6, 13, 9 = 28
        //10, 13, x = 23
         */
        for (int i = 4; i < n + 1; i++) {
            dp[i] = Math.max(Math.max(
                            dp[i - 3] + arr[i - 1] + arr[i], // ok
                            dp[i - 1]), // ok
                    dp[i - 2] + arr[i]); // ok
            //if(ans < dp[i]) ans = dp[i];
        }
        // 그냥 각 dp에 i를 포함시키는 케이스로 만들고 맨 마지막에 dp 중 최대값 뽑아라
        print();
        System.out.println(dp[n]);
    }
    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            System.out.println("dp[" + i + "] : " + dp[i]);
        }
        System.out.println();
    }
}







