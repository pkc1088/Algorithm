package BOJ.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15652 {

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
        if (depth == m + 1) {
            for (int i = 1; i < m + 1; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if(arr[depth - 1] <= i) {
                arr[depth] = i;
                dfs(depth + 1);
            }
        }
    }
}


//public class BOJ_15652 {
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
//        dfs(1, 0);
//        System.out.println(sb);
//        //System.out.println(arr.length + " " + N+" "+M);
//
//    }
//
//    public static void dfs(int at, int depth) {
//
//        if (depth == M) {
//            for (int val : arr) {
//                sb.append(val).append(' ');
//            }
//
//            sb.append('\n');
//            return;
//        }
//
//        for (int i = at; i <= N; i++) {
//            arr[depth] = i;
//            dfs(i, depth + 1);
//        }
//    }
//}

