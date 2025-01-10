import java.util.*;

public class BOJ_11066 {
    /*
    1. K가 2보다 작을 때
    DP[i][i] 의 가치는 0이고
    DP[i][j] 는 V[i]와 V[j]의 합이다.

    2. K가 2보다 클 때
    V = {a, b, c}(K == 3)라면
    {a, b} / c 의 경우와 a / {b, c}의 경우로 나뉜다.
    길이 내에서 2개씩 묶어 그 위치를 이동하면서 최소값을 찾아낸다.
    즉, DP[1][3](K == 3)을 구할 때 DP[1][2] + DP[3][3]과
    DP[1][1] + DP[2][3]중 최소값을 구하면 된다.
    이를 수식화 해보면
    DP[i][j] = DP[i][k] + DP[k+1][j] (단, i < k < j)
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int caseCNT = s.nextInt();

        for(int i = 0; i < caseCNT; i++){
            int numCNT = s.nextInt();
            int testCase[] = new int[numCNT];

            for(int j = 0; j < numCNT; j++)
                testCase[j] = s.nextInt();

            System.out.println(solution(testCase));
        }
    }

    public static int MIN(int a, int b){
        return a <= b? a:b;
    }

    public static int sum(int[] a, int s, int e){
        if(s == 0)
            return a[e];
        else
            return a[e] - a[s-1];
    }

    private static int solution(int[] a){
        int size = a.length;
        int DP[][] = new int[size][size];	//i~j까지 최소합 DP
        int s[] = new int[size];	//SUM 저장

        //i요소까지 총합
        s[0] = a[0];
        for(int i = 1; i < size; i++)
            s[i] += s[i-1] + a[i];

        //초기값 저장 (하나 차이날는 인접한거 두개더한게 저장됨
        for(int i = 0; i < size-1; i++)
            DP[i][i+1] = a[i] + a[i+1];

        for(int gap = 2; gap < size; gap++){	//i와 j간 gap 3칸부터
            for(int i = 0; i+gap < size; i++){	//i 인덱스
                int j = i+gap;	//j 인덱스
                DP[i][j] = Integer.MAX_VALUE;	//MIN을 구하기 위해

                for(int k = i; k < j; k++)	//i~j 사이의 k값
                    DP[i][j] = MIN(DP[i][k] + DP[k+1][j] + sum(s, i, j), DP[i][j]);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
        return DP[0][a.length-1];
    }
}

/*
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11066 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            int[] arr = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[502][502];
            int[][] kk = new int[502][502]; // Knuth 최적화를 쓰기 위해 점화식 형태를 맞춰주기 위함.

            for (int i = 1; i <= K; i++) {
                arr[i] = sc.nextInt();
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 2; i <= K; i++) {
                for (int j = i - 1; j > 0; j--) {
                    dp[j][i] = Integer.MAX_VALUE;
                    for (int k = j; k <= i; k++) {
                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
                    }
                    dp[j][i] += sum[i] - sum[j - 1]; 
                    // 마지막에 전체 합을 한 번 더해준다.
                }
            }
            sb.append(dp[1][K]).append("\n");

        }

        System.out.println(sb.toString());
        
		  //최적화용
            for (int i = 1; i <= K; i++) {
                dp[i - 1][i] = 0;
                kk[i - 1][i] = i;
            }

            // DP 최적화 기법 중 하나인 Knuth Optimization을 사용한 코드 O(N^2)
            for (int d = 2; d <= K; d++) {
                for (int i = 0; i + d <= K; i++) {
                    int j = i + d;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = kk[i][j - 1]; k <= kk[i + 1][j]; k++) {
                        int v = dp[i][k] + dp[k][j] + (sum[j] - sum[i]);
                        if (dp[i][j] > v) {
                            dp[i][j] = v;
                            kk[i][j] = k;
                        }
                    }
                }
            }
            sb.append(dp[0][K]).append("\n");
    }
}
*/
