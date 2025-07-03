import java.io.*;
import java.util.*;

public class NDB_16_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                if(st.hasMoreTokens())
                    arr[i][j] = Integer.parseInt(st.nextToken());
                else
                    arr[i][j] = 0;
            }
        }
        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j==0)
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[N-1][i]);
        }
        System.out.println(result);
    }
}

