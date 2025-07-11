import java.util.*;

public class NDB_17_4 {
    static class Node implements Comparable<Node> {

        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    public static int n, m;
    public static int start = 1;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[20001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();   // 현재 노드까지의 비용
            int now = node.getIndex();       // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist)
                continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a번 노드와 b번 노드의 이동 비용이 1이라는 의미(양방향)
            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a, 1));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 가장 최단 거리가 먼 노드 번호(동빈이가 숨을 헛간의 번호)
        int maxNode = 0;
        // 도달할 수 있는 노드 중에서, 가장 최단 거리가 먼 노드와의 최단 거리
        int maxDistance = 0;
        // 가장 최단 거리가 먼 노드와의 최단 거리와 동일한 최단 거리를 가지는 노드들의 리스트
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            if (maxDistance < d[i]) {
                maxNode = i;
                maxDistance = d[i];
                result.clear();
                result.add(maxNode);
            }
            else if (maxDistance == d[i]) {
                result.add(i);
            }
        }

        System.out.println(maxNode + " " + maxDistance + " " + result.size());
    }
}

