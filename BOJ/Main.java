package BOJ;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static StringTokenizer st;
//    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int n, m, r, cnt, ans;
    static int[] visit, abi;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visit = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

//        System.out.println(graph);
        cnt = 1;
        bfs(r);

        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int node) {
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(node);
        visit[node] = cnt++;

        while (!pq.isEmpty()) {
            int next = pq.poll();

            for (int i = 0; i < graph.get(next).size(); i++) {
                int next_node = graph.get(next).get(i);
                if(visit[next_node] == 0) {
                    pq.offer(next_node);
                    visit[next_node] = cnt++;
                }
            }
        }
    }

}










