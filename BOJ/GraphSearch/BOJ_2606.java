package BOJ.GraphSearch;


import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit, visited;
    static int[][] dp2, brr2, arr2, board;
    static int[] dp, brr, arr, crr, check, result;
    static int n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        int startVertex = 1;
        check = new int[vertex + 1];
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
        //for (int i = 1; i < graph.size(); i++) Collections.sort(graph.get(i)); // 1 ~ < 6
        count = 1;
        dfs(startVertex);
        //for (int i = 1; i < check.length; i++) sb.append(check[i]).append("\n"); // 1 ~ < 6
        //System.out.println(sb);
        System.out.println(count - 1);
    }

    private static void dfs(int vertex) {
        //System.out.println("check["+vertex+"] = "+count);
        check[vertex] = count; // 현재 방문하고있는 정점에 순서 저장
        // 현재 위치한 정점이 갈 수 있는 정점 리스트를 순회
        //System.out.println("vertex " + vertex + "size : " + graph.get(vertex).size());
        for(int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            if(check[newVertex] == 0){
                count++;
                dfs(newVertex);
            }
        }
    }
    //너비 우선 탐색을 수행하는 함수
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();	//사용할 큐
        queue.add(start);	//시작 정점 큐에 저장
        visited[start] = true;		//시작 정점 방문 확인
        result[start] = count++;	//시작 순번 저장
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            Collections.sort(graph.get(cur), Collections.reverseOrder());	//오름차순 정렬
            //인접한 정점 탐색
            for(int next : graph.get(cur)) {
                if(!visited[next]) {	//방문하지 않았던 정점시
                    visited[next] = true;
                    result[next] = count++;
                    queue.add(next);
                }
            }
        }
    }
}