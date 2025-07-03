import java.io.*;
import java.util.*;

public class BOJ_2482 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MOD = 1_000_000_003;

    static int n, k;
    static int[][] dp;
    //dp[i][j] = k -> i���� ���� ���� �� j���� ���� ������ �� �ִ� ����� �� = k
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            // i�� �߿��� 1���� �����ϴ� ����� i���̴�.
            dp[i][1] = i;

            // 0���� ������ ���� 1�� �ʱ�ȭ�Ѵ�.
            // ��ȭ���� ���ؼ��� 1�� �ʱ�ȭ�ؾ��Ѵ�.
            dp[i][0] = 1;
        }

        // i�� 3�̸��� ���� ����� �ʿ䰡 ����.
        for(int i = 3; i <= n; i++){
            // n���� �� �� n/2�� ���� �� ���� ���� ���� 0�����̴�.
            // �׷��� ������ j�� ������ ������ ���� �����Ѵ�.
            for(int j = 2; j <= (i + 1) / 2; j++){
                // i��° ���� �������� ���� ��� + i��° ���� ������ ���
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        // n��° ���� ������ ��� + n��° ���� �������� ���� ���
        bw.write((dp[n - 3][k - 1] + dp[n - 1][k]) % MOD + "\n");
        bw.close();
        br.close();
    }

}
