import java.io.*;
import java.util.*;
/*
DP를 활용해 LCA를 구현하면 이를 해결할 수 있다.
주요 점화식은 정점 V의 2^K번째 조상 정점을 parent[K][V]라고 할때,
parent[K][V] = parent[K-1][parent[K-1][v]]; 이다.
 */
public class BOJ_11438 {

    static int N, M, K;
    static int[] depth;
    static int[][] parent; // parent[K][V] 정점 V의 2^K번째 조상 정점 번호

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
        // 1. depth[a] >= depth[b] 이도록 조정하기
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 2. 더 깊은 a를 2^K승 점프하여 depth를 맞추기
        for (int i = K-1; i>=0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {   //(2^0) <= 4-3
                a = parent[i][a];                          //a=5
                System.out.println("a : "+a);
            }
        }

        // 3. depth를 맞췄는데 같다면 종료    (11과 5 같은 경우)
        if (a == b)
            return a;

        // 4. a-b는 같은 depth이므로 2^K승 점프하며 공통부모 바로 아래까지 올리기
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
