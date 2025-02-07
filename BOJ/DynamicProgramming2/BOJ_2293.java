package BOJ.DynamicProgramming2;
import java.io.*;
import java.util.*;

public class BOJ_2293 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;  // 0���� ����� ����� 1���� (�ƹ� ������ ������� �ʴ� ���)

        for(int i = 1 ; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= k; j++)
                dp[j] += dp[j - arr[i]];
        }

        System.out.println(dp[k]);
    }

}
