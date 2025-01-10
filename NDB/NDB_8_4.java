
import java.io.*;
import java.util.*;

public class NDB_8_4 {
    static int [] d = new int[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        d[0] = 1;

        for (int i = 1; i < n; i++) {
            d[i] = d[i-1] + 2;
        }

        System.out.println(d[n-1]);
    }
}
/*
import java.util.*;

public class NDB_8-4 {

    // �ռ� ���� ����� �����ϱ� ���� DP ���̺� �ʱ�ȭ
    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ���� N�� �Է¹ޱ�
        int n = sc.nextInt();

        // ���̳��� ���α׷���(Dynamic Programming) ����(���Ҿ�)
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        // ���� ��� ���
        System.out.println(d[n]);
    }
}
*/

