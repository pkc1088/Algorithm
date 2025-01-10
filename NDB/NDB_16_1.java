import java.io.*;
import java.util.*;

public class NDB_16_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] mine = new int[n][m];
            int[][] dp = new int[n][m];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mine[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = mine[i][j];
                }
            }

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, leftDown, left;
                    
                    // ���� ������ ���� ���
                    if (i == 0) 
                        leftUp = 0;
                    else 
                        leftUp = dp[i - 1][j - 1];
                    
                    // ���� �Ʒ����� ���� ���
                    if (i == n - 1) 
                        leftDown = 0;
                    else 
                        leftDown = dp[i + 1][j - 1];
                    
                    // ���ʿ��� ���� ���
                    left = dp[i][j - 1];
                    dp[i][j] = mine[i][j] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
