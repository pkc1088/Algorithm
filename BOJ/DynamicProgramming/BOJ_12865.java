package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_12865 {
    static int[] W, V;
    static int[][] dp;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N + 1]; // 무게
        V = new int[N + 1]; // 가치
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        /*
        dp[i][j]: 1번부터 i번째 물건까지만 탐색 후보로 두었을 때,
        배낭의 최대 허용 용량이 j라면 얻을 수 있는 최대 가치
        */
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                // i번째 무게를 용량 초과로, 더 담을 수 없는 경우
                if (W[i] > j) {
                    // 안 넣는 대신, 이 물건을 고려하기 전인 i-1번째 물건까지의 용량 j에서 챙겼던 최대 가치
                    // dp[i-1][j]를 그대로 물려받음
                    dp[i][j] = dp[i - 1][j];
                }

                else {
                    dp[i][j] = Math.max(
                            // 이번 물건 안 담고, 기존 다른 물건들로 용량 j 채웠던 가치 유지
                            dp[i - 1][j],
                            // 이번 물건 넣으려면 W[i] 만큼 공간 필요하니까,
                            // i-1 탐색하던 과거 시점에서 용량을 딱 j-W[i] 까지만 채웠을때의
                            // 최고 가치 가져오고 거기에 현재 물건의 가치 V[i] 더해줌.
                            dp[i - 1][j - W[i]] + V[i]);
                }
                // i번째 무게를 더 담을 수 있는 경우
                // i번 물건을 담기전인 i-1상태이자 무게도 j-w[i]인
                // 즉 dp[i-1][j-w[i]]에서의 상황에서 i번 물건을 담아본다는 의미로
                // v[i]를 더하는거임. 이걸 Math.max로 비교하면됨
                // dp[2][4]의 경우 2번쨰 물건인 무게 4를 담기전 상황이 dp[2-1][4-w[2]] = dp[2-1][4-4]
                // = dp[1][0]이고 이건 범위 밖이니 0이며 여기에 2번째 물건가치 V[2] = 8을 더하면 0+8로
                // dp[2][4]에 최초의 셋팅이 이루어지는거임
            }
        }
        print();
        System.out.println(dp[N][K]);
    }

    public static void print() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}