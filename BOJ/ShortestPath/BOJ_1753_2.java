package BOJ.ShortestPath;

import java.io.*;
import java.util.*;

public class BOJ_1753_2 {
    static int v, e, start;
    static int[] optDistance;
    static int max = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        optDistance = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(optDistance, max);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, weight});
        }

        optDistance[start] = 0;
        dijk();
        for (int i = 1; i < v + 1; i++) {
            System.out.println(optDistance[i] == max ? "INF" : String.valueOf(optDistance[i]));
        }
    }

    public static void dijk() {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{start, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_node = cur[0];
            int cur_weight = cur[1];

            if(optDistance[cur_node] < cur_weight) continue;

            for (int[] dto : graph.get(cur_node)) {
                int des_node = dto[0];
                int via_weight = dto[1];

                if (optDistance[des_node] > cur_weight + via_weight) {
                    optDistance[des_node] = cur_weight + via_weight;
                    q.offer(new int[]{des_node, optDistance[des_node]});
                }
            }

        }


    }
}