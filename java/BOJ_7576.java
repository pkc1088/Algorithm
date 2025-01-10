import java.io.*;
import java.util.*;

public class BOJ_7576 {
    static class tomato {
        public int x;
        public int y;
        public tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static int n, m;
    public static Queue<tomato> que;
    public static int[][] board;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());   //6
        n = Integer.parseInt(st.nextToken());   //4
        board = new int[n][m];
        que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    que.offer(new tomato(i, j));
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while(!que.isEmpty()) {
            tomato t = que.poll();
            int x = t.x;
            int y = t.y;
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (board[nx][ny] == -1) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (board[nx][ny] == 0) {
                    que.offer(new tomato(nx, ny));
                    board[nx][ny] = board[x][y] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0)
                    return -1;
                result = Math.max(result, board[i][j]);
            }
        }
        if(result == 1)
            return 0;
        else
            return result-1;
    }
}

