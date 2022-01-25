import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int length_1 = str1.length;
        int length_2 = str2.length;

        // 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨
        int[][] dp = new int[length_1 + 1][length_2 + 1];
        // 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음)
        for(int i = 1; i <= length_1; i++) {
            for(int j = 1; j <= length_2; j++) {
                // (i-1)과 (j-1) 번째 문자가 서로 같다면
                if(str1[i - 1] == str2[j - 1]) {
                    // 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
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

        // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
        int[][] dp = new int[n + 1][m + 1];

        // DP 테이블 초기 설정
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }

        // 최소 편집 거리 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 문자가 같다면, 왼쪽 위에 해당하는 수를 그대로 대입
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 문자가 다르다면, 세 가지 경우 중에서 최솟값 찾기
                else { // 삽입(왼쪽), 삭제(위쪽), 교체(왼쪽 위) 중에서 최소 비용을 찾아 대입
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], 
                                   Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
 */
