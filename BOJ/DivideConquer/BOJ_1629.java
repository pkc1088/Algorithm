package BOJ.DivideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1629 {

    public static long C;
    public static int num = 0, finish = 0;
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
        System.out.println("go in : " + (++num) + ", A : " + A + ", EXP : " + exponent);
        // ������ 1�� ��� A^1 �̹Ƿ� A�� �״�� ����
        if(exponent == 1) {
            System.out.println("EXP == 1 out : " + (++finish) + ", EXP : " + exponent + ", return : " + (A % C));
            return A % C;
        }
        //10 11 12
        // A  B  C
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
            System.out.println("odd out : " + (++finish) + ", temp : " + temp + ", EXP : " + exponent + ", return : " + (temp * temp % C) * A % C);
            return (temp * temp % C) * A % C;
        }
        System.out.println("even out : " + (++finish) + ", temp : " + temp + ", EXP : " + exponent + ", return : " + temp * temp % C);
        return temp * temp % C;
    }

}