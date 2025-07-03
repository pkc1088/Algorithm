package BOJ.DynamicProgramming2;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_11049 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, origin;
    static int[] dp, brr, arr, crr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, sum = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];
        int[][] process = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            process[i][0] = Integer.parseInt(st.nextToken());
            process[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i + k < N + 1; i++) {
                dp[i][i + k] = Integer.MAX_VALUE;
                for (int j = i; j < i + k; j++) {
                    dp[i][i + k] = Math.min(dp[i][i + k],
                            dp[i][j] + dp[j + 1][i + k]
                                    + process[i][0] * process[j][1] * process[i + k][1]);
                }
            }
        }
        System.out.println(dp[1][N]);
    }

    public static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}