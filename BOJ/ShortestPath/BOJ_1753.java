package BOJ.ShortestPath;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    static final int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, INF = Integer.MAX_VALUE;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static HashMap<Integer, Integer> hm;
    static ArrayList<Integer> list, list2, list3;
    static Queue<Integer> que;
    static String str, str1, str2;
    static Queue<int[]> queue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, origin;
    static int[] dp, brr, arr, check, result, color, dist;
    static int[] rx = {-1, 1,  0, 0};
    static int[] ry = { 0, 0, -1, 1};
    static int tc, n, m, v, e, h, r, k, a, b, c, count, ans, cnt, sum;

    static class Node{
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
//        public int compareTo(Node o) {
//            return this.weight - o.weight; // 최소 힙 (오름차순)
//        }
//PriorityQueue<Node> pq = new PriorityQueue<>();
    }

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.vertex;
            int curWeight = current.weight;

            if (curWeight > dist[curVertex]) continue;

            for (Node next : graph.get(curVertex)) {
                int newDist = dist[curVertex] + next.weight;

                if (newDist < dist[next.vertex]) {
                    dist[next.vertex] = newDist;
                    pq.add(new Node(next.vertex, newDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dist = new int[v + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < v + 1; i++) graph.add(new ArrayList<>());
        for (int i = 1; i < e + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }

        dijkstra(k);
        // 최단 거리 출력
        for (int i = 1; i < v + 1; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }
}

