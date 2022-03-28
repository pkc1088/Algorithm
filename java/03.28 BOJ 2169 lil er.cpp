import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] mars;
    static int[][] dp;
    static int[][] temp;
    /*
    temp[0][j] 를 왼쪽에서 오른쪽으로 이동했을 때의 값
    temp[1][j] 를 오른쪽에서 왼쪽으로 이동했을 때의 값을 넣었다.
    둘 중 최댓값이 dp[i][j]의 값이 되는 것이다.     
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        mars = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        temp = new int[2][M+2];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++){
                mars[i][j] = sc.nextInt();
            }
        }

        dp[1][1] = mars[1][1];

        for(int j = 2; j <= M; j++) 
            dp[1][j] = mars[1][j]+ dp[1][j-1];

        for(int i = 2; i <= N; i++) {

            temp[0][0] = dp[i-1][1];
            for(int j = 1; j <= M; j++) {   //왼 -> 오
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j])+ mars[i][j];
            }                                      //temp로 오왼을 다 봐주니 위쪽만
                                                   //받아오면됨으로 dp[i-1][j]이다
            temp[1][M+1] = dp[i-1][M];      
            for(int j = M; j >= 1; j--) {   //오 -> 왼
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + mars[i][j];
            }

            for(int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[N][M]);

        sc.close();
    }

}
