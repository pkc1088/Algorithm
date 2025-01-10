import java.io.*;
import java.util.*;
// scc 코사라주 
public class BOJ_2150 {

    public static int[] visited;
    public static int cnt;
    public static ArrayList<Integer>[] con;
    public static ArrayList<Integer>[] revcon;
    public static Stack<Integer> stack;
    public static boolean[] checked;
    public static ArrayList<Integer> ans;
    public static ArrayList<ArrayList<Integer>> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        con = new ArrayList[V + 1];
        revcon = new ArrayList[V + 1];
        visited = new int[V + 1];
        cnt = 1;

        for (int v = 1; v <= V; v++) {
            con[v] = new ArrayList<Integer>();
            revcon[v] = new ArrayList<Integer>();
        }

        for (int e = 1; e <= E; e++) {
            st = new StringTokenizer(br.readLine().trim());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            con[A].add(B);
            revcon[B].add(A);
        }

        stack = new Stack<Integer>();
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0)
                dfs(i);
        }

        checked = new boolean[V + 1];
        answer = new ArrayList<ArrayList<Integer>>();
        while (!stack.isEmpty()) {
            ans = new ArrayList<Integer>();
            int i = stack.pop();
            if (!checked[i])  {
                scc(i);
                if (ans.size() > 0) {
                    Collections.sort(ans);  
                    answer.add(ans);
                }
            }
        }

        Collections.sort(answer, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a0, ArrayList<Integer> a1) {
                return a0.get(0) - a1.get(0);
            }
        });

        System.out.println(answer.size());
        for (ArrayList<Integer> a : answer) {
            for (Integer i : a) {
                System.out.print(i + " ");
            }
            System.out.println(-1);
        }
    }

    public static void scc(int i) {
        ans.add(i);
        checked[i] = true;
        for (int j = 0; j < revcon[i].size(); j++) {
            int n = revcon[i].get(j);
            if (!checked[n])
                scc(n);
        }
    }

    public static void dfs(int i) {
        visited[i] = cnt++;

        for (int j = 0; j < con[i].size(); j++) {
            int n = con[i].get(j);
            if (visited[n] == 0) {
                dfs(n);
            }
        }
        System.out.println("pushed : "+i);
        stack.push(i);
    }
}

