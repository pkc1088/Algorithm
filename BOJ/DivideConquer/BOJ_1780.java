package BOJ.DivideConquer;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1780 {
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
    static int neg = 0, pos = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < n + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(1, 1, n);
        System.out.println(neg);
        System.out.println(zero);
        System.out.println(pos);
    }

    public static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if(board[row][col] == -1) {
                neg++;
            } else if(board[row][col] == 0) {
                zero++;
            } else if(board[row][col] == 1) {
                pos++;
            }
            return;
        }
        for (int i = 0; i < 2 + 1; i ++) {
            for (int j = 0; j < 2 + 1; j++) {
                partition(row + i * size / 3, col + j * size / 3, size / 3);
            }
        }

//        partition(row, col, newSize);
//        partition(row, col + newSize, newSize);
//        partition(row + newSize, col, newSize);
//        partition(row + newSize, col + newSize, newSize);
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];	// 첫 번째 원소를 기준으로 검사
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}