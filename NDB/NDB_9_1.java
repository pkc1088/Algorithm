import java.util.*;
import java.io.*;


public class NDB_9_1 {
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

    }
    static int N, E;
    static ArrayList<ArrayList<Node>> a; // 인접리스트.
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check; // 방문 확인.
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        // 양방향 인접 리스트 구현.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, 1));
            a.get(end).add(new Node(start, 1));
        }

        // 반드시 거쳐야 하는 정점.
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N으로 가는 경우
        int res1 = 0;
        res1 += dijkstra(1, k);
        res1 += dijkstra(k, x);

        int ans = (res1 >= INF) ? -1 : res1;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }
}
