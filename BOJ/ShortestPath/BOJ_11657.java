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

        // 500 * 6000 * 10000이 int의 범위를 넘어감
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        // n - 1 번의 반복작업과 마지막 확인작업을 한 번에 돌림
        for(int i = 1 ; i <= n ; i ++) {
            for(Edge edge : edges) {
                // 한번도 들른적 없으면 패스
                // Long 최대값으로 초기화했기 때문에 이 작업 반드시 필요
                if(dist[edge.start] == Long.MAX_VALUE) continue;

                // 버스 도착점까지의 최소거리가 시작점 + 비용보다 크면 갱신
                if(dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;

                    // n번째 작업에서 값이 변경되면 무한히 되돌아 갈 수 있다는 뜻
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
        int v; // 나가는 정점
        int w; // 들어오는 정점
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    static ArrayList<Edge> graph;
    static final int INF = 1000000000;

    //정점의 개수, 간선의 개수, 출발지
    public static boolean BellmanFord(int n, int m, int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        //정점의 개수만큼 반복
        for (int i = 0; i < n; i++) {
            //간선의 개수만큼 반복
            for (int j = 0; j < m; j++) {
                Edge edge = graph.get(j); //현재 간선
                //현재 간선의 들어오는 정점에 대해 비교
                if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }
        //음수 가중치 확인
        for (int i = 0; i < m; i++) {
            Edge edge = graph.get(i); //현재 간선
            //현재 간선의 들어오는 정점에 대해 비교 -> 더 작은 값 생기면 음수 사이클 존재
            if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                System.out.println(-1);
                return false;
            }
        }
        //출력
        for (int i = 2; i < dist.length; i++) {
            if (dist[i] == INF) System.out.println(-1);
            else System.out.println(dist[i]);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        //그래프 입력받기
        st = new StringTokenizer(br.readLine(), " ");
        // 정점의 개수, 간선의 개수
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
        //벨만-포드 알고리즘 수행
        BellmanFord(n, m, 1);
    }
}
 */