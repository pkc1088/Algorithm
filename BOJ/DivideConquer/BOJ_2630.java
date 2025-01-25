package BOJ.DivideConquer;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static String str, str1, str2;
    static Long[] city, road;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board;
    static int[] dp, brr, arr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, one = 0, zero = 0;
    static int[] ansarr = new int[2];
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = Arrays.stream(board).flatMapToInt(Arrays::stream).sum();
        // 보드 전체가 1이거나 0인 경우
        if(sum == 0) {
            System.out.println(1);
            System.out.println(0);
            System.exit(0);
        } else if (sum == n * n) {
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }

        split_conquer(1, 1, n);
        System.out.println(ansarr[0]);
        System.out.println(ansarr[1]);
    }
    public static void split_conquer(int st_row, int st_col, int scan_size) { // 1 1 8 -> 5 1 4 -> 5 1 2
        if(scan_size == 1) {
            ansarr[board[st_row][st_col]]++;
            ansarr[board[st_row][st_col + 1]]++;
            ansarr[board[st_row + 1][st_col]]++;
            ansarr[board[st_row + 1][st_col + 1]]++;
            return;
        }
        scan(st_row, st_col, scan_size / 2);                                // 1 1 4 -> 5 1 2 -> 5 1 1
        scan(st_row, st_col + scan_size / 2, scan_size / 2);                   // 1 5 4 -> 5 3 2 -> 5 2 1
        scan(st_row + scan_size / 2, st_col, scan_size / 2);                  // 5 1 4 -> 7 1 2 -> 6 1 1
        scan(st_row + scan_size / 2, st_col + scan_size / 2, scan_size / 2);     // 5 5 4 -> 7 3 2 -> 6 2 1

    }
    public static void scan(int st_row, int st_col, int scan_size) { // 5 1 4
        int cur_color = board[st_row][st_col]; // 첫 번째 원소를 기준으로 검사
        for (int i = st_row; i < st_row + scan_size; i++) {
            for (int j = st_col; j < st_col + scan_size; j++) {
                if(board[i][j] != cur_color) { // 더러운 색깔 발견
                    split_conquer(st_row, st_col, scan_size); // 5 1 4
                    return;
                }
            }
        }
        // 만약 풀스캔 떄렸을떄 다 같은 색이라면
        ansarr[cur_color]++;
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.println(board[i][j] + " ");
            }
        }
        System.out.println();
    }
}
