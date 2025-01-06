import java.io.*;
import java.util.*;
// scc 타잔

public class Main {
    static int scc_total, num;
    static ArrayList<Integer>[] edges;
    static int[] order, scc_arr;
    static boolean[] visit; // SCC 확정된 정점 확인
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        edges = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
        }

        scc_arr = new int[N + 1];
        order = new int[N + 1];
        visit = new boolean[N + 1];
        scc_total = num = 0;
        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!visit[i])
                SCC(i);
        }

        int[] dp = new int[scc_total];
        int[] indegree = new int[scc_total];
        List<Integer>[] scc = new ArrayList[scc_total];
        for (int i = 0; i < scc_total; i++) {
            scc[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            indegree[scc_arr[i]] += Integer.parseInt(st.nextToken());
            for (int j : edges[i]) {
                if (scc_arr[i] != scc_arr[j])
                    scc[scc_arr[i]].add(scc_arr[j]);
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = scc_arr[Integer.parseInt(st.nextToken())];
        int p = Integer.parseInt(st.nextToken());
        int answer = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        dp[s] = indegree[s];
        que.add(s);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : scc[now]) {
                if (dp[next] < dp[now] + indegree[next]) {
                    dp[next] = dp[now] + indegree[next];
                    que.add(next);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        while (p-- > 0)
            answer = Math.max(answer,
                              dp[scc_arr[Integer.parseInt(st.nextToken())]]);
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int SCC(int idx) {
        order[idx] = ++num;
        stack.add(idx);
        int root = order[idx];

        for (int next : edges[idx]) {
            if (order[next] == 0)
                root = Math.min(root, SCC(next));
            else if (!visit[next])
                root = Math.min(root, order[next]);
        }

        if (root == order[idx]) {
            while (true) {
                int top = stack.pop();
                scc_arr[top] = scc_total;
                visit[top] = true;
                if (top == idx)
                    break;
            }
            scc_total++;
        }
        return root;
    }
}


/*
public class Main {
    static boolean[] finished,isRes;
    static int n, m, index, sccIndex, start, max;
    static int[] discover,sccNum,atm,totalAtm,dp;
    static ArrayList<ArrayList<Integer>> list,sccList;
    static Stack<Integer> st;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new ArrayList<>();
        atm = new int[n+1];
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
 
        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            list.get(edge[0]).add(edge[1]);
        }
        for(int i=1;i<=n;i++) atm[i] = Integer.parseInt(br.readLine());
 
        input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        isRes = new boolean[n+1];
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(e->isRes[e]=true);
 
        findScc();
        setSccInfo();
        sccBfs();
 
        for(int i=1;i<=n;i++)
            if(isRes[i]) max = Math.max(max,dp[sccNum[i]]);
        System.out.println(max);
 
    }
 
    private static void sccBfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(sccNum[start]);
        dp[sccNum[start]] = totalAtm[sccNum[start]];
 
        while (!q.isEmpty()){
            Integer cur = q.poll();
 
            for (Integer next : sccList.get(cur)) {
                if(dp[next] < dp[cur] + totalAtm[next]){
                    dp[next] = dp[cur]+totalAtm[next];
                    q.add(next);
                }
            }
        }
    }
 
 
    private static void setSccInfo() {
        totalAtm = new int[sccIndex+1];
        sccList = new ArrayList<>();
        dp = new int[sccIndex+1];
        for(int i=0;i<=sccIndex;i++) sccList.add(new ArrayList<>());
 
        for (int i = 1; i <= n; i++) {
            totalAtm[sccNum[i]]+=atm[i];
            for (Integer next : list.get(i))
                if (sccNum[i] != sccNum[next]) sccList.get(sccNum[i]).add(sccNum[next]);
        }
    }
 
    private static void findScc() {
 
        index = 0;
        discover = new int[n + 1];
        finished = new boolean[n + 1];
        st = new Stack<>();
        sccIndex = 0;
        sccNum = new int[n + 1];
 
        for (int i = 1; i <= n; i++)
            if (discover[i] == 0) dfs(i);
 
    }
 
    private static int dfs(int cur) {
        discover[cur] = ++index;
        st.push(cur);
 
        int parent = discover[cur];
        for (Integer next : list.get(cur)) {
            if (discover[next] == 0) parent = Math.min(dfs(next), parent);
            else if (!finished[next]) parent = Math.min(discover[next], parent);
        }
 
        if (parent == discover[cur]) {
            while (true) {
                Integer pop = st.pop();
                finished[pop] = true;
                sccNum[pop] = sccIndex + 1;
                if (pop == cur) break;
            }
            sccIndex++;
        }
        return parent;
    }
}
*/
