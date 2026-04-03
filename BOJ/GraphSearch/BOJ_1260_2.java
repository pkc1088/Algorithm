package BOJ.GraphSearch;

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class BOJ_1260_2 {

    static int n, e, start;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        visit = new boolean[n + 1];
        dfs(start);
        sb.append("\n");

        visit = new boolean[n + 1];
        bfs(start);
        System.out.println(sb.toString());

    }

    public static void dfs(int node) {

        visit[node] = true;
        sb.append(node).append(" ");

        for (int i = 0; i < graph.get(node).size(); i++) {
            int nextNode = graph.get(node).get(i);

            if(!visit[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    public static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        visit[startNode] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            for (int i = 0; i < graph.get(node).size(); i++) {
                int nextNode = graph.get(node).get(i);
                if(!visit[nextNode]) {
                    q.offer(nextNode);
                    visit[nextNode] = true;
                }
            }

        }
    }
}
