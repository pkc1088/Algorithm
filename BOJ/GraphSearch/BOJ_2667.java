package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// BFS 풀이
public class BOJ_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, r, v, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean[][] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2][n + 2];
        visit = new boolean[n + 2][n + 2];
        boolean first = false;
        int start_row = 0, start_col = 0;
        for (int i = 1; i < n + 1; i++) {
//            st = new StringTokenizer(br.readLine(), "");
            String str = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
            }
        }

        int house_num = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(!visit[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                    house_num++;
                }
            }
        }

        System.out.println(house_num);
        Collections.sort(list);
        for(int n : list) {
            System.out.println(n);
        }
    }

    public static void bfs(int r, int c) {
        Queue<int []> pq = new LinkedList<>();
        pq.offer(new int[] {r,c});
        visit[r][c] = true;
        int cnt = 1;

        while (!pq.isEmpty()) {
            int[] nxt = pq.poll();
            int nxt_r = nxt[0];
            int nxt_c = nxt[1];

            for (int i = 0; i < 4; i++) {
                int nr = nxt_r + dr[i];
                int nc = nxt_c + dc[i];
                if(!visit[nr][nc] && arr[nr][nc] == 1) {
                    pq.offer(new int[]{nr, nc});
                    visit[nr][nc] = true;
                    cnt++;
                }
            }
        }
        list.add(cnt);
    }
}


//// dfs 풀이
//public class BOJ_2667 {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st, tk;
//    static ArrayList<ArrayList<Integer>> graph;
//    static ArrayList<Integer> list, list1, list2;
//    static PriorityQueue<Long> pq;
//    static Queue<Integer> queue;
//    static String str, str1, str2;
//    static boolean[][] visit, visit2;
//    static boolean[][] visited;
//    static int[][] dp2, brr2, arr2, board;
//    static int[] dp, brr, arr, crr, check, result;
//    static int n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//    static int[] rX = {-1, 1, 0, 0};
//    static int[] rY = {0, 0, 1, -1};
//
//    public static void main(String[] args) throws IOException {
//        n = Integer.parseInt(br.readLine());
//        board = new int[n + 1][n + 1];
//        visited = new boolean[n + 1][n + 1];
//
//        for (int i = 1; i < n + 1; i++) {
//            str = br.readLine();
//            for (int j = 1; j < n + 1; j++) {
//                board[i][j] = str.charAt(j - 1) - '0';
//            }
//        }
//        list = new ArrayList<>();
//        cnt = 1;
//
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                if(board[i][j] == 1 && !visited[i][j]){
//                    //visited[i][j] = true;
//                    dfs(i, j);
//                    list.add(cnt);
//                    cnt = 1;
//                }
//            }
//        }
//        System.out.println(list.size());
//        Collections.sort(list);
//        for (int n : list) {
//            System.out.println(n);
//        }
//    }
//
//    private static void dfs(int r, int c) {
//        visited[r][c] = true;
//        for (int i = 0; i < 4; i++) {
//            if(r + rY[i] < 1 || c + rX[i] < 1 || r + rY[i] > n || c + rX[i] > n) continue;
//            if (board[r + rY[i]][c + rX[i]] == 1 && !visited[r + rY[i]][c + rX[i]]) {
//                cnt++;
//                dfs(r + rY[i], c + rX[i]);
//            }
//        }
//    }
//}
