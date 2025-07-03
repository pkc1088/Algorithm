package BOJ.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10844 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[][] dpp;
    static int[] dp;
    static int[][] arr;
    static boolean[][] visited;
    static int n, a, b, c, ans, cnt = 0;
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        long mod = 1000000000;
        long[][] dp = new long[N + 1][10];

        // ù ��° �ڸ����� ������ �� ���� �ڸ����̹Ƿ� ����� ���� 1���ۿ� ����
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // �� ��° �ڸ������� N���� Ž��
        for(int i = 2; i <= N; i++) {

            // i��° �ڸ����� �ڸ������� Ž�� (0~9)
            for(int j = 0; j < 10; j++) {

                // j=0, �� �ڸ����� 0�̶�� ���� �ڸ����� ù��° �ڸ����� ����
                if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                // j=9��� ���� �ڸ����� 8�� ����
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }
                // �� ���� ��� ���� �ڸ����� �ڸ��� +1, -1 �� ���� ��
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long result = 0;

        // �� �ڸ��������� ����� ���� ��� �����ش�.
        for(int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % mod);
    }

}
