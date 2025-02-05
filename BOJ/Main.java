package BOJ;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

public class Main {
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
    static int n, m, k, a, b, c, ans = 0, cnt = 0, sum = 0, C = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        int chu = Integer.parseInt(br.readLine());
        arr = new int[chu + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < chu + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ball = Integer.parseInt(br.readLine());
        brr = new int[ball + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < ball + 1; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }


    }

    public static int dfs(int x, int y) {
        System.out.println("enter (x,y) : " + x + ", " + y);
        if (x == m && y == n) {return 1;}
        if (dp2[x][y] != -1) {return dp2[x][y];}

        dp2[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + rangeX[i];
            int dy = y + rangeY[i];

            if (dx < 1 || dy < 1 || dx > m || dy > n) {continue;}

            if (arr2[x][y] > arr2[dx][dy]) {
                dp2[x][y] += dfs(dx, dy);
            }
        }
        return dp2[x][y];
    }

    public static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}