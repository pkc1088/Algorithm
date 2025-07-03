import java.io.*;
import java.util.*;

public class NDB_8_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[M + 1];
        Arrays.fill(d, 10001);

        // ���̳��� ���α׷���(Dynamic Programming) ����(���Ҿ�)
        d[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= M; j++) {
                // (i - k)���� ����� ����� �����ϴ� ���
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }

        // ���� ��� ���
        if (d[M] == 10001) { // ���������� M���� ����� ����� ���� ���
            System.out.println(-1);
        }
        else {
            System.out.println(d[M]);
        }
    }
}

