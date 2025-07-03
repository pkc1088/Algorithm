package BOJ.DivideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken()); // �� ����
        long b = Long.parseLong(st.nextToken()); // ����
        long c = Long.parseLong(st.nextToken()); // ������
        System.out.println(remainder(a, b, c));
    }

    private static long remainder(long a, long b, long c) {
        // ������ 1�̸� �ٷ� ������ ���ϱ�.
        if (b == 1) {
            return a % c;
        }
        // ������ 1 �̻��̸� ������ ������ ������ �ٽ� ������ ���ϱ�.
        else {
            long halfVal = remainder(a, b / 2, c);
            // ������ Ȧ���� ��
            // (10^11) % 12 = (10^5 x 10^6) % 12 �� ((10^5 x 10^5) % 12) x (10^1 % 12)
            if (b % 2 == 1) {
                return (halfVal * halfVal % c) * a % c;
            }
            // ������ ¦���� ��
            return halfVal * halfVal % c;
        }
    }
}