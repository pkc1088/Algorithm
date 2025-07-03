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
         * ��ȭ��
         * dp[i][j] = i���� j����� ��ġ�� ���
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
             * dp[i][i+2] ��
             * dp[i][i] + dp[i+1][i+2] + (novel[i]  + novel[i + 1] + novel[i + 2])
             * dp[i][i+1] + dp[i + 2][i + 2] + (novel[i] + novel[i + 1] + novel[i + 2])
             * �� ���� ��
             * dp[i][j] ��
             * divide �� i + 1 ���� �����ؼ� j - 1���� ��ȸ�ϸ鼭 ��������
             * dp[i][i + divide] + dp[divide + 1][j] + sum(i���� j���� �κ���) �� �� ���̴�.
             */
            for (int size = 1; size <= k; size++) {
                for (int from = 1; from + size <= k; from++) {  // �κ� ���� ���� �ε���
                    int to = from + size; // �κ� ���� �� �ε��� (�� ���̰� size�� �κ� ������ ��� �������� ����)
                    // �� size�� 2�� �κ������� ����ҋ� from�� 3�̸� ��ġ�� �κ��� [from~to]�� [3~4]�̴�.
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        //[from ~ divide]�� [divide+1 ~ to]�� ������, ������ ��ġ�� ����� ã��
                        dp[from][to] = Math.min(dp[from][to],
                                dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                        // �� �� �ɰ��°Ͱ� �ɰ��°� ���� �ּҰ��� ����
                        // ���� from = 1, to = 3, divide = 1�̸� dp[1][1] + dp[2][3] + (sum[3]-sum[0]) �̰Ŷ�
                        // dp[1][3]�� ���ؼ� ����
                    }
                }
            }
            System.out.println(dp[1][k]);
        }
    }
}