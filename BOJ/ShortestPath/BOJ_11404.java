package BOJ.ShortestPath;

import java.io.*;
import java.util.*;

public class BOJ_11404 {
    static final int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, INF = Integer.MAX_VALUE;
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
    static int[] dp, brr, arr, check, result, color;
    static int[] rx = {-1, 1,  0, 0};
    static int[] ry = { 0, 0, -1, 1};
    static int tc, n, m, v, e, h, r, k, a, b, c, count, ans, cnt, sum;

    static class Node{
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static int city, bus;
    public static void main(String[] args) throws IOException {
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        long[][] dist = new long[city + 1][city + 1];
        for (int i = 1; i < city + 1; i++) {
            for (int j = 1; j < city + 1; j++) {
                dist[i][j] = INF;
                if(i == j) dist[i][i] = 0;
            }
        }

        for (int i = 1; i < bus + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(dist[from][to], weight);
        }

        for (int l = 1; l < city + 1; l++) {
            for (int i = 1; i < city + 1; i++) {
                for (int j = 1; j < city + 1; j++) {
                    if(dist[i][j] > dist[i][l] + dist[l][j]) {
                        dist[i][j] = dist[i][l] + dist[l][j];
                    }
                }
            }
        }

        for (int i = 1; i < city + 1; i++) {
            for (int j = 1; j < city + 1; j++) {
                if (dist[i][j] == INF) {
                    dist[i][j] = 0;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}

