package BOJ.PrefixSum;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2559 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] arr2, brr2, dp2;
    static int[] arr, brr, dp;
    static int n, m, k, a, b, c, ans = -1, cnt = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - k + 1; i++) {
            if (max < arr[i + k] - arr[i]) {
                max = arr[i + k] - arr[i];
            }
        } // 19 - (-12) = 31
        System.out.println(max);
        print();
    }

    public static int prefix_sum(int a, int b) {
        return dp[b] - dp[a - 1];
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}







