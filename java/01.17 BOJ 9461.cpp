import java.io.*;
import java.util.*;

public class Main {
    static long[] dp = new long[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1; dp[1] = 1; dp[2] = 1;
        for (int i = 3; i < 100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(dp[arr[i]-1]);
        }
    }
}
