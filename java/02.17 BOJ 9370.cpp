import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int T, node, road, candi, startLoc, nodeG, nodeH;
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] check;
    static final int INF = 200000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());    //������
            road = Integer.parseInt(st.nextToken());    //����
            candi = Integer.parseInt(st.nextToken());   //�������ĺ� ����
            st = new StringTokenizer(br.readLine());
            startLoc = Integer.parseInt(st.nextToken());    //������
            nodeG = Integer.parseInt(st.nextToken());       //����G
            nodeH = Integer.parseInt(st.nextToken());       //����H

            dist = new int[node + 1];
            check = new boolean[node + 1];
            a = new ArrayList<>();

            //Arrays.fill(dist, INF);
            for (int i = 0; i <= node; i++) {
                a.add(new ArrayList<>());
            }

            for (int i = 0; i < road; i++) {
                st = new StringTokenizer(br.readLine());
                int nodeA = Integer.parseInt(st.nextToken());
                int nodeB = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                a.get(nodeA).add(new Node(nodeB, distance));
                a.get(nodeB).add(new Node(nodeA, distance));
            }

            int[] ans = new int[candi];
            for (int i = 0; i < candi; i++) {
                int x = Integer.parseInt(br.readLine());    //������ �ĺ���
                int res1 = dijkstra(startLoc, nodeG) + dijkstra(nodeG, nodeH) + dijkstra(nodeH, x);
                int res2 = dijkstra(startLoc, nodeH) + dijkstra(nodeH, nodeG) + dijkstra(nodeG, x);
                if (Math.min(res2, res1) == dijkstra(startLoc, x))
                    ans[i] = x;
            }

            Arrays.sort(ans);
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == 0)
                    continue;
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }


    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[node + 1];
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
                    }   //!checked�� �̹湮 �Ѱɷ� �������ִ� ����
                }
            }
        }

        return dist[end];
    }
}




/*
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int distance;

    Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int compareTo(Node o) {
        return distance - o.distance;
    }
}

public class Main {
    public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    public static int T, n, m, t, s, g, h;
    // �� ��忡 ����Ǿ� �ִ� ��忡 ���� ������ ��� �迭
    public static ArrayList<ArrayList<Node>> graph;
    // �ִ� �Ÿ� ���̺� �����
    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int j = 0; j < T; j++){
            n = sc.nextInt();
            m = sc.nextInt();
            t = sc.nextInt();
            graph = new ArrayList<>();

            s = sc.nextInt();
            g = sc.nextInt();
            h = sc.nextInt();

            // �׷��� �ʱ�ȭ
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // ��� ���� ������ �Է¹ޱ�
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                // a�� ��忡�� b�� ���� ���� ����� c��� �ǹ�
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int[] des = new int[t];
            for (int i = 0; i < t; i++){
                des[i] = sc.nextInt();
            }

            for (int d : des) {
                long res1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, d);
                long res2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, d);
                long res3 = dijkstra(s, d);

                if (Math.min(res1, res2) == res3) {
                    pq.add(d);
                } //�������� ���� ��ġ�°� �ּ�(res3)�̸� ť�� ���� 
            }

            while (!pq.isEmpty()) {
                System.out.print(pq.poll() + " ");
            }
            System.out.println();
        }
    }
    
    public static int dijkstra(int start, int end) {
        d = new int[n + 1];
        Arrays.fill(d, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // ���� ���� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
        pq.add(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // ť�� ������� �ʴٸ�
            // ���� �ִ� �Ÿ��� ª�� ��忡 ���� ���� ������
            Node node = pq.poll();
            int now = node.index; // ���� ���
            int dist = node.distance; // ���� �������� ���

            // ���� ��尡 �̹� ó���� ���� �ִ� ����� ����
            if (d[now] < dist) continue;
            // ���� ���� ����� �ٸ� ������ ������ Ȯ��
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                // ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
        return d[end];
    }
}*/


/* Ȧ¦ Ǯ�� 
import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 10_000_000;
    static int vertex, edge, t;
    static int start, g, h;
    static int arr[][];
    static int dist[];
    static boolean check[];
    static List<Integer> answerList;


    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){
            // n,m,t �ʱ�ȭ
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            // �׷��� �迭 ����
            arr = new int[vertex + 1][vertex + 1];
            dist = new int[vertex + 1];
            for(int j = 0 ; j < arr.length; j++)
                Arrays.fill(arr[j], INF);
            Arrays.fill(dist, INF);
            check = new boolean[vertex + 1];

            // s, g, h �ʱ�ȭ
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // �׷��� ���� ����
            for(int j = 0 ; j < edge; j++){
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                // 2���� ����ġ�� ����
                arr[vertex1][vertex2] = arr[vertex2][vertex1] = distance * 2;
            }
            // 2��� ���� -1�� �Ͽ� Ȧ���� �����.
            arr[h][g] = arr[g][h] = arr[h][g] - 1;

            // �ĺ����� list����
            answerList = new ArrayList<>();
            // �ĺ��� �Ǵ� �� �߰�
            for(int j = 0; j < t; j++)
                answerList.add(Integer.parseInt(br.readLine()));

            solve();
            // �������� ����
            Collections.sort(answerList);
            // ���� ���
            for(int num : answerList)
                if(dist[num] % 2 == 1) bw.write(num + " ");
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    private static void solve() {
        dijkstra();
    }

    private static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        // ť�� �� ������
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;
            // �̹� �湮�� ����� ��� �н�
            if(check[cur]) continue;
            // �湮 ó��
            check[cur] = true;

            for(int i = 1; i <= vertex; i++){
                if(check[i] == false && dist[i] > dist[cur] + arr[cur][i]){
                    dist[i] = dist[cur] + arr[cur][i];
                    queue.add(new Node(i, dist[i]));
                }
            }
        }
    }
}
*/
