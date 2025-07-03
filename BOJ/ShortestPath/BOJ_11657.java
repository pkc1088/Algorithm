package BOJ.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657 {
    static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add( new Edge(start, end, cost) );
        }

        // 500 * 6000 * 10000�� int�� ������ �Ѿ
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        // n - 1 ���� �ݺ��۾��� ������ Ȯ���۾��� �� ���� ����
        for(int i = 1 ; i <= n ; i ++) {
            for(Edge edge : edges) {
                // �ѹ��� �鸥�� ������ �н�
                // Long �ִ밪���� �ʱ�ȭ�߱� ������ �� �۾� �ݵ�� �ʿ�
                if(dist[edge.start] == Long.MAX_VALUE) continue;

                // ���� ������������ �ּҰŸ��� ������ + ��뺸�� ũ�� ����
                if(dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;

                    // n��° �۾����� ���� ����Ǹ� ������ �ǵ��� �� �� �ִٴ� ��
                    if(i == n) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        for(int i = 2 ; i <= n ; i ++) {
            if(dist[i] == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
/*
package BOJ;

import java.io.*;
import java.util.*;
import static java.lang.System.exit;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;

    static class Edge {
        int v; // ������ ����
        int w; // ������ ����
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    static ArrayList<Edge> graph;
    static final int INF = 1000000000;

    //������ ����, ������ ����, �����
    public static boolean BellmanFord(int n, int m, int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        //������ ������ŭ �ݺ�
        for (int i = 0; i < n; i++) {
            //������ ������ŭ �ݺ�
            for (int j = 0; j < m; j++) {
                Edge edge = graph.get(j); //���� ����
                //���� ������ ������ ������ ���� ��
                if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }
        //���� ����ġ Ȯ��
        for (int i = 0; i < m; i++) {
            Edge edge = graph.get(i); //���� ����
            //���� ������ ������ ������ ���� �� -> �� ���� �� ����� ���� ����Ŭ ����
            if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                System.out.println(-1);
                return false;
            }
        }
        //���
        for (int i = 2; i < dist.length; i++) {
            if (dist[i] == INF) System.out.println(-1);
            else System.out.println(dist[i]);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        //�׷��� �Է¹ޱ�
        st = new StringTokenizer(br.readLine(), " ");
        // ������ ����, ������ ����
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge(v, w, cost));
        }
        //����-���� �˰��� ����
        BellmanFord(n, m, 1);
    }
}
 */