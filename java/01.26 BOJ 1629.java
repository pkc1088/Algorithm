import java.io.*;
import java.util.*;

public class Main {

    public static long C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    // A^exponent
    public static long pow(long A, long exponent) {

        // ������ 1�� ��� A^1 �̹Ƿ� A�� �״�� ����
        if(exponent == 1) {
            return A % C;
        }

        // ������ ���ݿ� �ش��ϴ� A^(exponent / 2) �� ���Ѵ�.
        long temp = pow(A, exponent / 2);

        /*
         * ���� ������ Ȧ �� ���ٸ�
         * A^(exponent / 2) * A^(exponent / 2) * A �̹Ƿ�
         * A�� �� �� �� �����־�� �Ѵ�.
         *
         * ex) A^9 = A^4 * A^4 * A
         */
        if(exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;

    }

}
