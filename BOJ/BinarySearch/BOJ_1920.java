package BOJ.BinarySearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1920 {
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
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 1, n + 1);
        // 1 2 3 4 5
        // 1 3 5 7 9

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < m + 1; i++) {
            if (check(Integer.parseInt(st.nextToken())) == 1)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static int check(int check) {
        int st = 1, end = n;
        while(st <= end) {
            int mid = (st + end) / 2;
            if (arr[mid] < check) {
                st = mid + 1;
            } else if (check < arr[mid]) {
                end = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}