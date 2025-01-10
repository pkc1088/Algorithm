import java.io.*;
import java.util.*;

public class BOJ_1509 {

    static boolean[][] palindrome;
    static int[] dp;
    //dp[i] : 0부터 i번째 위치까지 팰린드롬 분할의 최소 개수
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int len = str.length();
        palindrome = new boolean[len + 1][len + 1];
        dp = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        checkPalindrome(str, len); // 팰린드롬을 먼저 찾는다.

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if(palindrome[i][j])
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("i : "+i+", j : "+j);
                if (palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    System.out.println("dp["+i+"] : "+dp[i]);
                }
            }
            System.out.println();
        }

        bw.write(dp[len] + "\n");
        bw.flush();

    }

    public static void checkPalindrome(String str, int len) {
        for(int i = 1; i <= len; i++) //자기 자신 (길이가 1)
            palindrome[i][i] = true;

        for(int i = 1; i <= len - 1; i++) //길이가 2인 경우
            if(str.charAt(i-1) == str.charAt(i+1-1))
                palindrome[i][i + 1]= true;

        for(int i = 2; i < len; i++){     //길이가 2보다 큰 경우
            for(int j = 1; j <= len - i; j++){
                if(str.charAt(j-1) == str.charAt(j+i-1)
                                        && palindrome[j + 1][j + i - 1])
                    palindrome[j][j + i] = true;
            }
        }
    }
    /*
        2~4 즉 arr[2][4]가 참이고 arr[1]==arr[1+4]이면
        1~5 즉 arr[1][5]에 참을 줄 수 있는거임
    */
}
