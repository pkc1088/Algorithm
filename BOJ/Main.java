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
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        HashMap<String, Integer> hmSum = new HashMap<>();
        HashMap<int[], String> hmInd = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            hmSum.put(genres[i], hmSum.getOrDefault(genres[i], 0) + plays[i]);
            hmInd.put(new int[]{i, plays[i]}, genres[i]);
        }

        for(Map.Entry<String, Integer> str : hmSum.entrySet()) {
//            temp *= str.getValue() + 1;
        }

        System.out.println(hmSum);
        System.out.println();
        System.out.println(hmInd.entrySet());
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











