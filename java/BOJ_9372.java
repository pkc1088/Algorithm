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

        // �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
        @Override
        public int compareTo(Edge other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }
    // ����� ����(V)�� ����(Union ����)�� ����(E)
    public static int n, m;
    public static int[] parent; // �θ� ���̺� �ʱ�ȭ�ϱ�
    public static ArrayList<Edge> edges;
    public static int result = 0;

    // Ư�� ���Ұ� ���� ������ ã��
    public static int findParent(int x) {
        // ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    // �� ���Ұ� ���� ������ ��ġ��
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
            n = Integer.parseInt(st.nextToken());       // ���� ��
            m = Integer.parseInt(st.nextToken());       // ����� ��

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

            // ������ �ϳ��� Ȯ���ϸ�
            for (int i = 0; i < edges.size(); i++) {
                int cost = edges.get(i).getDistance();
                int a = edges.get(i).getNodeA();
                int b = edges.get(i).getNodeB();

                // ����Ŭ�� �߻����� �ʴ� ��쿡�� ���տ� ����
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
