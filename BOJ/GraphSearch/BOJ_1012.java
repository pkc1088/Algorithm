package BOJ.GraphSearch;


import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1012 {
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
    static int tc, n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rX = {-1, 1, 0, 0};
    static int[] rY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i < tc + 1; i++) {
            count = 0;
            solution();
        }
    }
    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        visited = new boolean[r][c];
        for (int i = 1; i < k + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ri = Integer.parseInt(st.nextToken());
            int ci = Integer.parseInt(st.nextToken());
            board[ri][ci] = 1;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int curr, int curc) {
        visited[curr][curc] = true;
        for (int pos = 0; pos < 4; pos++) {
            int nr = curr + rY[pos];
            int nc = curc + rX[pos];

            if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
            if (board[nr][nc] == 1 && !visited[nr][nc]) {
                cnt++;
                dfs(nr, nc);
            }
        }
    }
}

