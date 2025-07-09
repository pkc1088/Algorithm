package BOJ.GraphSearch;

import java.util.*;
import java.io.*;

public class BOJ_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<int[]> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, r, v, t, k, l, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean[][] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int blank = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                } else if(arr[i][j] == -1) {
                    blank++;
                }
            }
        }
        if(list.size() == 0) {
            System.out.println(-1);
            return;
        } else if(list.size() + blank == n * m) {
            System.out.println(0);
            return;
        }
        ans = -100;
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans - 1);
    }
    /*
    1 : 익은 o 토마토
    0 : 익지 x 토마토
    -1 : 빈 칸
     */
    public static void bfs() { // 5
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            q.offer(new int[]{list.get(i)[0], list.get(i)[1], 1});
        }

        while(!q.isEmpty()) {

            int[] dto = q.poll();
            int temp_row = dto[0];
            int temp_col = dto[1];
            int nxt_time = dto[2] + 1;
            if(ans < dto[2]) ans = dto[2];

            for (int i = 0; i < 4; i++) {
                int nxt_row = temp_row + dr[i];
                int nxt_col = temp_col + dc[i];
                if(0 <= nxt_row && nxt_row < n && 0 <= nxt_col && nxt_col < m
                        && arr[nxt_row][nxt_col] == 0) {
                    arr[nxt_row][nxt_col] = nxt_time;
                    q.offer(new int[] {nxt_row, nxt_col, nxt_time});
                }
            }

        }
    }
}











//import java.io.*;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//public class BOJ_7576 {
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
////    static int[] rXX = {-2, -1, 1, 2, -2, -1, 1, 2};
////    static int[] rYY = {1, 2, 2, 1, -1, -2, -2, -1};
////    static int curx, cury, desx, desy;
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        m = Integer.parseInt(st.nextToken()); // 6
//        n = Integer.parseInt(st.nextToken()); // 4
//        board = new int[n + 1][m + 1];
//        visited = new boolean[n + 1][m + 1];
//        queue = new LinkedList<>();
//        boolean there_no_mature = true;
//        for (int i = 1; i < n + 1; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 1; j < m + 1; j++) {
//                int cond = Integer.parseInt(st.nextToken());
//                if(cond == 1) {
//                    queue.add(new int[]{i, j});
//                    there_no_mature = false;
//                }
//                board[i][j] = cond;
//            }
//        }
//        if(there_no_mature) {
//            System.out.println(-1);
//            System.exit(0);
//            // 즉 1이 없다
//        }
//
///*
//저장될 때부터 모든 토마토가 익어있는 상태이면 0
//토마토가 모두 익지는 못하는 상황이면 -1
// */
//        bfs();
//        ans = -100;
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//                if(board[i][j] == 0) { // 토마토가 모두 익지는 못하는 상황이면 -1
//                    System.out.println(-1);
//                    System.exit(0);
//                }
//                if(board[i][j] > ans) {
//                    ans = board[i][j];
//                }
//            }
//        }
//
//        System.out.println(ans - 1);
//    }
//
//    private static int bfs() {
//        while(!queue.isEmpty()) {
//            int[] curxy = queue.poll();
//            int curx = curxy[0], cury = curxy[1];
//            for (int pos = 0; pos < 4; pos++) {
//                int nr = curx + rY[pos], nc = cury + rX[pos];
//                if(nr < 1 || nc < 1 || nr > n || nc > m) continue;
//                if (board[nr][nc] == 0) {
//                    board[nr][nc] = board[curx][cury] + 1;
//                    queue.add(new int[]{nr, nc});
//                }
//            }
//        }
//        return -1;
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
