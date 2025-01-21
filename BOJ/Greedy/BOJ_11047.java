package BOJ.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_11047 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list, list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, arr2, brr2;
    static int[] dp, arr, brr;
    static int n, m, k, a, b, c, ans = -1, cnt = 0, max = Integer.MIN_VALUE;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i > 0; i--) {
            if(k >= arr[i]) {
                cnt += k / arr[i];
                k %= arr[i];
            }
//            while(k >= arr[i]) {
//                k = k - arr[i];
//                cnt++;
//            }
        }
        System.out.println(cnt);
    }

    public static void print() {
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
            }
            System.out.println();
        }
        System.out.println();
    }
}

