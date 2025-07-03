package BOJ.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static boolean[] visit;
    static int N, M, nc, mc, cnt = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];

        dfs(0);
        System.out.println(sb);
        //System.out.println(arr.length + " " + N+" "+M);

    }
    public static void dfs(int dp) {
        if(dp == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                arr[dp] = i + 1;
                visit[i] = true;
                dfs(dp + 1);
                visit[i] = false;
            }
        }
    }

    public static void print() throws IOException {

    }
}