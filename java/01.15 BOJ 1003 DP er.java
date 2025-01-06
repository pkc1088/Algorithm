import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0][0] = 1;	// N=0 �� ���� 0 ȣ�� Ƚ��
        dp[0][1] = 0;	// N=0 �� ���� 1 ȣ�� Ƚ��
        dp[1][0] = 0;	// N=1 �� ���� 0 ȣ�� Ƚ��
        dp[1][1] = 1;	// N=1 �� ���� 1 ȣ�� Ƚ��

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
        }
        System.out.println(sb);
    }

    static Integer[] fibonacci(int N) {
        // N�� ���� 0, 1�� ȣ�� Ƚ���� ���� ��(Ž������ ���� ���� ��)
        if(dp[N][0] == null || dp[N][1] == null) {
            // �� N�� ���� 0 ȣ�� Ƚ���� 1 ȣ�� Ƚ���� ���ȣ���Ѵ�.
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        // N�� ���� 0�� 1, �� [N][0]�� [N][1] �� ����ִ� [N]�� ��ȯ�Ѵ�.
        return dp[N];

    }

}
