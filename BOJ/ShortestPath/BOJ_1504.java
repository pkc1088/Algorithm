package BOJ.ShortestPath;

import java.io.*;
import java.util.*;
/*
package BOJ;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    //    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<int[]> list = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, h, r, v, e, t, k, l, s, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean[] visit;
    static int[][] arr;
    static int[] brr;
    static Map<Integer, Integer> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 1; i < e + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }
        st = new StringTokenizer(br.readLine(), " ");
        int must1 = Integer.parseInt(st.nextToken());
        int must2 = Integer.parseInt(st.nextToken());

        long ans1 = 0, ans2 = 0, ans3 = 0, ans4 = 0;

//        if(e == 0) {
//            System.out.println(-1);
//        }
//        if(v == 2) {
//            dijkstra(1);
//            ans3 = brr[v];
//            System.out.println(ans3);
//            return;
//        }

        long route1 = 0;
        long route2 = 0;

        dijkstra(1);
        long d1 = brr[must1];
        long d2 = brr[must2];

        dijkstra(must1);
        long d3 = brr[must2];
        long d4 = brr[v];

        dijkstra(must2);
        long d5 = brr[v];

        // 1 -> must1 -> must2 -> v
        if (d1 == Integer.MAX_VALUE || d3 == Integer.MAX_VALUE || d5 == Integer.MAX_VALUE) {
            route1 = Long.MAX_VALUE;
        } else {
            route1 = d1 + d3 + d5;
        }

        // 1 -> must2 -> must1 -> v
        if (d2 == Integer.MAX_VALUE || d3 == Integer.MAX_VALUE || d4 == Integer.MAX_VALUE) {
            route2 = Long.MAX_VALUE;
        } else {
            route2 = d2 + d3 + d4;
        }

        long answer = Math.min(route1, route2);

        if (answer >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
//        dijkstra(1);
//        ans1 += brr[must1]; // 1 ~ must1
//        ans2 += brr[must2]; // 1 ~ must2
//
//        dijkstra(must1);
//        ans1 += brr[must2]; // must1 ~ must2
//        ans2 += brr[v];     // must1 ~ v
//
//        dijkstra(must2);
//        ans1 += brr[v];     // must2 ~ v
//        ans2 += brr[must1]; // must2 ~ must1
//
//        long final_ans = Math.min(ans1, ans2);
//        if(final_ans < Integer.MAX_VALUE)
//            System.out.println(final_ans);
//        else
//            System.out.println(-1);
    }

    public static void dijkstra(int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 필수임
        brr = new int[v + 1];
        Arrays.fill(brr, Integer.MAX_VALUE);

        pq.offer(new int[]{k, 0});
        brr[k] = 0;

        while(!pq.isEmpty()) {
            int[] dto = pq.poll();
            int cn = dto[0]; // current node
            int cw = dto[1]; // current weight

            if (cw > brr[cn]) continue;
            for (int[] next : graph.get(cn)) {
                int newDist = brr[cn] + next[1];
                if (newDist < brr[next[0]]) {
                    brr[next[0]] = newDist;
                    pq.add(new int[]{next[0], newDist});
                }
            }
        }
    }
}

 */

public class BOJ_1504 {
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
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < v + 1; i++) graph.add(new ArrayList<>());
        for (int i = 1; i < e + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int pass1 = Integer.parseInt(st.nextToken()); //2
        int pass2 = Integer.parseInt(st.nextToken()); //3

//        // 1. dijkstra(1) 수행 후 pass1과 pass2까지의 거리 저장
//        dijkstra(1);
//        int startToPass1 = dist[pass1];  // 1 → pass1
//        int startToPass2 = dist[pass2];  // 1 → pass2
//
//        // 2. dijkstra(pass1) 수행 후 pass2와 v까지의 거리 저장
//        dijkstra(pass1);
//        int pass1ToPass2 = dist[pass2];  // pass1 → pass2
//        int pass1ToV = dist[v];          // pass1 → v
//
//        // 3. dijkstra(pass2) 수행 후 v까지의 거리 저장
//        dijkstra(pass2);
//        int pass2ToV = dist[v];          // pass2 → v
//
//        // 경로 1: 1 → pass1 → pass2 → v
//        long path1 = (startToPass1 >= INF || pass1ToPass2 >= INF || pass2ToV >= INF) ? INF
//                    : (long) startToPass1 + pass1ToPass2 + pass2ToV;
//        // 경로 2: 1 → pass2 → pass1 → v
//        long path2 = (startToPass2 >= INF || pass1ToPass2 >= INF || pass1ToV >= INF) ? INF
//                    : (long) startToPass2 + pass1ToPass2 + pass1ToV;
//
//        // 정답 출력
//        long result = Math.min(path1, path2);
//        System.out.println(result >= INF ? -1 : result);

        long res1 = 0;
        dijkstra(1);
        if(dist[pass1] >= INF) res1 += INF;
        else res1 += dist[pass1];

        dijkstra(pass1);
        if(dist[pass2] >= INF) res1 += INF;
        else res1 += dist[pass2];

        dijkstra(pass2);
        if(dist[v] >= INF) res1 += INF;
        else res1 += dist[v];
        System.out.println("res1 : "+res1);
///

        long res2 = 0;
        dijkstra(1);
        if(dist[pass1] >= INF) res2 += INF;
        else res2 += dist[pass2];

        dijkstra(pass2);
        if(dist[pass2] >= INF) res2 += INF;
        else res2 += dist[pass1];

        dijkstra(pass1);
        if(dist[v] >= INF) res2 += INF;
        else res2 += dist[v];
        System.out.println("res2 : "+res2);


        System.out.println((res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2));
    }
}

//package BOJ.ShortestPath;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class BOJ_1504 {
//    static class Node implements Comparable<Node> {
//        int end;
//        int weight;
//
//        Node(int end, int weight) {
//            this.end = end;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return weight - o.weight;
//        }
//
//    }
//    static int N, E;
//    static ArrayList<ArrayList<Node>> a; // 인접리스트.
//    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
//    static boolean[] check; // 방문 확인.
//    static final int INF = 200000000;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//
//        a = new ArrayList<>();
//        dist = new int[N + 1];
//        check = new boolean[N + 1];
//
//        Arrays.fill(dist, INF);
//
//        for (int i = 0; i <= N; i++) {
//            a.add(new ArrayList<>());
//        }
//
//        // 양방향 인접 리스트 구현.
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//
//            // start에서 end로 가는 weight (가중치)
//            a.get(start).add(new Node(end, weight));
//
//            // end에서 start로 가는 weight (가중치)
//            a.get(end).add(new Node(start, weight));
//        }
//
//        // 반드시 거쳐야 하는 정점.
//        st = new StringTokenizer(br.readLine());
//        int v1 = Integer.parseInt(st.nextToken());
//        int v2 = Integer.parseInt(st.nextToken());
//
//        // 1 -> v1 -> v2 -> N으로 가는 경우
//        int res1 = 0;
//        res1 += dijkstra(1, v1);
//        res1 += dijkstra(v1, v2);
//        res1 += dijkstra(v2, N);
//
//        // 1 -> v2 -> v1 -> N으로 가는 경우
//        int res2 = 0;
//        res2 += dijkstra(1, v2);
//        res2 += dijkstra(v2, v1);
//        res2 += dijkstra(v1, N);
//
//        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
//
//        bw.write(ans + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    // 다익스트라 알고리즘
//    public static int dijkstra(int start, int end) {
//        Arrays.fill(dist, INF);
//        Arrays.fill(check, false);
//
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        boolean[] check = new boolean[N + 1];
//        pq.offer(new Node(start, 0));
//        dist[start] = 0;
//
//        while (!pq.isEmpty()) {
//            Node curNode = pq.poll();
//            int cur = curNode.end;
//
//            if (!check[cur]) {
//                check[cur] = true;
//
//                for (Node node : a.get(cur)) {
//                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
//                        dist[node.end] = dist[cur] + node.weight;
//                        pq.add(new Node(node.end, dist[node.end]));
//                    }
//                }
//            }
//        }
//
//        return dist[end];
//    }
//}
