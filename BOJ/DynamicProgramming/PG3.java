package BOJ.DynamicProgramming;
// "���"

class PG3 {

    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        boolean[][] blocked = new boolean[n+1][m+1];

        // �������� ǥ��
        for (int[] p : puddles) {
            blocked[p[1]][p[0]] = true;
            // puddles�� [x,y] �������� �־��� (x=��, y=��)
        }

        dp[1][1] = 1; // �� ��ġ

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue; // �������� �̹� ���õ�
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
