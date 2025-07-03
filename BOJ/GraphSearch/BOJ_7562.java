package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_7562 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static Queue<int[]> queue;
    static String str, str1, str2;
    static boolean[] visit, visit2;
    static boolean[][] visited;
    static int[][] dp2, brr2, arr2, board, play;
    static int[] dp, brr, arr, crr, check, result;
    static int tc, n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rX = {-1, 1, 0, 0};
    static int[] rY = {0, 0, 1, -1};
    static int[] rXX = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] rYY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int curx, cury, desx, desy;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i < tc + 1; i++) {
            solution();
        }
    }
    private static void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        st = new StringTokenizer(br.readLine(), " ");
        curx = Integer.parseInt(st.nextToken());
        cury = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        desx = Integer.parseInt(st.nextToken());
        desy = Integer.parseInt(st.nextToken());
        if(curx == desx && cury == desy) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs(curx, cury, desx, desy));
    }

    private static int bfs(int cx, int cy, int dx, int dy) {
        queue = new LinkedList<>();
        queue.add(new int[]{cx, cy});

        while(!queue.isEmpty()) {
            int[] curxy = queue.poll();
            int curx = curxy[0], cury = curxy[1];//, curcnt = curxy[2];

            for (int pos = 0; pos < 8; pos++) {
                int nr = curx + rYY[pos], nc = cury + rXX[pos];
                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                if (board[nr][nc] == 0) {
                    board[nr][nc] = board[curx][cury] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return board[dx][dy];
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
