package BOJ;

import java.util.*;
import java.io.*;

public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
//    // static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//    // static PriorityQueue<Integer> pq = new PriorityQueue<>();
//    static Map<Integer, Integer> map = new HashMap<>();
//    static StringBuilder sb = new StringBuilder();
//    static List<int[]> list = new ArrayList<>();
//    static Queue<int[]> q = new LinkedList<>();
//    static int max = Integer.MIN_VALUE;
//    static int min = Integer.MAX_VALUE;
//    static int n, m, h, r, v, e, t, k, l, s, cnt, ans;
//    static int[] dr = {-1, 0, 1, 0};
//    static int[] dc = {0, 1, 0, -1};
//    static StringTokenizer st;
//    static boolean[] visit;
//    static int[] arr, brr;
//    static int[][] crr;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static int[] dp, arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        //dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        for (int i = 3; i < n + 1; i ++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
//                    Math.max(dp[i - 3] + arr[i - 1] + arr[i],
//                            dp[i - 2] + arr[i]));
        }

        System.out.println(dp[n]);
        /*
        dp[i]: i 계단 까지 오는 최대값.
        1. 직전 두 계단 밟았으면 무조건 2칸 점프
        2. 직전 계단 밟았으면 지금꺼 밟을 수 있음
        3. (1 0 1) 가능, (0 1 1) 가능
        4. 가능: (1 1 0 1), (1 0 1 1), (0 1 0 1),
        5. 불가능: (0 0 1 1)

         */
    }

/*
    public static void dfs(int node, StringBuilder sb) {

        sb.append(node).append(" ");
        visit[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            int nxtNode = graph.get(node).get(i);
            if(!visit[nxtNode]) {
                dfs(nxtNode, sb);
            }
        }

    }

    public static void bfs(int start) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        sb.append(start).append(" ");
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int next = q.poll();
            for(int i = 0; i < graph.get(next).size(); i++) {
                int nxtNode = graph.get(next).get(i);
                if(!visit[nxtNode]) {
                    sb.append(nxtNode).append(" ");
                    visit[nxtNode] = true;
                    q.offer(nxtNode);
                }
            }
        }

        System.out.println(sb.toString());
    }
*/

}











