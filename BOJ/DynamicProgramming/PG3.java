package BOJ.DynamicProgramming;
// "등굣길"

class PG3 {

    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        boolean[][] blocked = new boolean[n+1][m+1];

        // 물웅덩이 표시
        for (int[] p : puddles) {
            blocked[p[1]][p[0]] = true;
            // puddles는 [x,y] 형식으로 주어짐 (x=열, y=행)
        }

        dp[1][1] = 1; // 집 위치

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue; // 시작점은 이미 세팅됨
                if (blocked[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}
