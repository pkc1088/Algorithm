import java.io.*;
import java.util.*;

public class BOJ_3176 {

    static int N, K;	// N : ������, K : 2�� ����
    static int M;		// M : ���� �� (�������� K)

    // LCA ���� ����
    static int[] depth;
    static int[][] parent; // parent[K][V] ���� V�� 2^K��° ���� ���� ��ȣ
    // parent[K][V] = parent[K-1][parent[K-1][V]];
    // TREE ����
    static ArrayList[] tree;

    // ���� ��Ʈ��ũ �߰�����
    static int[][] minDist;	// minDist[K][V]  ���� V�� 2^K��° ��������� �ּҰŸ� ����
    static int[][] maxDist; // maxDist[K][V]  ���� V�� 2^K��° ��������� �ִ�Ÿ� ����

    static int min,max;

    public static class edge{
        int target,cost;

        public edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. �Է� & ���� �غ�
        N = Integer.parseInt(br.readLine());

        // 2^K > N�� K ã��
        K = 0;
        for (int i = 1; i <= N; i *= 2) {
            K++;
        }

        // LCA ���� ���� �ʱ�ȭ
        depth = new int[N + 1];
        parent = new int[K][N + 1];

        // ���� ��Ʈ��ũ ���� �ʱ�ȭ
        minDist = new int[K][N + 1];
        maxDist = new int[K][N + 1];

        // TREE ���� �ʱ�ȭ
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<edge>();
        }

        int a,b,c;
        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            // ����� ����
            tree[a].add(new edge(b, c));
            tree[b].add(new edge(a, c));
        }

        // 2. DEPTH Ȯ��
        dfs(1, 1);

        // 3. 2^N ���� parent ä���
        fillParent();

        // 4. LCA ����
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            lca(a, b);
            sb.append(min+" "+max+"\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    // DEPTH Ȯ�� DFS
    static void dfs(int id, int cnt) {
        // 1. depth�� ���
        depth[id] = cnt;

        for (int i = 0; i < tree[id].size(); i++) {
            edge next = (edge) tree[id].get(i);
            if (depth[next.target] == 0) {
                dfs(next.target, cnt+1);
                parent[0][next.target] = id;		// ù��° �θ� ���
                minDist[0][next.target] = next.cost; // ���� cost�� ����
                maxDist[0][next.target] = next.cost; // ���� cost�� ����

            }
        }
        return;
    }
  
    // �θ� ä���
    static void fillParent() {
        for (int i = 1; i<K; i++) {
            for (int j = 1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];

                // ���γ�Ʈ��ũ �߰�
                minDist[i][j] = Math.min( minDist[i-1][j], minDist[i-1][parent[i-1][j]]);
                maxDist[i][j] = Math.max( maxDist[i-1][j], maxDist[i-1][parent[i-1][j]]);
            }
        }
    }

    // �ּҰ�������
    static void lca(int a, int b) {
        // 1. depth[a] >= depth[b] �̵��� �����ϱ�
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        min = Integer.MAX_VALUE;
        max = -1;

        // 2. �� ���� a�� 2^K�� �����Ͽ� depth�� ���߱�
        for (int i = K-1; i>=0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                min = Math.min(min, minDist[i][a]);
                max = Math.max(max, maxDist[i][a]);

                a = parent[i][a];
            }
        }

        // 3. depth�� ����µ� ���ٸ� ����
        if (a == b) 
            return;

        // 4. a-b�� ���� depth�̹Ƿ� 2^K�� �����ϸ� ����θ� �ٷ� �Ʒ����� �ø���
        for (int i = K-1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                min = Math.min(min, Math.min(minDist[i][a], minDist[i][b]));
                max = Math.max(max, Math.max(maxDist[i][a], maxDist[i][b]));

                a = parent[i][a];
                b = parent[i][b];
            }
        }

        min = Math.min(min, Math.min(minDist[0][a], minDist[0][b]));
        max = Math.max(max, Math.max(maxDist[0][a], maxDist[0][b]));

        return;
    }
}
