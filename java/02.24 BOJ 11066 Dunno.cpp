import java.util.*;

public class Main {
    /*
    1. K�� 2���� ���� ��
    DP[i][i] �� ��ġ�� 0�̰�
    DP[i][j] �� V[i]�� V[j]�� ���̴�.

    2. K�� 2���� Ŭ ��
    V = {a, b, c}(K == 3)���
    {a, b} / c �� ���� a / {b, c}�� ���� ������.
    ���� ������ 2���� ���� �� ��ġ�� �̵��ϸ鼭 �ּҰ��� ã�Ƴ���.
    ��, DP[1][3](K == 3)�� ���� �� DP[1][2] + DP[3][3]��
    DP[1][1] + DP[2][3]�� �ּҰ��� ���ϸ� �ȴ�.
    �̸� ����ȭ �غ���
    DP[i][j] = DP[i][k] + DP[k+1][j] (��, i < k < j)
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
        int DP[][] = new int[size][size];	//i~j���� �ּ��� DP
        int s[] = new int[size];	//SUM ����

        //i��ұ��� ����
        s[0] = a[0];
        for(int i = 1; i < size; i++)
            s[i] += s[i-1] + a[i];

        //�ʱⰪ ���� (�ϳ� ���̳����� �����Ѱ� �ΰ����Ѱ� �����
        for(int i = 0; i < size-1; i++)
            DP[i][i+1] = a[i] + a[i+1];

        for(int gap = 2; gap < size; gap++){	//i�� j�� gap 3ĭ����
            for(int i = 0; i+gap < size; i++){	//i �ε���
                int j = i+gap;	//j �ε���
                DP[i][j] = Integer.MAX_VALUE;	//MIN�� ���ϱ� ����

                for(int k = i; k < j; k++)	//i~j ������ k��
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

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            int[] arr = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[502][502];
            int[][] kk = new int[502][502]; // Knuth ����ȭ�� ���� ���� ��ȭ�� ���¸� �����ֱ� ����.

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
                    // �������� ��ü ���� �� �� �����ش�.
                }
            }
            sb.append(dp[1][K]).append("\n");

        }

        System.out.println(sb.toString());
        
		  //����ȭ��
            for (int i = 1; i <= K; i++) {
                dp[i - 1][i] = 0;
                kk[i - 1][i] = i;
            }

            // DP ����ȭ ��� �� �ϳ��� Knuth Optimization�� ����� �ڵ� O(N^2)
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
