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

        W = new int[N + 1]; // ����
        V = new int[N + 1]; // ��ġ
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
        dp[p] = q : ���� p�� ������ �� �ִ� �ִ� ��ġ q
        */
        for (int i = 1; i < N + 1; i++) {  //4
            for (int j = 1; j < K + 1; j++) {  //7 -> j=1~7
                // i��° ���Ը� �� ���� �� ���� ���
                if (W[i] > j) { // �� j�� ���� ������� ������ �뷮��
                    dp[i][j] = dp[i - 1][j];    // �� �������� ���繰�� i�� �뷮���� ũ�� �������� ����
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
                // i��° ���Ը� �� ���� �� �ִ� ���
                // i�� ������ ������� i-1�������� ���Ե� j-w[i]��
                // �� dp[i-1][j-w[i]]������ ��Ȳ���� i�� ������ ��ƺ��ٴ� �ǹ̷�
                // v[i]�� ���ϴ°���. �̰� Math.max�� ���ϸ��
                // dp[2][4]�� ��� 2���� ������ ���� 4�� ����� ��Ȳ�� dp[2-1][4-w[2]] = dp[2-1][4-4]
                // = dp[1][0]�̰� �̰� ���� ���̴� 0�̸� ���⿡ 2��° ���ǰ�ġ V[2] = 8�� ���ϸ� 0+8��
                // dp[2][4]�� ������ ������ �̷�����°���
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