import java.io.*;
import java.util.*;


public class BOJ_9372 {
    static class Edge implements Comparable<Edge> {

        private int distance;
        private int nodeA;
        private int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return this.distance;
        }

        public int getNodeA() {
            return this.nodeA;
        }

        public int getNodeB() {
            return this.nodeB;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Edge other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }
    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    public static int n, m;
    public static int[] parent; // 부모 테이블 초기화하기
    public static ArrayList<Edge> edges;
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());       // 국가 수
            m = Integer.parseInt(st.nextToken());       // 비행기 수

            parent = new int[10001];
            ArrayList<Edge> edges = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.add(new Edge(1, a, b));
            }

            Collections.sort(edges);

            // 간선을 하나씩 확인하며
            for (int i = 0; i < edges.size(); i++) {
                int cost = edges.get(i).getDistance();
                int a = edges.get(i).getNodeA();
                int b = edges.get(i).getNodeB();

                // 사이클이 발생하지 않는 경우에만 집합에 포함
                if (findParent(a) != findParent(b)) {
                    unionParent(a, b);
                    result += cost;
                }
            }

            System.out.println(result);
            result = 0;
        }


    }
}
