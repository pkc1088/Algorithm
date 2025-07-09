package BOJ.GraphSearch;

import java.util.*;
import java.io.*;

public class BOJ_7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, r, v, t, k, l, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] night_row = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] night_col = {1, -1, 1, -1, 2, 2, -2, -2};

    static StringTokenizer st;
    static boolean[][] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while(t-->0) testCase();
    }
    public static void testCase() throws IOException {
        l = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int fr = Integer.parseInt(st.nextToken());
        int fc = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int tr = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        arr = new int[l + 1][l + 1];

        if(fr == tr && fc == tc) System.out.println(0);
        else bfs(fr, fc, tr, tc);
    }
    public static void bfs(int fr, int fc, int tr, int tc) { // 5
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{fr, fc, 0});
//        for (int i = 0; i < 8; i++) {
//            q.offer(new int[]{fr + night_row[i], fc + night_col[i], 1});
//        } ÀÌ·¯¸é ¾ÈµÊ

        while(!q.isEmpty()) {

            int[] dto = q.poll();
            if(dto[0] == tr && dto[1] == tc) {
                System.out.println(dto[2]);
                return;
            }
            int temp_row = dto[0];
            int temp_col = dto[1];
            int nxt_time = dto[2] + 1;
            for (int i = 0; i < 8; i++) {
                int nxt_row = temp_row + night_row[i];
                int nxt_col = temp_col + night_col[i];
                if(0 <= nxt_row && nxt_row < l
                        && 0 <= nxt_col && nxt_col < l && arr[nxt_row][nxt_col] == 0) {
                    arr[nxt_row][nxt_col] = nxt_time;
                    q.offer(new int[] {nxt_row, nxt_col, nxt_time});
                }
            }

        }
    }
}



//
//import java.io.*;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//public class BOJ_7562 {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st, tk;
//    static ArrayList<ArrayList<Integer>> graph;
//    static ArrayList<Integer> list, list1, list2;
//    static PriorityQueue<Long> pq;
//    static Queue<int[]> queue;
//    static String str, str1, str2;
//    static boolean[] visit, visit2;
//    static boolean[][] visited;
//    static int[][] dp2, brr2, arr2, board, play;
//    static int[] dp, brr, arr, crr, check, result;
//    static int tc, n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//    static int[] rX = {-1, 1, 0, 0};
//    static int[] rY = {0, 0, 1, -1};
//    static int[] rXX = {-2, -1, 1, 2, -2, -1, 1, 2};
//    static int[] rYY = {1, 2, 2, 1, -1, -2, -2, -1};
//    static int curx, cury, desx, desy;
//
//    public static void main(String[] args) throws IOException {
//        tc = Integer.parseInt(br.readLine());
//        for (int i = 1; i < tc + 1; i++) {
//            solution();
//        }
//    }
//    private static void solution() throws IOException {
//        n = Integer.parseInt(br.readLine());
//        board = new int[n][n];
//        visited = new boolean[n][n];
//        st = new StringTokenizer(br.readLine(), " ");
//        curx = Integer.parseInt(st.nextToken());
//        cury = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine(), " ");
//        desx = Integer.parseInt(st.nextToken());
//        desy = Integer.parseInt(st.nextToken());
//        if(curx == desx && cury == desy) {
//            System.out.println(0);
//            return;
//        }
//        System.out.println(bfs(curx, cury, desx, desy));
//    }
//
//    private static int bfs(int cx, int cy, int dx, int dy) {
//        queue = new LinkedList<>();
//        queue.add(new int[]{cx, cy});
//
//        while(!queue.isEmpty()) {
//            int[] curxy = queue.poll();
//            int curx = curxy[0], cury = curxy[1];//, curcnt = curxy[2];
//
//            for (int pos = 0; pos < 8; pos++) {
//                int nr = curx + rYY[pos], nc = cury + rXX[pos];
//                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
//
//                if (board[nr][nc] == 0) {
//                    board[nr][nc] = board[curx][cury] + 1;
//                    queue.add(new int[]{nr, nc});
//                }
//            }
//        }
//        return board[dx][dy];
//    }
//
//    public static void print() {
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
