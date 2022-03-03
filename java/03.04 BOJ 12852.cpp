import java.io.*;
import java.util.*;
public class Main {
    public static int[] d = new int[(int) Math.pow(10, 6) + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            // ������ ������ 1�� ���� ���
            d[i] = d[i - 1] + 1;
            // ������ ���� 2�� ������ �������� ���
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // ������ ���� 3���� ������ �������� ���
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
        }

        System.out.println(d[n]);
        for (int i = n; i > 0; ) {
            System.out.print(i+" ");

            if(i%3==0 && d[i/3] < d[i]) {
                i/=3;
            }
            else if(i%2==0 && d[i/2] < d[i]) {
                i/=2;
            }
            else{
                i--;
            }

        }
    }
}
