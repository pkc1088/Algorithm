import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stk = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        String str = "";
        int length_1 = str1.length;
        int length_2 = str2.length;

        // 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨
        int[][] dp = new int[length_2 + 1][length_1 + 1];

        // 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음)
        for(int i = 1; i <= length_2; i++) {
            for(int j = 1; j <= length_1; j++) {

                // (i-1)과 (j-1) 번째 문자가 서로 같다면
                if(str1[j - 1] == str2[i - 1]) {
                    // 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int max = dp[length_2][length_1];
        System.out.println(max);

        int i = length_2;
        int j = length_1;
        while(i>=1 && j>=1) {
            if(dp[i][j]==dp[i-1][j]) {
                i--;
            }
            else if(dp[i][j]==dp[i][j-1]) {
                j--;
            }
            else {
                stk.push(str2[i-1]);
                i--;
                j--;
            }
        }

        while(!stk.empty()) {
            System.out.print(stk.pop());
        }
        System.out.println();
        for(int k = 1; k <= length_2; k++) {
            for (int w = 1; w <= length_1; w++) {
                System.out.print(dp[k][w]+" ");
            }
            System.out.println();
        }
    }
}

