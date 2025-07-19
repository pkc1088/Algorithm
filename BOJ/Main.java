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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // ÇÊ¼öÀÓ
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










