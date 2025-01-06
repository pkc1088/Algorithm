import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // x�� lo <= x <= hi �� ������ ���´�.
        long lo = 1;
        long hi = K;

        // lower-bound
        while(lo < hi) {

            long mid = (lo + hi) / 2;	// ������ x(mid)�� �߰� ������ ��´�.
            long count = 0;

            /*
             *  ������ x�� ���� i�� ° ���� �������ν� x���� �۰ų� ���� ������ ����
             *  ���� ���� ���Ѵ�.
             *  �� �� �� ���� ������ ������ N(�� ����)�� �ʰ����� �ʴ� ������ �����־�� �Ѵ�.
             */
            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            // count�� ���ٴ� ���� ������ x(mid)���� ���� ���� B[K]���� ���ٴ� ��
            if(K <= count) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}
