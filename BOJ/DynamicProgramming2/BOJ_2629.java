package BOJ.DynamicProgramming2;

import java.io.*;
import java.util.*;

public class BOJ_2629 {

    static int n;
    static int[] w;
    static boolean[][] result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = new int[n];
        result = new boolean[n + 1][40001];
        for (int i = 0; i < n; i++) {
            int src = Integer.parseInt(st.nextToken());
            w[i] = src;
        }

        dp(0,0);

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (result[n][t]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb.toString());
    }

    static void dp(int idx, int num) {
        if(result[idx][num]) return;
        result[idx][num] = true;

        if(idx == n	) return;

        dp(idx + 1, num + w[idx]);
        dp(idx + 1, num);
        dp(idx + 1, Math.abs(num - w[idx]));
    }
}