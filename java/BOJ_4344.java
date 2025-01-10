import java.io.EOFException;
import java.util.*;

import static java.lang.System.exit;

public class BOJ_4344 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            double avg = 0;
            int cnt = 0;
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
                avg += arr[j];
            }
            avg /= N;

            for (int j = 0; j < N; j++) {
                if(arr[j]>avg)
                    cnt++;
            }
            System.out.printf("%.3f%%\n", (double)cnt/N*100);
        }
    }
}
