package BOJ.DivideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_10830 {

    final static int MOD = 1000;
    public static int N;
    public static int[][] origin;	// A^1 �� ���� �迭(�ʱ� �迭)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());	// Ÿ�� ����

        origin = new int[N][N];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {

                /*
                 * B=1 �� ���� pow�������� �ٷ� A�� ��ȯ �� �� �ִ�.
                 * �� ���� ��� ���� ���Ұ� 1000�̻��� ��� pow�޼ҵ忡�� ��ⷯ������
                 * ������� �ʱ� ������ ������ �Ǿ������.
                 *
                 * �̸� �����ϱ� ���� �ʱ� ��Ŀ��� 1000���� ���� ������ ������
                 * �ʱ�ȭ�� ���ش�.
                 */
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, B);


        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }


    // ��� ���� �������� �޼ҵ�
    public static int[][] pow(int[][] A, long exp) {

        // ������ 1�� �� A�� return�Ѵ�.
        if(exp == 1L) {
            return A;
        }

        // ������ �������� �����Ͽ� ���ȣ��
        int[][] ret = pow(A, exp / 2);

        // ���� ��Ϳ��� ���� ����� �������ش�.
        ret = multiply(ret, ret);

        // ���� ������ Ȧ����� ��������  A^1 (origin)�� �����ش�.
        if(exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }

        return ret;
    }


    // o1�� o2 ����� �����ִ� �޼ҵ�
    public static int[][] multiply(int[][] o1, int[][] o2) {

        int[][] ret = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {

                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;	// ��� ���� ������ ������ MOD�� ����������
                }
            }
        }
        return ret;
    }
}