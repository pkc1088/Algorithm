import java.util.*;

public class NDB_5_11 {
    static class Node {

        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
    public static int n, m;
    public static int[][] graph = new int[201][201];

    // �̵��� �� ���� ���� ���� (��, ��, ��, ��) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // ť(Queue) ������ ���� queue ���̺귯�� ��� 
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        // ť�� �� ������ �ݺ��ϱ� 
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // ���� ��ġ���� 4���� ���������� ��ġ Ȯ��
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // �̷� ã�� ������ ��� ��� ����
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // ���� ��� ����
                if (graph[nx][ny] == 0) continue;
                // �ش� ��带 ó�� �湮�ϴ� ��쿡�� �ִ� �Ÿ� ���
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                } 
            } 
        }
        // ���� ������ �Ʒ������� �ִ� �Ÿ� ��ȯ
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M�� ������ �������� �����Ͽ� �Է� �ޱ�
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // ���� �����

        // 2���� ����Ʈ�� �� ���� �Է� �ޱ�
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS�� ������ ��� ���
        System.out.println(bfs(0, 0));
    }

}

/* error?
import java.io.*;
import java.util.*;
public class NDB_5-11 {
    static int[][] map;
    static boolean[][] checked; //Ȯ�� ����
    static int n;
    static int m;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        checked = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 1);
        System.out.println(cnt+1); //������ ��ġ +1
    }

    public static void dfs(int p, int k) {
        if(p == n && k == m)
            return;

        checked[p][k] = true;
        cnt++;
        if(p+1<=n && map[p+1][k] == 1 && !checked[p+1][k])
            dfs(p+1, k);
        else if(k+1<=m && map[p][k+1] == 1 && !checked[p][k+1])
            dfs(p, k+1);
        else if(p-1>=1 && map[p-1][k] == 1 && !checked[p-1][k])
            dfs(p-1, k);
        else if(k-1>=1 && map[p][k-1] == 1 && !checked[p][k-1])
            dfs(p, k-1);
    }

}
*/
