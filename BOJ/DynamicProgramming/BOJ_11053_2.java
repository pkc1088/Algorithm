package BOJ.DynamicProgramming;

import java.io.*;
import java.util.*;

public class BOJ_11053_2 {

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max_length = dp[1]; // 가장 긴 수열의 길이를 저장할 변수 (최소 1 보장)

        // DP 바텀업 탐색 (현재 기준점 i)
        for (int i = 2; i <= n; i++) {
            // 과거 탐색 (j는 1부터 i 바로 앞까지)
            for (int j = 1; j < i; j++) {
                // 내 앞의 숫자(arr[j])가 현재 숫자(arr[i])보다 작다면 뒤에 이어붙일 자격이 됨!
                if (arr[j] < arr[i]) {
                    // 현재 내 길이(dp[i])와 과거의 길이 + 나 자신(dp[j] + 1) 중 더 긴 값으로 갱신
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 매 i번째 탐색이 끝날 때마다, 전체 수열 중 최대 길이를 갱신해줍니다.
            max_length = Math.max(max_length, dp[i]);
        }

        // 3. 마지막 숫자로 끝나는 경우가 무조건 정답이 아닐 수 있으므로, 전체 배열 중 최댓값을 출력합니다.
        System.out.println(max_length);
    }
}
