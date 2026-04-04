package BOJ.DynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ_2156_2 {

    static int n;
    static int[] glass;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        glass = new int[n + 1];
        dp = new int[n + 1];
        glass[0]= dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            glass[i] = Integer.parseInt(br.readLine());
        }
        // *6, *10, 13, *9, *8, 1
        dp[1] = glass[1];
        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = dp[1] + glass[2];
        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(Math.max(
                    dp[i - 1],
                    dp[i - 2] + glass[i]),
                    dp[i - 3] + glass[i - 1] + glass[i]
            );
        }

        System.out.println(dp[n]);
        // System.out.println(Arrays.stream(dp).boxed().toList());
    }
}
