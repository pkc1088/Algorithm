import java.io.*;
import java.util.*;

public class BOJ_13511 {

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n,h;
    static List<Node>[] list;
    static int[] depth;
    static long[] cost;
    static int[][] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;

        list = new ArrayList[n+1];
        parents = new int[n+1][h];
        depth = new int[n+1];
        cost = new long[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
            list[v].add(new Node(u,w));

        }

        init(1,0,-1);
        fillParents();

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int lca = LCA(u,v);
            if(op == 1) {
                sb.append(cost[u] + cost[v] - 2*cost[lca] +"\n");
            }else {
                int k = Integer.parseInt(st.nextToken());
                sb.append(kNode(u, v, lca, k) +"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int kNode(int x, int y, int root, int k) {
        int xh = depth[x];
        int yh = depth[y];

        int mid = xh-depth[root]+1;
        int tmp= 0;
        if(mid == k) { // mid
            return root;
        }else if(mid > k) { // left
            k -=1;
            tmp = x;
        }else { // right
            k = mid + yh - depth[root] - k;
            tmp = y;
        }

        for(int i=h-1; i>=0; i--) {
            if((k & (1<<i)) !=0) {
                k ^= (1<<i); // 2^i번째 부모로 이동
                tmp = parents[tmp][i];
            }
        }
        return tmp;
    }

    static int LCA(int x, int y) {
        int xh = depth[x];
        int yh = depth[y];

        // make (xh > yh)
        if(xh <yh) {
            int tmp  = x;
            x = y;
            y = tmp;
            xh = depth[x];
            yh = depth[y];
        }

        // matching depth
        for(int i=h-1; i>=0; i--) {
            if(Math.pow(2, i) <= depth[x]-depth[y]) {
                x = parents[x][i];
            }
        }
        if(x==y) return x;

        // find LCA
        for(int i=h-1; i>=0; i--) {
            if(parents[x][i] != parents[y][i]) {
                x = parents[x][i];
                y = parents[y][i];
            }
        }
        return parents[x][0];
    }

    static void init(int cur, int h, int pa) {
        depth[cur] = h;
        for(Node nxt : list[cur]) {
            if(nxt.to != pa) {
                cost[nxt.to] += cost[cur] + nxt.cost;
                init(nxt.to, h+1, cur);
                parents[nxt.to][0] = cur; // nxt의 부모 cur
            }
        }
    }

    static void fillParents() {
        for(int i=1; i<h; i++) {
            for(int j=1; j<n+1; j++) {
                parents[j][i] = parents[parents[j][i-1]][i-1];
            }
        }
    }
}


/*
public class BOJ_13511 {
    static int N, K, sum = 0, cnt, till;
    static int M;
    static int[] depth;
    static int[][] parent; // parent[K][V] 정점 V의 2^K번째 조상 정점 번호
    static ArrayList<edge>[] tree;
    static Stack<Integer> stk;
    static int[][] minDist;
    static int[][] maxDist;
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

        int a,b,c;
        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            tree[a].add(new edge(b, c));
            tree[b].add(new edge(a, c));
        }

        dfs(1, 1);
        fillParent();

        M = Integer.parseInt(br.readLine());
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            if(check == 1) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                lca(a, b, 1);
                System.out.println("sum : "+sum);
            }
            if(check == 2) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                till = Integer.parseInt(st.nextToken());
                check_route(a, b);
                System.out.println(cnt-1);
            }
        }


    }

    static void check_route(int a, int b) {
        stk = new Stack<>();
        stk.push(a);
        cnt = 1;
        if(cnt == till)
            return;

        int to = parent[0][a];
        if(to == 0) {
            return;
        }
        stk.push(to);
        cnt++;
        if(cnt == till)
            return;

        while(true) {
            to = parent[0][to];
            if(to == 0) {
                cnt++;
                stk.push(to);
                break;
            }
            stk.push(to);
            cnt++;
            if(cnt == till)
                return;
        }

        int t = 1;
        while(true) {
            if(cnt == till)
                return;

            for (int i = 1; i <= N; i++) {
                if(t == parent[0][i]) {
                    stk.push(t);
                    cnt++;
                    t++;
                }
            }
        }


    }

    static void dfs(int id, int cnt) {
        depth[id] = cnt;
        for (int i = 0; i < tree[id].size(); i++) {
            edge next = tree[id].get(i);
            if (depth[next.target] == 0) {
                dfs(next.target, cnt+1);
                parent[0][next.target] = id;
            }
        }
    }

    static void fillParent() {
        for (int i = 1; i<K; i++) {
            for (int j = 1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }

    static void lca(int a, int b, int check) {
        if (check == 1 && depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 2. 더 깊은 a를 2^K승 점프하여 depth를 맞추기
        for (int i = K-1; i>=0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                int prev = a;
                a = parent[i][a];

                if(tree[prev].get(i).target == a) {
                    sum += tree[prev].get(i).cost;
                }
            }
        }

        // 3. depth를 맞췄는데 같다면 종료
        if (a == b)
            return;

        // 4. a-b는 같은 depth이므로 2^K승 점프하며 공통부모 바로 아래까지 올리기
        for (int i = K-1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                int prevA = a;
                int prevB = b;
                a = parent[i][a];
                b = parent[i][b];

                if(tree[prevA].get(i).target == a) {
                    sum += tree[prevA].get(i).cost;
                }
                if(tree[prevB].get(i).target == b) {
                    sum += tree[prevB].get(i).cost;
                }
            }
        }

        sum += tree[a].get(0).cost;
        sum += tree[b].get(0).cost;
    }
}

*/
