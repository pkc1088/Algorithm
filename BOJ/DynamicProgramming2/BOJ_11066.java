package BOJ.DynamicProgramming2;

import java.io.*;
import java.util.*;
/*
1. K�� 2���� ���� ��
DP[i][i] �� ��ġ�� 0�̰�
DP[i][j] �� V[i]�� V[j]�� ���̴�.

2. K�� 2���� Ŭ ��
V = {a, b, c}(K == 3)���
{a, b} / c �� ���� a / {b, c}�� ���� ������.
���� ������ 2���� ���� �� ��ġ�� �̵��ϸ鼭 �ּҰ��� ã�Ƴ���.
��, DP[1][3](K == 3)�� ���� �� DP[1][2] + DP[3][3]��
DP[1][1] + DP[2][3]�� �ּҰ��� ���ϸ� �ȴ�.
�̸� ����ȭ �غ���
DP[i][j] = DP[i][k] + DP[k+1][j] (��, i < k < j)

DP[1][2]�� A1,A2�� ������ �� �ּҺ��
DP[1][3]�� A1, A2, A3�� ������ �� �ּҺ��
DP[2][4]�� A2, A3, A4�� ������ �� �ּҺ������ ǥ���� �� �ֽ��ϴ�.

�ٸ� ���÷� A2, A3, A4�� �������ٸ�(���� 2~4)
(A2, A3), A4 : DP[2][3] + DP[4][4] + sum[4] - sum[1]
A2 , (A3, A4) : DP[2][2] + DP[3][4] + sum[4] - sum[1]
DP[j][i] = DP[i][s] + DP[s+1][j] + sum[i] - sum[j-1]
 */
public class BOJ_11066 {
    public static int[] sum = new int[501];		    //���� ��� �� ���� �迭
    public static int[][] DP = new int[501][501];	//j->i ��ġ�� �ּ� ��� ���� �迭
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
        for (int i = 2; i <= K; i++) {        //������ 2���� ����
            for (int j = i - 1; j >= 1; j--) {        //�����	i-1���� ����
                DP[j][i] = Integer.MAX_VALUE;
                for (int s = j; s < i; s++) {        //�߰����� j���� ����
                    DP[j][i] = Math.min(DP[j][i], DP[j][s] + DP[s + 1][i]);    //�ּҰ� ���ϱ�
                }
                DP[j][i] += sum[i] - sum[j - 1];        //����� ���ϱ�
            }
        }
    }
}