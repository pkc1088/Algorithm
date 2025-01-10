import java.util.*;
import java.io.*;
//D[n][k] : n번째 숫자나사가 k번 왼쪽 회전한 상태
public class BOJ_13392 {
    public static int N;
    public static int a[];
    public static int b[];
    public static int dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 3
        a = new int[10001];
        b = new int[10001];
        dp = new int[10001][10];

        String str = br.readLine();
        for (int i = 0; i < N; i++)
            a[N-i] = str.charAt(i) - '0'; // 6(1)2(2)3(3)
        str = br.readLine();
        for (int i = 0; i < N; i++)
            b[N-i] = str.charAt(i) - '0'; // 6(1)4(2)4(3)

        for (int i = 1; i <= N; i++) {    // 123
            for (int j = 0; j < 10; j++)  // 0123456789
                dp[i][j] = dp[i - 1][j] + (a[i] - b[i] - j + 20) % 10;
            for (int j = 1; j < 20; j++)  // 1....19
                dp[i][j % 10] = Math.min(dp[i][j % 10], dp[i][(j - 1) % 10] + 1);
        }
        System.out.println(dp[N][0]);

        for (int i = 1; i <= N; i++) {    // 123
            for (int j = 0; j < 10; j++)  // 0123456789
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }

    }
}
