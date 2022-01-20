import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            // 0 ~ i ���� ���ҵ� Ž��
            for(int j = 0; j < i; j++) {
                // j��° ���Ұ� i��° ���Һ��� �����鼭 i��° dp�� j��° dp+1 ������ �������
                if(seq[i] > seq[j]  && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;	// j��° ������ +1 ���� i��° dp�� �ȴ�.
                }
            }
        }
        // �ִ�(�ִ� ����) Ž��
        int max = -1;
        for(int i = 0; i < N; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        System.out.println(max);
    }
}
