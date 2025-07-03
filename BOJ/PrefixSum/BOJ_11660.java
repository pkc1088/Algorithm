package BOJ.PrefixSum;

import java.io.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, arr2;
    static int[] dp, arr;
    static int n, m, k, a, b, c, ans = -1, cnt = 0, max = Integer.MIN_VALUE;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp2 = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                dp2[i][j] = dp2[i][j - 1] + dp2[i - 1][j] - dp2[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
//        print();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = dp2[x2][y2] - dp2[x2][y1 - 1] - dp2[x1 - 1][y2] + dp2[x1 - 1][y1 - 1];
            System.out.println(ans);
        }
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(dp2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}