import java.util.*;
import java.io.*;

public class BOJ_7562 {
    private static class Place {
        int y;
        int x;
        int count;

        public Place(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static int[][] board;
    public static int[][] visited;
    static int[] dy = { -2, -2,  2,  2, -1,  1, -1, 1}; //╩С2го2аб2©Л2
    static int[] dx = { -1,  1, -1,  1, -2, -2,  2, 2};
    static int ans, n, cx, cy, nx, ny;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];

            for (int[] row: board)
                Arrays.fill(row, Integer.MAX_VALUE);

            visited = new int[n][n];
            st = new StringTokenizer(br.readLine(), " ");
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            nx = Integer.parseInt(st.nextToken());
            ny = Integer.parseInt(st.nextToken());
            bfs();
            System.out.println(ans-1);
        }
    }

    public static void bfs() {
        Queue<Place> q = new LinkedList<>();
        q.add(new Place(cy, cx, 1));
        visited[cy][cx] = 1;

        while (!q.isEmpty()) {
            Place p = q.poll();

            if (p.y == ny && p.x == nx) {
                ans = p.count;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                    continue;

                if (board[ny][nx] > p.count) {
                    board[ny][nx] = p.count;
                    q.add(new Place(ny, nx, p.count + 1));
                }

            }

        }
    }
}


