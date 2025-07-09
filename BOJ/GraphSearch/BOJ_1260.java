package BOJ.GraphSearch;

import java.io.*;
import java.util.*;

public class BOJ_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, r, v, cnt, ans;
    static StringTokenizer st;
    static int[] visit, abi;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

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
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        visit = new int[n + 1];
//        visit[1] = cnt++;
        dfs(v);
        sb.append("\n");

        cnt = 1;
        visit = new int[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int node) {
        visit[node] = cnt;
        sb.append(node).append(" ");
        for (int i = 0; i < graph.get(node).size(); i++) {
            int t = graph.get(node).get(i);

            if(visit[t] == 0) {
                cnt++;
                dfs(t);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(node);
        visit[node] = cnt++;
        sb.append(node).append(" ");

        while (!pq.isEmpty()) {
            int next = pq.poll();

            for (int i = 0; i < graph.get(next).size(); i++) {
                int next_node = graph.get(next).get(i);
                if(visit[next_node] == 0) {
                    pq.offer(next_node);
                    visit[next_node] = cnt++;
                    sb.append(next_node).append(" ");
                }
            }
        }
    }
}

//public class BOJ_1260 {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st, tk;
//    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//    static ArrayList<Integer> list, list1, list2;
//    static PriorityQueue<Long> pq;
//    static Queue<Integer> queue;
//    static String str, str1, str2;
//    static boolean[][] visit2;
//    static boolean[] visit, visited;
//    static int[][] dp2, brr2, arr2, board;
//    static int[] dp, brr, arr, crr, check, result;
//    static int n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        int vertex = Integer.parseInt(st.nextToken());
//        int edge = Integer.parseInt(st.nextToken());
//        int startVertex = Integer.parseInt(st.nextToken());
//        visit = new boolean[vertex + 1];
//        visited = new boolean[vertex + 1];
//        list = new ArrayList<>();
//
//        for (int i = 0; i < vertex + 1; i++) graph.add(new ArrayList<>());
//
//        for (int i = 0; i < edge; i++) {
//            st = new StringTokenizer(br.readLine());
//            int fromVertex = Integer.parseInt(st.nextToken());
//            int toVertex = Integer.parseInt(st.nextToken());
//            graph.get(fromVertex).add(toVertex);
//            graph.get(toVertex).add(fromVertex);
//        }
//        for (int i = 1; i < graph.size(); i++) Collections.sort(graph.get(i));
//
//        dfs(startVertex);
//        for (int ele : list) System.out.print(ele + " "); System.out.println();
//
//        list = new ArrayList<>();
//        bfs(startVertex);
//        for (int ele : list) System.out.print(ele + " ");
//    }
//
//    private static void dfs(int vertex) {
//        list.add(vertex); // 방문 인덱스 정답용으로 담음
//        // list 안 쓰고 그냥 sb.append 하면 됨
//        visit[vertex] = true;
//        for(int i = 0; i < graph.get(vertex).size(); i++) {
//            int newVertex = graph.get(vertex).get(i);
//            if(!visit[newVertex]){
//                dfs(newVertex);
//            }
//        }
//    }
//
//    static void bfs(int start) {
//        queue = new LinkedList<Integer>();
//        queue.add(start);
//        list.add(start); // 첫 노드 담음
//
//        visited[start] = true;
//        while(!queue.isEmpty()) {
//            int cur = queue.poll();
//            for(int next : graph.get(cur)) {
//                if(!visited[next]) {
//                    visited[next] = true;
//                    list.add(next); // 방문 인덱스 정답용으로 담음
//                    queue.add(next);
//                }
//            }
//        }
//    }
//}