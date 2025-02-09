package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2667 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static Queue<Integer> queue;
    static String str, str1, str2;
    static boolean[][] visit, visit2;
    static boolean[][] visited;
    static int[][] dp2, brr2, arr2, board;
    static int[] dp, brr, arr, crr, check, result;
    static int n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rX = {-1, 1, 0, 0};
    static int[] rY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            str = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                board[i][j] = str.charAt(j - 1) - '0';
            }
        }
        list = new ArrayList<>();
        cnt = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(board[i][j] == 1 && !visited[i][j]){
                    //visited[i][j] = true;
                    dfs(i, j);
                    list.add(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int n : list) {
            System.out.println(n);
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            if(r + rY[i] < 1 || c + rX[i] < 1 || r + rY[i] > n || c + rX[i] > n) continue;
            if (board[r + rY[i]][c + rX[i]] == 1 && !visited[r + rY[i]][c + rX[i]]) {
                cnt++;
                dfs(r + rY[i], c + rX[i]);
            }
        }
    }
}
