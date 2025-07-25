package BOJ.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, r, v, t, k, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean[][] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 2][m + 2];
        visit = new boolean[n + 2][m + 2];

        for (int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(arr[n][m]);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] dto = q.poll();
            int tr = dto[0];
            int tc = dto[1];

            for (int i = 0; i < 4; i++) {
                int nr = tr + dr[i];
                int nc = tc + dc[i];
                if(arr[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    arr[nr][nc] = arr[tr][tc] + 1;
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
//public class BOJ_2178 {
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
//    static int[][] dp2, brr2, arr2, board;
//    static int[] dp, brr, arr, crr, check, result;
//    static int tc, n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//    static int[] rX = {-1, 1, 0, 0};
//    static int[] rY = {0, 0, 1, -1};
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        board = new int[n + 1][m + 1];
//        visited = new boolean[n + 1][m + 1];
//        for (int i = 1; i < n + 1; i++) {
//            str = br.readLine();
//            for (int j = 1; j < m + 1; j++) {
//                board[i][j] = str.charAt(j - 1) - '0';
//            }
//        }
//        ans = Integer.MAX_VALUE;
//
//        //int[] k = queue.poll();
//        System.out.println(bfs(1, 1, 1));
//        //System.out.println(ans);
//    }
//    private static int bfs(int r, int c, int k) { // 1, 1
//        visited[r][c] = true;
//        queue = new LinkedList<>();
//        queue.add(new int[]{r, c, k});
//
//        while(!queue.isEmpty()) {
//            int[] curxy = queue.poll();
//            int curx = curxy[0], cury = curxy[1], curcnt = curxy[2];
//
//            if (curx == n && cury == m) {
//                return curcnt;
//            }
//
//            for (int pos = 0; pos < 4; pos++) {
//                int nr = curx + rY[pos], nc = cury + rX[pos];
//                if(nr < 1 || nc < 1 || nr > n || nc > m) continue;
//
//                if (board[nr][nc] == 1 && !visited[nr][nc]) {
//                    visited[nr][nc] = true;
//                    queue.add(new int[]{nr, nc, curcnt + 1});
//                }
//            }
//        }
//        return -1;
//    }
//
//    //    private static void dfs(int curr, int curc, int curcnt) {
////        if (curr == n && curc == m) {
////            if(ans > curcnt) ans = curcnt;
////            return;
////        }
////        if (curcnt > ans) {
////            return;
////        }
////        visited[curr][curc] = true;
////        for (int pos = 0; pos < 4; pos++) {
////            int nr = curr + rY[pos];
////            int nc = curc + rX[pos];
////            if(nr < 1 || nc < 1 || nr > n || nc > m) continue;
////            if (board[nr][nc] == 1 && !visited[nr][nc]) {
////                dfs(nr, nc, curcnt+1);
////            }
////        }
////        visited[curr][curc] = false;
////    }
//    public static void print() {
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
