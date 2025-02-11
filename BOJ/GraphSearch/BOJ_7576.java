package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_7576 {
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
//    static int[] rXX = {-2, -1, 1, 2, -2, -1, 1, 2};
//    static int[] rYY = {1, 2, 2, 1, -1, -2, -2, -1};
//    static int curx, cury, desx, desy;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); // 6
        n = Integer.parseInt(st.nextToken()); // 4
        board = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        queue = new LinkedList<>();
        boolean there_no_mature = true;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < m + 1; j++) {
                int cond = Integer.parseInt(st.nextToken());
                if(cond == 1) {
                    queue.add(new int[]{i, j});
                    there_no_mature = false;
                }
                board[i][j] = cond;
            }
        }
        if(there_no_mature) {
            System.out.println(-1);
            System.exit(0);
            // 즉 1이 없다
        }

/*
저장될 때부터 모든 토마토가 익어있는 상태이면 0
토마토가 모두 익지는 못하는 상황이면 -1
 */
        bfs();
        ans = -100;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(board[i][j] == 0) { // 토마토가 모두 익지는 못하는 상황이면 -1
                    System.out.println(-1);
                    System.exit(0);
                }
                if(board[i][j] > ans) {
                    ans = board[i][j];
                }
            }
        }

        System.out.println(ans - 1);
    }

    private static int bfs() {
        while(!queue.isEmpty()) {
            int[] curxy = queue.poll();
            int curx = curxy[0], cury = curxy[1];
            for (int pos = 0; pos < 4; pos++) {
                int nr = curx + rY[pos], nc = cury + rX[pos];
                if(nr < 1 || nc < 1 || nr > n || nc > m) continue;
                if (board[nr][nc] == 0) {
                    board[nr][nc] = board[curx][cury] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return -1;
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
