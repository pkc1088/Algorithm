package BOJ.GraphSearch;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2206 {

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
                    // 이미 현재보다 적은 횟수로 벽을 부순 경우 방문 불필요 (최적 경로 보장)
                    // 현재 (ny, nx) 좌표에 도달한 적이 있는데,
                    // 그때 사용한 벽 부수기 횟수가 현재 경로에서의 벽 부수기 횟수 p.drill보다
                    // 작거나 같다면을 의미
                    /*
                    즉, 이미 더 적은(또는 같은) 횟수로 (ny, nx)에 도달했기 때문에,
                    현재 경로는 더 많은 벽을 부수었거나 같으므로, 더 나은(최적의) 경로가 아닙니다.
                     */
                    continue;

                if (board[ny][nx] == 0) {
                    visited[ny][nx] = p.drill;
                    q.add(new Place(ny, nx, p.dis + 1, p.drill)); // 그냥 길이면 p.drill 그대로
                }

                else {
                    if (p.drill == 0) {
                        visited[ny][nx] = p.drill + 1;
                        q.add(new Place(ny, nx, p.dis + 1, p.drill + 1));
                        // 벽아면 p.drill + 1
                    }
                }
            }

        }
    }
}
/*
public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 현재 위치, 벽을 부순적이 있는지, 지나간 타일의 수를 저장하는 클래스입니다.
    static class Point {
        int x;
        int y;
        boolean destroyed;
        int cnt;

        public Point(int x, int y, boolean destroyed, int cnt) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        // 시작점을 큐에 넣습니다.
        queue.offer(new Point(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            // 도착하면 지나간 타일 수를 반환합니다.
            if (point.x == n - 1 && point.y == m - 1) {
                return point.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int newX = point.x + dx[d];
                int newY = point.y + dy[d];

                // 배열을 벗어난 경우는 넘어갑니다.
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                // 벽을 부순적이 있는지 확인합니다.
                if (point.destroyed) {
                    // 벽을 부순적이 있을 때 해당 지점이 벽이 아니고, 방문한적이 없다면 큐에 정보를 넣습니다.
                    if (board[newX][newY] == 0 && !visited[newX][newY][1]) {
                        visited[newX][newY][1] = true;
                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
                    }
                } else {
                    // 해당 위치가 벽인지 확인합니다.
                    if (board[newX][newY] == 1) {
                        // 벽이라면 벽을 부수고 큐에 값을 넣습니다.
                        visited[newX][newY][1] = true;
                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
                    } else if (!visited[newX][newY][0]){
                        // 벽이 아니고 방문한적이 없다면 큐에 값을 넣습니다.
                        visited[newX][newY][0] = true;
                        queue.offer(new Point(newX, newY, false, point.cnt + 1));
                    }
                }
            }
        }

        return -1;
    }
}

 */