package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import static java.lang.System.exit;

public class BOJ_7569 {
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
    static boolean[][][] visited;
    static int[][][] dp2, brr2, arr2, board, play;
    static int[] dp, brr, arr, crr, check, result;
    static int tc, n, m, h, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rX = {-1, 1, 0, 0};
    static int[] rY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); // 4
        n = Integer.parseInt(st.nextToken()); // 3
        h = Integer.parseInt(st.nextToken()); // 2
        board = new int[n + 1][m + 1][h + 1];
        visited = new boolean[n + 1][m + 1][h + 1];
        queue = new LinkedList<>();
        boolean there_no_mature = true;

        for (int l = 1; l < h + 1; l++) {
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j < m + 1; j++) {
                    int cond = Integer.parseInt(st.nextToken());
                    if (cond == 1) {
                        queue.add(new int[]{i, j, l});
                        there_no_mature = false;
                    }
                    board[i][j][l] = cond;
                }
            }
        }

        if(there_no_mature) {
            System.out.println(-1);
            exit(0);
        }

        bfs();
        ans = -100;
        for (int l = 1; l < h + 1; l++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    if (board[i][j][l] == 0) {
                        System.out.println(-1);
                        exit(0);
                    }
                    if (board[i][j][l] > ans) {
                        ans = board[i][j][l];
                    }
                }
            }
        }

        System.out.println(ans - 1);
    }

    private static int bfs() {
        int[] rXX = {-1, 1, 0, 0, 0, 0};
        int[] rYY = {0, 0, 1, -1, 0, 0};
        int[] rHH = {0, 0, 0, 0, 1, -1};

        while(!queue.isEmpty()) {
            int[] tot = queue.poll();
            int curx = tot[0], cury = tot[1], curh = tot[2];
            for (int pos = 0; pos < 6; pos++) {
                int nr = curx + rYY[pos], nc = cury + rXX[pos], nh = curh + rHH[pos];
                // +- n 조사는 맞는데 예제3에서 (3,3)이 (4,3)을 조사할 순 없음
                // 즉 nr을 pos 0과 1에 대해 검증해야함
                if(nr < 1 || nc < 1 || nh < 1 || nr > n || nc > m || nh > h) continue;
                // 파티션 필터링이 필요 즉 층을 구분해줘야한다
                // 2층에 있는 놈이 4방향 조사하다가 층을 침범해버리는 불상사
                // nc는 노상관이고 nr만 신경써라
                if (board[nr][nc][nh] == 0) {
                    board[nr][nc][nh] = board[curx][cury][curh] + 1;
                    queue.add(new int[]{nr, nc, nh});
                }
            }
        }
        return -1;
    }

    public static void print() {
        for (int l = 1; l < h + 1; l++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    System.out.print(board[i][j][l] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
