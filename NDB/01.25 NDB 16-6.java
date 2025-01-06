import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int length_1 = str1.length;
        int length_2 = str2.length;

        // ������ ǥ���� ���� �ε����� �� �پ� �߰� ��
        int[][] dp = new int[length_1 + 1][length_2 + 1];
        // 1���� ���� (index 0 �� �������̹Ƿ� 0�� ���� ��������)
        for(int i = 1; i <= length_1; i++) {
            for(int j = 1; j <= length_2; j++) {
                // (i-1)�� (j-1) ��° ���ڰ� ���� ���ٸ�
                if(str1[i - 1] == str2[j - 1]) {
                    // �밢�� �� (i-1, j-1)�� dp�� +1 �� ������ ����
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // ���� �ʴٸ� ���� ��(i-1)�� ���� ��(j-1)�� �� �� ū ������ ����
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(length_2-dp[length_1][length_2]);
w
    }
}
/*
static int editDist(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // ���̳��� ���α׷����� ���� 2���� DP ���̺� �ʱ�ȭ
        int[][] dp = new int[n + 1][m + 1];

        // DP ���̺� �ʱ� ����
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }

        // �ּ� ���� �Ÿ� ���
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // ���ڰ� ���ٸ�, ���� ���� �ش��ϴ� ���� �״�� ����
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // ���ڰ� �ٸ��ٸ�, �� ���� ��� �߿��� �ּڰ� ã��
                else { // ����(����), ����(����), ��ü(���� ��) �߿��� �ּ� ����� ã�� ����
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], 
                                   Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
 */
