import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int index;
    int weight;

    Node(int index, int weight) {
        this.index = index;
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
            node = Integer.parseInt(st.nextToken());    //교차로
            road = Integer.parseInt(st.nextToken());    //도로
            candi = Integer.parseInt(st.nextToken());   //목적지후보 개수
            st = new StringTokenizer(br.readLine());
            startLoc = Integer.parseInt(st.nextToken());    //츌발지
            nodeG = Integer.parseInt(st.nextToken());       //간선G
            nodeH = Integer.parseInt(st.nextToken());       //간선H

            dist = new int[node + 1];
            check = new boolean[node + 1];
            a = new ArrayList<>();

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
                int x = Integer.parseInt(br.readLine());    //목적지 후보들
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


    public static int dijkstra(int start, int index) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[node + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.index;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.index] && dist[node.index] > dist[cur] + node.weight) {
                        dist[node.index] = dist[cur] + node.weight;
                        pq.add(new Node(node.index, dist[node.index]));
                    }   //!checked는 미방문 한걸로 한정해주는 역할
                }
            }
        }

        return dist[index];
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
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    public static int T, n, m, t, s, g, h;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph;
    // 최단 거리 테이블 만들기
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

            // 그래프 초기화
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 모든 간선 정보를 입력받기
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
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
                } //냄새나는 간선 거치는게 최소(res3)이면 큐에 넣음 
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
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.add(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int now = node.index; // 현재 노드
            int dist = node.distance; // 현재 노드까지의 비용

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
        return d[end];
    }
}*/


/* 홀짝 풀이 
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
            // n,m,t 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            // 그래프 배열 선언
            arr = new int[vertex + 1][vertex + 1];
            dist = new int[vertex + 1];
            for(int j = 0 ; j < arr.length; j++)
                Arrays.fill(arr[j], INF);
            Arrays.fill(dist, INF);
            check = new boolean[vertex + 1];

            // s, g, h 초기화
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 그래프 정보 저장
            for(int j = 0 ; j < edge; j++){
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                // 2배의 가중치를 저장
                arr[vertex1][vertex2] = arr[vertex2][vertex1] = distance * 2;
            }
            // 2배된 값에 -1을 하여 홀수를 만든다.
            arr[h][g] = arr[g][h] = arr[h][g] - 1;

            // 후보정답 list선언
            answerList = new ArrayList<>();
            // 후보가 되는 값 추가
            for(int j = 0; j < t; j++)
                answerList.add(Integer.parseInt(br.readLine()));

            solve();
            // 오름차순 정렬
            Collections.sort(answerList);
            // 정답 출력
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

        // 큐가 빌 때까지
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;
            // 이미 방문한 노드인 경우 패스
            if(check[cur]) continue;
            // 방문 처리
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
