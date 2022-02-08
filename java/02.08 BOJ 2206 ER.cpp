import java.util.*;
import java.io.*;

public class Main {

    private static class Place {
        int y;
        int x;
        int dis;
        int drill;

        public Place(int y, int x, int dis, int drill) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.drill = drill;
        }
    }
    static int n, m, ans;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int[][] board, visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n ; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = (int) str.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        ans = Integer.MAX_VALUE;

        bfs(0, 0);

        if(ans==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    private static void bfs(int y, int x) {
        Queue<Place> q = new LinkedList<>();
        q.add(new Place(y, x, 1, 0));
        visited[y][x] = 0;

        while (!q.isEmpty()) {
            Place p = q.poll();

            if (p.y == n - 1 && p.x == m - 1) {
                ans = p.dis;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;

                if (visited[ny][nx] <= p.drill)
                    continue;

                if (board[ny][nx] == 0) {
                    visited[ny][nx] = p.drill;
                    q.add(new Place(ny, nx, p.dis + 1, p.drill));
                }

                else {
                    if (p.drill == 0) {
                        visited[ny][nx] = p.drill + 1;
                        q.add(new Place(ny, nx, p.dis + 1, p.drill + 1));
                    }
                }
            }

        }
    }
}
/*
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] temp;
    static int n;
    static int m;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //6
        m = Integer.parseInt(st.nextToken());   //4
        map = new int[n+2][m+2];
        temp = new int[n+2][m+2];
        visited = new boolean[n+2][m+2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        SetWall();
        System.out.println(result);
    }

    public static void SetWall() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;

                    for (int p = 1; i <= n; i++) {
                        for (int q = 1; j <= m; j++) {
                            temp[p][q] = map[p][q];
                            visited[p][q] = false;
                        }
                    }
                    visited[1][1] = true;
                    bfs(1,1);

                    result = Math.min(result, temp[n][m]);

                    map[i][j] = 1;
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            if(nowX == n && nowY == m)
                break;

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX <= 0 || nextY <= 0 || nextX > n || nextY > m)
                    continue;
                if (visited[nextX][nextY] || temp[nextX][nextY] == 1)
                    continue;

                q.add(new int[] {nextX, nextY});
                temp[nextX][nextY] = temp[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
*/
