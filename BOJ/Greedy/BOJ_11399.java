package BOJ.Greedy;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_11399 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list, list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2;
    static int[] dp, brr, arr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, max = Integer.MIN_VALUE;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + arr[i];
            ans += dp[i];
        }
        //print();
        System.out.println(ans);
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            System.out.println(dp[i] + " ");
        }
        System.out.println();
    }
}
