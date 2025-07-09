package BOJ;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<int[]> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, h, r, v, e, t, k, l, s, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean[][] visit;
    static int[][] arr, brr;
    static Map<Integer, Integer> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(st.nextToken());
        while(t-->0) testCase();
    }
    public static void testCase() throws IOException {
        graph = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < e + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        bfs();
    }


    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        // cycle 생기는지 여부 ?
        int startNode = 1;
        q.offer(new int[]{1, 1, 0, 1}); // row, col, break, distance
        visit[1][1] = true;

        while (!q.isEmpty()) {

            int[] dto = q.poll();
            int row = dto[0];
            int col = dto[1];
            int broke = dto[2];
            int dis = dto[3];
//            if(ans <= dis) return ans;

            if (row == n && col == m) {
//                System.out.println("returned : " + dis);
                return dis;
            }

            // 부수는 것과 안 부수는 것 중 최단이 어떤건진 모름

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (!visit[nr][nc] && 1 <= nr && nr <= n && 1 <= nc && nc <= m) {
                    if (arr[nr][nc] == 0) {
//                        System.out.println("passed : " + nr + ", " + nc);
                        visit[nr][nc] = true;
                        q.offer(new int[]{nr, nc, broke, dis + 1});
                    }
                }
            }
        }
//        System.out.println("default returned : -1");
        return -1;
    }
}










