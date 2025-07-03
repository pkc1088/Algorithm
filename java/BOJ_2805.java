import java.io.*;
import java.util.*;
public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        // �ݵ�� max���� +1 ���̾�� �Ѵ�.
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            // ���� ������ �߰� ���̸� ���Ѵ�.
            mid = (max + min) / 2;

            long count = 0;
            // ������ �߰� ���̷� �߶� �� �� ���� ������������� ���Ѵ�.

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] - mid > 0)
                    count += arr[i] - mid;
            }
            /*
             *  [upper bound ����]
             *
             *  mid���̷� �߶��� ���� ������ ������� �ϴ� ������ �������� �۴ٸ�
             *  �ڸ����� �ϴ� ���̸� ���̱� ���� �ִ� ���̸� ���δ�.
             *  �� �ܿ��� �ڸ����� �ϴ� ���̸� �÷��� �ϹǷ� �ּ� ���̸� �ø���.
             */
            if(count < m) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        // UpperBound�� ����� ��(min)�� -1�� �ִ� ���̰� �ȴ�.
        System.out.println(min - 1);
    }
}
