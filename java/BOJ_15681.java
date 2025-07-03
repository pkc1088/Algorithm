import java.io.*;
import java.util.*;

public class BOJ_15681 {
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        dp = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        makeTree(R, -1);

        for(int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            System.out.println(dp[q]);
        }

    }

    public static int makeTree(int cur, int parent) {
        if(dp[cur] != 0)
            return dp[cur];

        dp[cur] = 1;

        for(int child : graph.get(cur)) {
            if(child != parent) {
                dp[cur] += makeTree(child, cur);
            }
        }

        return dp[cur];
    }

}
