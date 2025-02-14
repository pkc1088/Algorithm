package BOJ;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;


public class Main {
    static final int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, INF = 200000000;
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
    static int tc, n, m, v, e, h, r, k, a, b, c, count, cnt, sum;
    static long ans;

    static class Node implements Comparable<Node> {
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        public int compareTo(Node o) {
            return this.weight - o.weight; // 최소 힙 (오름차순)
        }
    }

    public static void dijkstra(int start) {
        dist = new int[v + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
//        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
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
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        check = new int[100001];
        int result = bfs(n);
        System.out.println(result);
    }
    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        check[node] = 1;
        while (!queue.isEmpty()) {
            int seq = queue.poll();

            if (seq == k) return check[seq] - 1;

            if (2 * seq <= 100000 && check[2 * seq] == 0) {
                check[2 * seq] = check[seq];
                queue.add(2 * seq);
            }
            if (seq - 1 >= 0 && check[seq - 1] == 0) {
                check[seq - 1] = check[seq] + 1;
                queue.add(seq - 1);
            }
            if (seq + 1 <= 100000 && check[seq + 1] == 0) {
                check[seq + 1] = check[seq] + 1;
                queue.add(seq + 1);
            }
//temp
        }
        return -1;
    }
}
