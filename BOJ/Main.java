package BOJ;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, origin;
    static int[] dp, brr, arr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());   // 5
        c = Integer.parseInt(st.nextToken());   // 3
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        board = new int[n + 1][n + 1];
        Arrays.sort(arr, 1, n + 1);

        ans = 11;
        for (int i = arr[n] + 1; i >= 1; i--) {
            ans = Math.min(upperBound(i), ans);
        }
        //ans = upperBound(c);
        System.out.println(ans);
    }
    private static int upperBound(int dis) { // 1
        int lo = 1;
        int hi = n;
        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (dis < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }


    private static void print() {
        for (int i = 1; i < brr.length; i++) {
            System.out.print(brr[i] + " ");
        }
        System.out.println();
    }
    private static void print2() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}