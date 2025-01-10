import java.io.*;
import java.util.*;
/*
DP�� Ȱ���� LCA�� �����ϸ� �̸� �ذ��� �� �ִ�.
�ֿ� ��ȭ���� ���� V�� 2^K��° ���� ������ parent[K][V]��� �Ҷ�,
parent[K][V] = parent[K-1][parent[K-1][v]]; �̴�.
 */
public class BOJ_11438 {

    static int N, M, K;
    static int[] depth;
    static int[][] parent; // parent[K][V] ���� V�� 2^K��° ���� ���� ��ȣ

    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = 0;
        for (int i = 1; i <= N; i *= 2) {
            K++;
        }

        depth = new int[N + 1];
        parent = new int[K][N + 1];
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        init(1, 1, 0);
        fillParent();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCA(a, b));
        }

        for (int i = 0; i<K; i++) {
            for (int j = 1; j<=N; j++) {
                System.out.print(parent[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void init(int cur, int d, int pa) {
        depth[cur] = d;
        parent[0][cur] = pa;
        for(int next : tree[cur]) {
            if(next != pa) {
                init(next, d+1, cur);
            }
        }
    }

    static void fillParent() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }

    static int LCA(int a, int b) {
        // 1. depth[a] >= depth[b] �̵��� �����ϱ�
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 2. �� ���� a�� 2^K�� �����Ͽ� depth�� ���߱�
        for (int i = K-1; i>=0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {   //(2^0) <= 4-3
                a = parent[i][a];                          //a=5
                System.out.println("a : "+a);
            }
        }

        // 3. depth�� ����µ� ���ٸ� ����    (11�� 5 ���� ���)
        if (a == b)
            return a;

        // 4. a-b�� ���� depth�̹Ƿ� 2^K�� �����ϸ� ����θ� �ٷ� �Ʒ����� �ø���
        for (int i = K-1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
                System.out.println("a : "+a+", b : "+b);
            }
        }

        return parent[0][a];
    }
}
