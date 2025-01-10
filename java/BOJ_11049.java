import java.util.*;
import java.io.*;
public class BOJ_11049 {
    public static int [][] a;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    public static int solution(){
        int size = a.length;
        int dp[][] = new int[size][size];

        for(int i = 0; i < size - 1; i++)
            dp[i][i+1] += a[i][0] * a[i][1] * a[i+1][1];


        for(int gap = 2; gap < size; gap++){
            for(int i = 0; i + gap < size; i++){
                int j = i+gap;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++)
                    dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + a[i][0] * a[k][1] * a[j][1],
                                        dp[i][j]);
            }
        }

        return dp[0][a.length-1];
    }
}

/* 재귀적 방법
public class Q11049 {
    static int [][] a;
    static int [][] dp;

    public static int solve( int start, int end) {
        if(start == end) return 0;
        if(dp[start][end]!= Integer.MAX_VALUE) {
            return dp[start][end];
        }
        for(int i=start; i<end; i++) {
            int cost = solve(start, i)+solve(i+1, end)+ a[start][0] * a[i][1] * a[end][1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
        return dp[start][end];
    }

    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        a = new int[n][2];
        dp = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(solve(0, n-1));
    }
}

 */
