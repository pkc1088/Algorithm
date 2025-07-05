package BOJ.BackTracking;

import java.util.*;
import java.io.*;

public class BOJ_15649 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 4
        m = Integer.parseInt(st.nextToken()); // 2

        arr = new int[m + 1];
        visited = new boolean[n + 1];

        dfs(1);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == m + 1) {
            for (int i = 1; i < m + 1; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

//public class BOJ_15649 {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
//    static int[] arr;
//    static boolean[] visit;
//    static int N, M, nc, mc, cnt = 0;
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        arr = new int[M];
//        visit = new boolean[N];
//
//        dfs(0);
//        System.out.println(sb);
//        //System.out.println(arr.length + " " + N+" "+M);
//
//    }
//    public static void dfs(int dp) {
//        if(dp == M) {
//            for (int val : arr) {
//                sb.append(val).append(' ');
//            }
//            sb.append('\n');
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            if (!visit[i]) {
//                arr[dp] = i + 1;
//                visit[i] = true;
//                dfs(dp + 1);
//                visit[i] = false;
//            }
//        }
//    }
//
//    public static void print() throws IOException {
//
//    }
//}