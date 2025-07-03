package BOJ.DynamicProgramming2;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    public static void main(String[] args) throws Exception {
        int t;
        /**
         * memoization dp
         * 점화식
         * dp[i][j] = i부터 j장까지 합치는 비용
         * dp[i][i] = novel[i]
         * dp[i][i + 1] = novel[i] + novel[i+1]
         */
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int k;
            int[] novel;
            int[] sum;
            int[][] dp;

            k = Integer.parseInt(br.readLine());
            novel = new int[k + 1];
            dp = new int[k + 1][k + 1];
            sum = new int[k + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < k + 1; i++) {
                novel[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + novel[i];
            }
            /*
             * dp[i][i+2] 는
             * dp[i][i] + dp[i+1][i+2] + (novel[i]  + novel[i + 1] + novel[i + 2])
             * dp[i][i+1] + dp[i + 2][i + 2] + (novel[i] + novel[i + 1] + novel[i + 2])
             * 중 작은 거
             * dp[i][j] 는
             * divide 가 i + 1 부터 시작해서 j - 1까지 순회하면서 비교했을때
             * dp[i][i + divide] + dp[divide + 1][j] + sum(i부터 j까지 부분합) 이 될 것이다.
             */
            for (int size = 1; size <= k; size++) {
                for (int from = 1; from + size <= k; from++) {  // 부분 파일 시작 인덱스
                    int to = from + size; // 부분 파일 끝 인덱스 (즉 길이가 size인 부분 파일을 어디서 시작할지 결정)
                    // 즉 size가 2인 부분파일을 고려할떄 from이 3이면 합치는 부분은 [from~to]인 [3~4]이다.
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        //[from ~ divide]와 [divide+1 ~ to]로 나누고, 최적의 합치는 비용을 찾음
                        dp[from][to] = Math.min(dp[from][to],
                                dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                        // 즉 안 쪼개는것과 쪼개는것 사이 최소값을 저장
                        // 만약 from = 1, to = 3, divide = 1이면 dp[1][1] + dp[2][3] + (sum[3]-sum[0]) 이거랑
                        // dp[1][3]을 비교해서 고른다
                    }
                }
            }
            System.out.println(dp[1][k]);
        }
    }
}