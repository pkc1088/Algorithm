package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static Queue<Integer> queue;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit, visited;
    static int[][] dp2, brr2, arr2, board;
    static int[] dp, brr, arr, crr, check, result;
    static int n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        visit = new boolean[vertex + 1];
        visited = new boolean[vertex + 1];
        list = new ArrayList<>();

        for (int i = 0; i < vertex + 1; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
        for (int i = 1; i < graph.size(); i++) Collections.sort(graph.get(i));

        dfs(startVertex);
        for (int ele : list) System.out.print(ele + " "); System.out.println();

        list = new ArrayList<>();
        bfs(startVertex);
        for (int ele : list) System.out.print(ele + " ");
    }

    private static void dfs(int vertex) {
        list.add(vertex); // 방문 인덱스 정답용으로 담음
        visit[vertex] = true;
        for(int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            if(!visit[newVertex]){
                dfs(newVertex);
            }
        }
    }

    static void bfs(int start) {
        queue = new LinkedList<Integer>();
        queue.add(start);
        list.add(start); // 첫 노드 담음

        visited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    list.add(next); // 방문 인덱스 정답용으로 담음
                    queue.add(next);
                }
            }
        }
    }
}