package BOJ.PrefixSum;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11659 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] arr2, brr2, dp2;
    static int[] arr, brr, dp;
    static int n, m, a, b, c, ans = -1, cnt = 0;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + arr[i];
        }
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            System.out.println(cul_sum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        //print();
    }

    public static int cul_sum(int a, int b) {
        return dp[b] - dp[a - 1];
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print(dp2[i][j] + " ");
            }
            //System.out.println("dp[" + i + "] : " + dp[i]);
            System.out.println();
        }
        System.out.println();
    }
}







