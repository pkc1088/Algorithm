import java.io.*;
import java.util.*;

public class BOJ_1967 {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, cost));
            list[e].add(new Node(s, cost));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for (int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if (!visited[n.e]) {
                dfs(n.e, n.cost + len);
                visited[n.e] = true;
            }
        }

    }

    public static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
