package BOJ.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2565 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[][] dpp;
    static int[][] wire, dbrr;
    static int[] dp;
    static int[] arr, brr;
    static boolean[][] visited;
    static int n, a, b, c, ans = -1, cnt = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        wire = new int[n + 1][2];
        //brr = new int[500 + 1];
        dp = new int[n + 1];
        brr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            wire[i][0] = r;
            wire[i][1] = c;
        }
        Arrays.sort(wire, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < n + 1; i++) {
            brr[i] = wire[i][1];
        }
        System.out.println(n - LIS());
        //print();
    }

    public static int LIS() {
        for(int i = 1; i < n + 1; i++) {
            dp[i] = 1;
            for(int j = 1; j < i + 1; j++) {
                if(brr[j] < brr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 1; i < n + 1; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /*
        1 8     (제거)
        2 2
        3 9     (제거)
        4 1     (제거)
        6 4
        7 6
        9 7
        10 10
     */
    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            System.out.println("dp[" + i + "] : " + dp[i]);
        }
        System.out.println();
    }
}



