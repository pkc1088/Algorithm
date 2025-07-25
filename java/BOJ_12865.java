import java.util.*;
//https://www.youtube.com/watch?v=mUFfuzpnLHs&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&index=57
public class BOJ_12865 {

    public static int max(int a, int b) {
        if(a > b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int maxWeight = sc.nextInt();
        int[] w = new int[num+1];
        int[] v = new int[num+1];
        int[][] memo = new int[num+1][maxWeight+1];

        // �Է�
        for(int i = 1; i <= num; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // DP
        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= maxWeight; j++) {
                if(w[i] > j)
                    memo[i][j] = memo[i-1][j];
                else
                    memo[i][j] = max(memo[i-1][j], memo[i-1][j-w[i]]+v[i]);
            }
        }

        System.out.println(memo[num][maxWeight]);

        sc.close();
        return;
    }
}
