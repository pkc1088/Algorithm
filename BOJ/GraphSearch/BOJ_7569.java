package BOJ.GraphSearch;

import java.util.*;
import java.io.*;

public class BOJ_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<int[]> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, h, r, v, t, k, l, cnt, ans;
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0 ,0, 0, 0, -1, 1};
    static StringTokenizer st;
    static boolean[][] visit;
    static int[][][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        int blank = 0;
        for (int l = 0; l < h; l++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    arr[l][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[l][i][j] == 1) {
                        list.add(new int[]{l, i, j});
                    } else if(arr[l][i][j] == -1) {
                        blank++;
                    }
                }
            }
        }

        if(list.size() == 0) {
            System.out.println(-1);
            return;
        } else if(list.size() + blank == n * m * h) {
            System.out.println(0);
            return;
        }
        ans = -100;
        bfs();
        for (int l = 0; l < h; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[l][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(ans - 1);
    }

    public static void bfs() { // 5
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
//            System.out.println("init : " + list.get(i)[0] + ", " + list.get(i)[1]+", "+ list.get(i)[2]);
            q.offer(new int[]{list.get(i)[0], list.get(i)[1], list.get(i)[2], 1});
        }

        while(!q.isEmpty()) {

            int[] dto = q.poll();
            int temp_height = dto[0];
            int temp_row = dto[1];
            int temp_col = dto[2];
            int nxt_time = dto[3] + 1;
            if(ans < dto[3]) ans = dto[3];
            // 6방향이 아닌 8방향이라 에러
            for (int i = 0; i < 6; i++) {
                int nxt_height = temp_height + dh[i];
                int nxt_row = temp_row + dr[i];
                int nxt_col = temp_col + dc[i];
//                System.out.println("nxt h/r/c : " + nxt_height + ", " + nxt_row + ", " + nxt_col);
                if(0 <= nxt_row && nxt_row < n && 0 <= nxt_col && nxt_col < m
                        && 0<= nxt_height && nxt_height < h && arr[nxt_height][nxt_row][nxt_col] == 0) {
                    arr[nxt_height][nxt_row][nxt_col] = nxt_time;
                    q.offer(new int[] {nxt_height, nxt_row, nxt_col, nxt_time});
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
//import static java.lang.System.exit;
//
//public class BOJ_7569 {
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
//    static boolean[][][] visited;
//    static int[][][] dp2, brr2, arr2, board, play;
//    static int[] dp, brr, arr, crr, check, result;
//    static int tc, n, m, h, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//    static int[] rX = {-1, 1, 0, 0};
//    static int[] rY = {0, 0, 1, -1};
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        m = Integer.parseInt(st.nextToken()); // 4
//        n = Integer.parseInt(st.nextToken()); // 3
//        h = Integer.parseInt(st.nextToken()); // 2
//        board = new int[n + 1][m + 1][h + 1];
//        visited = new boolean[n + 1][m + 1][h + 1];
//        queue = new LinkedList<>();
//        boolean there_no_mature = true;
//
//        for (int l = 1; l < h + 1; l++) {
//            for (int i = 1; i < n + 1; i++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                for (int j = 1; j < m + 1; j++) {
//                    int cond = Integer.parseInt(st.nextToken());
//                    if (cond == 1) {
//                        queue.add(new int[]{i, j, l});
//                        there_no_mature = false;
//                    }
//                    board[i][j][l] = cond;
//                }
//            }
//        }
//
//        if(there_no_mature) {
//            System.out.println(-1);
//            exit(0);
//        }
//
//        bfs();
//        ans = -100;
//        for (int l = 1; l < h + 1; l++) {
//            for (int i = 1; i < n + 1; i++) {
//                for (int j = 1; j < m + 1; j++) {
//                    if (board[i][j][l] == 0) {
//                        System.out.println(-1);
//                        exit(0);
//                    }
//                    if (board[i][j][l] > ans) {
//                        ans = board[i][j][l];
//                    }
//                }
//            }
//        }
//
//        System.out.println(ans - 1);
//    }
//
//    private static int bfs() {
//        int[] rXX = {-1, 1, 0, 0, 0, 0};
//        int[] rYY = {0, 0, 1, -1, 0, 0};
//        int[] rHH = {0, 0, 0, 0, 1, -1};
//
//        while(!queue.isEmpty()) {
//            int[] tot = queue.poll();
//            int curx = tot[0], cury = tot[1], curh = tot[2];
//            for (int pos = 0; pos < 6; pos++) {
//                int nr = curx + rYY[pos], nc = cury + rXX[pos], nh = curh + rHH[pos];
//                // +- n 조사는 맞는데 예제3에서 (3,3)이 (4,3)을 조사할 순 없음
//                // 즉 nr을 pos 0과 1에 대해 검증해야함
//                if(nr < 1 || nc < 1 || nh < 1 || nr > n || nc > m || nh > h) continue;
//                // 파티션 필터링이 필요 즉 층을 구분해줘야한다
//                // 2층에 있는 놈이 4방향 조사하다가 층을 침범해버리는 불상사
//                // nc는 노상관이고 nr만 신경써라
//                if (board[nr][nc][nh] == 0) {
//                    board[nr][nc][nh] = board[curx][cury][curh] + 1;
//                    queue.add(new int[]{nr, nc, nh});
//                }
//            }
//        }
//        return -1;
//    }
//
//    public static void print() {
//        for (int l = 1; l < h + 1; l++) {
//            for (int i = 1; i < n + 1; i++) {
//                for (int j = 1; j < m + 1; j++) {
//                    System.out.print(board[i][j][l] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//    }
//}
