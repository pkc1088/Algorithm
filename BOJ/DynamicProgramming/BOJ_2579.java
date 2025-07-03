package BOJ.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2579 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[] dp;
    static int[] arr;
    static boolean[][] visited;
    static boolean[] isThree;
    static int n, a, b, c, ans, threeCnt = 1;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        arr = new int[n + 1]; // R0, G1, B2
        isThree = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        /*
        dp[1] = 10
        dp[2] = 0+20 / 10+20 = 30 -> 즉 i번째 까지 오는데 이전에 1칸 밟고 왔는지 2칸으로 한번에 왔는지 판단
        dp[3] = 10+15 / 20+15 = 35 -> i-1은 반드시 밟았을테니 dp[i-1]+arr[i].dp[i-2]+arr[i] 가 두 칸 한번에고
        dp[4] = 10+20+25 / 10+15+25  =  55
        dp[5] = 10+20+25+10 / 10+15+25+10 / 20+15+10 / 20+25+10 = 65
        */

        dp[1] = arr[1];
        if(n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }
        System.out.println(dp[n]);
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }
    }
}
//System.out.println("dp["+i+"] = "+dp[i]);












