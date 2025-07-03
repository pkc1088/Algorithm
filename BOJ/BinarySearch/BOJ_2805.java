package BOJ.BinarySearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2805 {
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int mid;
        long len = 0;
        min = 0;
        // len : 1~20 Сп choice
        while (min < max) { // min = 1, max = 20
            len = 0;
            mid = (max + min) / 2;
            for (int i = 1; i < n + 1; i++) {
                int cut = arr[i] - mid;
                if(cut > 0) len += cut;
            }
            System.out.println("when mid : " + mid + ", len : " + len);
            if (len >= m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}