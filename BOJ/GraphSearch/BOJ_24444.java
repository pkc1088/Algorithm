package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_24444 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static StringTokenizer st;
    //    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int n, m, r, cnt, ans;
    static int[] visit, abi;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visit = new int[n + 1];
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

//        System.out.println(graph);
        cnt = 1;
        bfs(r);

        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int node) {
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(node);
        visit[node] = cnt++;

        while (!pq.isEmpty()) {
            int next = pq.poll();

            for (int i = 0; i < graph.get(next).size(); i++) {
                int next_node = graph.get(next).get(i);
                if(visit[next_node] == 0) {
                    pq.offer(next_node);
                    visit[next_node] = cnt++;
                }
            }
        }
    }

}

/*
public class BOJ_24444 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Long> pq;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit, visited;
    static int[][] dp2, brr2, arr2, board;
    static int[] dp, brr, arr, crr, check, result;
    static int n, m, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, C = 0, real_idx = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };

    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        //�Է°� ����, �迭 �� ����Ʈ �ʱ�ȭ
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        result = new int[vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < edge + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
        count = 1;
        bfs(startVertex);		//�ʺ� �켱 Ž�� ����
        for (int i = 1; i < vertex + 1; i++) {
            sb.append(result[i]).append("\n");
        }        //�� ���� BufferedWriter ����
        System.out.println(sb);
    }
    //�ʺ� �켱 Ž���� �����ϴ� �Լ�
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();	//����� ť
        queue.add(start);	//���� ���� ť�� ����
        visited[start] = true;		//���� ���� �湮 Ȯ��
        result[start] = count++;	//���� ���� ����
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            Collections.sort(graph.get(cur));	//�������� ����
            //������ ���� Ž��
            for(int next : graph.get(cur)) {
                if(!visited[next]) {	//�湮���� �ʾҴ� ������
                    visited[next] = true;
                    result[next] = count++;
                    queue.add(next);
                }
            }
        }
    }

    private static void dfs(int vertex) {
        check[vertex] = count; // ���� �湮�ϰ��ִ� ������ ���� ����
        // ���� ��ġ�� ������ �� �� �ִ� ���� ����Ʈ�� ��ȸ
        //System.out.println("vertex " + vertex + "size : " + graph.get(vertex).size());
        for(int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            //���� �� ������ �湮�߾����� üũ(0�� ��� �湮 X)
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

 */