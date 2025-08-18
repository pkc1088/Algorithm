package BOJ.Math;

class NBCAT5 {
    int solution(int[][] land) {
        int r = land.length; // 3
        int c = land[0].length; // 4
        int dp[][] = new int[r][c];

        for(int i = 0; i < c; i++)
            dp[0][i] = land[0][i];

        for(int i = 1; i < r; i++) {
            for(int j = 0; j < c; j++) {

                int before = -1;
                for(int k = 0; k < c; k++) {
                    if(k == j) continue;
                    before = Math.max(before, dp[i-1][k]);
                }

                dp[i][j] = before + land[i][j];
            }
        }

        int ans = dp[r-1][0];
        for(int i = 1; i < c; i++) {
            ans = Math.max(ans, dp[r-1][i]);
        }

        return ans;
    }
}