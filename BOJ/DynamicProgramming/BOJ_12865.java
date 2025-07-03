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
        i=1 -> w=6, v=13
        i=2 -> w=4, v=8
        i=3 -> w=3, v=6
        i=4 -> w=5, v=12
        dp[p] = q : 무게 p를 수용할 수 있는 최대 가치 q
        */
        for (int i = 1; i < N + 1; i++) {  //4
            for (int j = 1; j < K + 1; j++) {  //7 -> j=1~7
                // i번째 무게를 더 담을 수 없는 경우
                if (W[i] > j) { // 즉 j는 현재 고려중인 가방의 용량임
                    dp[i][j] = dp[i - 1][j];    // 즉 담으려는 현재물건 i가 용량보다 크니 이전상태 저장
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
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