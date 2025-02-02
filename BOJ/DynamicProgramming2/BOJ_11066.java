package BOJ.DynamicProgramming2;

import java.io.*;
import java.util.*;
/*
1. K가 2보다 작을 때
DP[i][i] 의 가치는 0이고
DP[i][j] 는 V[i]와 V[j]의 합이다.

2. K가 2보다 클 때
V = {a, b, c}(K == 3)라면
{a, b} / c 의 경우와 a / {b, c}의 경우로 나뉜다.
길이 내에서 2개씩 묶어 그 위치를 이동하면서 최소값을 찾아낸다.
즉, DP[1][3](K == 3)을 구할 때 DP[1][2] + DP[3][3]과
DP[1][1] + DP[2][3]중 최소값을 구하면 된다.
이를 수식화 해보면
DP[i][j] = DP[i][k] + DP[k+1][j] (단, i < k < j)

DP[1][2]는 A1,A2를 합쳤을 때 최소비용
DP[1][3]은 A1, A2, A3를 합쳤을 때 최소비용
DP[2][4]는 A2, A3, A4를 합쳤을 때 최소비용으로 표현할 수 있습니다.

다른 예시로 A2, A3, A4가 합쳐진다면(범위 2~4)
(A2, A3), A4 : DP[2][3] + DP[4][4] + sum[4] - sum[1]
A2 , (A3, A4) : DP[2][2] + DP[3][4] + sum[4] - sum[1]
DP[j][i] = DP[i][s] + DP[s+1][j] + sum[i] - sum[j-1]
 */
public class BOJ_11066 {
    public static int[] sum = new int[501];		    //파일 비용 합 저장 배열
    public static int[][] DP = new int[501][501];	//j->i 합치는 최소 비용 저장 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= K; j++) {
                sum[j] = sum[j - 1] + Integer.parseInt(st.nextToken());
            }
            fileMerge(K);
            bw.write(DP[1][K] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void fileMerge(int K) {
        for (int i = 2; i <= K; i++) {        //목적지 2부터 시작
            for (int j = i - 1; j >= 1; j--) {        //출발지	i-1부터 시작
                DP[j][i] = Integer.MAX_VALUE;
                for (int s = j; s < i; s++) {        //중간지점 j부터 시작
                    DP[j][i] = Math.min(DP[j][i], DP[j][s] + DP[s + 1][i]);    //최소값 정하기
                }
                DP[j][i] += sum[i] - sum[j - 1];        //비용합 더하기
            }
        }
    }
}