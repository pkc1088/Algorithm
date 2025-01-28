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
    static Long[] city, road;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board;
    static int[] dp, brr, arr;
    static long[] pattern;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, one = 0, zero = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int p;
        pattern = new long[10];
    }

    public static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {

        }
        for (int i = 0; i < 2 + 1; i ++) {
            for (int j = 0; j < 2 + 1; j++) {
                partition(row + i * size / 3, col + j * size / 3, size / 3);
            }
        }


    }

    public static boolean colorCheck(int row, int col, int size) {
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {

            }
        }
        return true;
    }
}