package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[][] dp, arr;
    static boolean[][] visited;
    static int n, a, b, c, ans;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        arr = new int[n + 1][n + 1]; // R0, G1, B2

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // scan range : arr[i][j] <- arr[i+1][j] & arr[i+1][j+1]
        /*for (int i = 1; i <= n; i++) {
            dp[n][i] = arr[n][i];
        }*/

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - 1; j++) {
                arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]);
            }
        }
        // 7같은 경우 위쪽 중 오른쪽 8로 부터 받는것과 위쪽 중 왼쪽 1로 부터 받는 것 중 결정하면 됨
        System.out.println(arr[1][1]);
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//System.out.println("dp["+i+"] = "+dp[i]);












