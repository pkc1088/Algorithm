package BOJ.DynamicProgramming;
// "Á¤¼ö »ï°¢Çü"

class PG2 {
    int[][] dp;
    public int solution(int[][] triangle) {
        int len = triangle.length;
        dp = new int[len][len];

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else if(j == i) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                dp[i][j] += triangle[i][j];
            }
        }

        int ans = -1;
        for(int i = 0; i < len; i++) {
            ans = Math.max(ans, dp[len - 1][i]);
        }
        return ans;
    }
}
/*
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
*/