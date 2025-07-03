import java.util.*;
//BOJ 1956 �̶� ��� 
public class NDB_17_2 {

    public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    // ����� ����(N), ������ ����(M)
    public static int n, m;
    // 2���� �迭(�׷��� ǥ��)�� �����
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // �ڱ� �ڽſ��� �ڱ� �ڽ����� ���� ����� 0���� �ʱ�ȭ
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // �� ������ ���� ������ �Է� �޾�, �� ������ �ʱ�ȭ
        for (int i = 0; i < m; i++) {
            // A���� B�� ���� ����� C��� ����
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        // ��ȭ�Ŀ� ���� �÷��̵� ���� �˰����� ����
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF)
                    System.out.print("X ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        int result = 0;
        // �� �л��� ��ȣ�� ���� �� �� Ȯ���ϸ� ���� �������� üũ
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != INF || graph[j][i] != INF) {
                    cnt += 1;
                }
            }
            if (cnt == n) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}

