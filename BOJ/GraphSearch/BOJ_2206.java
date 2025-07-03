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
                    // �̹� ���纸�� ���� Ƚ���� ���� �μ� ��� �湮 ���ʿ� (���� ��� ����)
                    // ���� (ny, nx) ��ǥ�� ������ ���� �ִµ�,
                    // �׶� ����� �� �μ��� Ƚ���� ���� ��ο����� �� �μ��� Ƚ�� p.drill����
                    // �۰ų� ���ٸ��� �ǹ�
                    /*
                    ��, �̹� �� ����(�Ǵ� ����) Ƚ���� (ny, nx)�� �����߱� ������,
                    ���� ��δ� �� ���� ���� �μ����ų� �����Ƿ�, �� ����(������) ��ΰ� �ƴմϴ�.
                     */
                    continue;

                if (board[ny][nx] == 0) {
                    visited[ny][nx] = p.drill;
                    q.add(new Place(ny, nx, p.dis + 1, p.drill)); // �׳� ���̸� p.drill �״��
                }

                else {
                    if (p.drill == 0) {
                        visited[ny][nx] = p.drill + 1;
                        q.add(new Place(ny, nx, p.dis + 1, p.drill + 1));
                        // ���Ƹ� p.drill + 1
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

    // ���� ��ġ, ���� �μ����� �ִ���, ������ Ÿ���� ���� �����ϴ� Ŭ�����Դϴ�.
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

        // �������� ť�� �ֽ��ϴ�.
        queue.offer(new Point(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            // �����ϸ� ������ Ÿ�� ���� ��ȯ�մϴ�.
            if (point.x == n - 1 && point.y == m - 1) {
                return point.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int newX = point.x + dx[d];
                int newY = point.y + dy[d];

                // �迭�� ��� ���� �Ѿ�ϴ�.
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                // ���� �μ����� �ִ��� Ȯ���մϴ�.
                if (point.destroyed) {
                    // ���� �μ����� ���� �� �ش� ������ ���� �ƴϰ�, �湮������ ���ٸ� ť�� ������ �ֽ��ϴ�.
                    if (board[newX][newY] == 0 && !visited[newX][newY][1]) {
                        visited[newX][newY][1] = true;
                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
                    }
                } else {
                    // �ش� ��ġ�� ������ Ȯ���մϴ�.
                    if (board[newX][newY] == 1) {
                        // ���̶�� ���� �μ��� ť�� ���� �ֽ��ϴ�.
                        visited[newX][newY][1] = true;
                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
                    } else if (!visited[newX][newY][0]){
                        // ���� �ƴϰ� �湮������ ���ٸ� ť�� ���� �ֽ��ϴ�.
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