package BOJ;

import java.io.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2;
    static int[] dp, brr;
    static int n, m, k, a, b, c, ans = -1, cnt = 0, max = Integer.MIN_VALUE;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        brr = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            brr[i] = dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
            if(dp[i] % m == 0) cnt++;
        }

        bw.write(""+cnt);
        bw.flush();
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
