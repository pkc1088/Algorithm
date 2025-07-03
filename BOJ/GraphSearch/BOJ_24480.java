package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_24480 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, result;
    static int[] dp, brr, arr, crr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, sum = 0, C = 0, real_idx = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check; // 방문한 정점을 기록할 배열
    static int count; // 방문 순서

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        // 방문한 정점이 최대 정점의 개수만큼 있기 때문에, 정점의 개수만큼의 크기로 배열 생성
        // index 혼란을 방지하고자 0번 인덱스를 더미 데이터로 활용
        check = new int[vertex + 1];
        // graph의 index를 정점의 개수만큼 만들어줌
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            // 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
        // 오름차순을 위해 정렬
        for (int i = 1; i < graph.size(); i++) Collections.sort(graph.get(i), Collections.reverseOrder()); // 1 ~ < 6
        count = 1;
        dfs(startVertex);

        // 각 인덱스별로 방문 순서가 기록된 배열을 순회하며, 값을 StringBuilder에 저장
        for (int i = 1; i < check.length; i++) sb.append(check[i]).append("\n"); // 1 ~ < 6
        System.out.println(sb);
    }

    private static void dfs(int vertex) {
        check[vertex] = count; // 현재 방문하고있는 정점에 순서 저장
        // 현재 위치한 정점이 갈 수 있는 정점 리스트를 순회
        //System.out.println("vertex " + vertex + "size : " + graph.get(vertex).size());
        for(int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            //다음 갈 정점을 방문했었는지 체크(0일 경우 방문 X)
            if(check[newVertex] == 0){
                count++;
                dfs(newVertex);
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
/*
public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] seq;
    static boolean[] visited;
    static int cnt;

    public static void dfs(int root) {
        for (int vertex : graph.get(root)) {
            if (!visited[vertex]) {
                seq[vertex] = cnt++;
                visited[vertex] = true;
                dfs(vertex);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        seq = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i <=n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <=n; i++)
            Collections.sort(graph.get(i));

        seq[start] = 1;
        visited[start] = true;
        cnt = 2;
        dfs(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(seq[i] + "\n");
        System.out.println(sb);
    }
}

 */
