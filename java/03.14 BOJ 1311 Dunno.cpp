import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 99999999;
    static int N, K = 1, T = 1;
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];
        System.out.println(3 & (1<<1));

        bw.write(bfs(0, 0) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int now, int flag) {
        System.out.println("K : "+K+", now : "+now+", flag : "+flag);
        K++;

        if (now == N)
            return 0;
        if (dp[now][flag] != 0)
            return dp[now][flag];

        int result = INF;
        for (int i = 0; i < N; i++) {
            System.out.println("flag & (1<<i)  :  "+ (flag&(1<<i)));

            if ((flag & (1 << i)) == 0) {
                result = Math.min(result,
                        cost[now][i] + bfs(now + 1, flag | (1 << i)));
                System.out.println("result : "+result);
            }
        }
        dp[now][flag] = result;

        return dp[now][flag];
    }
}
