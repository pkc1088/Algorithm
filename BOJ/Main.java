package BOJ;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Integer> list = new ArrayList<>();
    static int[] team;
    static boolean[] visit;
    static int[][] arr, brr;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n, m, e, v;
    static int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        team = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1);
        System.out.println(minV);
    }

    public static void dfs(int idx) {

        if (list.size() == n / 2) {
            System.out.println(list);
            minV = Math.min(minV, ability());
            if(minV == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = idx; i < n + 1; i++) {
            if(!visit[i]) {
                visit[i] = true;
                list.add(i);
                dfs(i);
                list.remove(Integer.valueOf(i));
                visit[i] = false;
            }
        }

    }

    public static int ability() { // 1,3,6   // 2,4,5
        int startSum = 0, linkSum = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(list.contains(i) && list.contains(j)) {
                    startSum += arr[i][j];
                } else if(!list.contains(i) && !list.contains(j)) {
                    linkSum += arr[i][j];
                }
            }
        }

        return Math.abs(startSum - linkSum);
    }

}



    /*
    public static void bfs(int r, int c, int step) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, step});

        while(!q.isEmpty()) {
            int[] dto = q.poll();
            int ns = dto[2] + 1;
            for (int i = 0; i < 4; i++) {
                int nr = dto[0] + dr[i];
                int nc = dto[1] + dc[i];
                //System.out.println("nr, nc = " + nr + ", " + nc);

                if(nr < 0 || nr >= n) continue;
                if(nc < 0 || nc >= m) continue;
                if(board[nr][nc] != 1) continue;

                q.offer(new int[]{nr, nc, ns});
                board[nr][nc] = ns;
            }

        }
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }*/












