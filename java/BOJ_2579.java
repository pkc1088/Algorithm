import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N + 1];
        int[] arr = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // index = 0 은 시작점이다.
        DP[1] = arr[1];

        // N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
        if (N >= 2) {
            DP[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            DP[i] = Math.max(DP[i - 2] , DP[i - 3] + arr[i - 1]) + arr[i];
        }
        System.out.println(DP[N]);
    }
}

/*error
import java.io.*;
import java.util.*;

public class BOJ_2579 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] steps = new int[N];
        boolean[][] bVisited = new boolean[N][2];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
            bVisited[i][0] = false;
            bVisited[i][1] = false;
        }

        dp[0][0] = steps[0]; dp[1][0] = steps[0]+steps[1];
        dp[0][1] = 0;        dp[1][1] = steps[1];
        for (int i = 2; i < N; i++) {
            if(bVisited[i-2][0] && bVisited[i-1][0]) {
                dp[i][0] = dp[i-1][0]+steps[i];
            }

            else if(!bVisited[i-1][0]) {
                dp[i][0] = dp[i-2][0]+steps[i];
            }

            else {
                dp[i][0] = Math.max(dp[i-1][0]+steps[i], dp[i-2][0]+steps[i]);
                bVisited[i][0] = true;
            }
        }
        for (int i = 2; i < N; i++) {
            if(bVisited[i-2][1] && bVisited[i-1][1])
                continue;

            else if(!bVisited[i-1][1]) {
                dp[i][1] = dp[i-2][1]+steps[i];
            }

            else {
                dp[i][1] = Math.max(dp[i-1][1]+steps[i], dp[i-2][1]+steps[i]);
                bVisited[i][1] = true;
            }
        }

        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
    }
}
*/
