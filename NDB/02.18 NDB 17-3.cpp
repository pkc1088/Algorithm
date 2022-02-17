import java.util.*;
// ��ǻ� BFS Ǯ����.. �̰� dp�� Ǯ� �ɵ� 
class Node implements Comparable<Node> {

    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }

    // �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    public static int[][] graph = new int [125][125];
    public static int[][] d = new int[125][125];
    public static int testCase, n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        // ��ü �׽�Ʈ ���̽�(Test Case)��ŭ �ݺ�
        for (int tc = 0; tc < testCase; tc++) {
            // ����� ������ �Է¹ޱ�
            n = sc.nextInt();

            // ��ü �� ������ �Է¹ޱ�
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
            }

            int x = 0, y = 0; // ���� ��ġ�� (0, 0)
            // ���� ���� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, graph[x][y]));
            d[x][y] = graph[x][y];

            while(!pq.isEmpty()) { // ���ͽ�Ʈ�� �˰����� ����
                // ���� �ִ� �Ÿ��� ª�� ��忡 ���� ���� ������
                Node node = pq.poll();
                int dist = node.getDistance();
                x = node.getX();
                y = node.getY();
                // ���� ��尡 �̹� ó���� ���� �ִ� ����� ����
                if (d[x][y] < dist) continue;
                // ���� ���� ����� �ٸ� ������ ������ Ȯ��
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    // ���� ������ ����� ��� ����
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    int cost = dist + graph[nx][ny];
                    // ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
                    if (cost < d[nx][ny]) {
                        d[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
            System.out.println(d[n - 1][n - 1]);
        }
    }
}
