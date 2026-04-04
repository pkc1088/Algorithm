package BOJ.GraphSearch;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class BOJ_2178_2 {

    static int n, m, start;
    static int[][] board;
    static int[] r = {0, 0, -1, 1};
    static int[] c = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); // cr cc step

        while(!q.isEmpty()) {
            int[] dto = q.poll();
            int cr = dto[0];
            int cc = dto[1];
            int cs = dto[2];

            if (cr == n - 1 && cc == m - 1) return cs;

            for(int i = 0; i < 4; i++) {
                int nr = cr + r[i];
                int nc = cc + c[i];
                int ns = cs + 1;

                if(0 > nr || nr >= n) continue;
                if(0 > nc || nc >= m) continue;
                if(board[nr][nc] != 1) continue;

                q.offer(new int[]{nr, nc, ns});
                board[nr][nc] = ns;
            }


        }

        return -1;
    }
}
