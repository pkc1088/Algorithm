import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        // ù��° �ڸ����� 1�� �ʱ�ȭ
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        // ������ �ڸ����� 1~9������ ����� ���� ��� �����ش�.
        for(int i = 1; i <= 9; i++) {
            result += recur(N, i);
        }
        System.out.println(result % MOD);
    }

	/*
	 dist �� �ڸ���, val�� �ڸ����� �ǹ���

	 ù° �ڸ����� �� val�� ���̱� ������
	 ����� ���� 1�ۿ� ����. ��, dp[1]�� �� �ڸ�����
	 1�� �ʱ�ȭ �Ǿ��־���Ѵ�.
	*/

    static long recur(int digit, int val) {

        // ù° �ڸ����� �����Ѵٸ� ���̻� Ž���� �ʿ� ����
        if(digit == 1) {
            return dp[digit][val];
        }

        // �ش� �ڸ����� val���� ���� Ž������ �ʾ��� ���
        if(dp[digit][val] == null) {
            // val�� 0�ϰ�� ������ 1�ۿ� ����
            if(val == 0) {
                dp[digit][val] = recur(digit - 1 ,1);
            }
            // val�� 1�ϰ�� ������ 8�ۿ� ����
            else if(val== 9) {
                dp[digit][val] = recur(digit - 1, 8);
            }
            // �� ���� ���� val-1�� val+1 ���� ����� ���� ���� ����� ���� ��
            else {
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % MOD;
    }
}
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	
	final static long mod = 1000000000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N + 1][10];
		
		// ù ��° �ڸ����� ������ �� ���� �ڸ����̹Ƿ� ����� ���� 1���ۿ� ���� 
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
		
		// �� ��° �ڸ������� N���� Ž�� 
		for(int i = 2; i <= N; i++) {
			
			// i��° �ڸ����� �ڸ������� Ž�� (0~9) 
			for(int j = 0; j < 10; j++) {
				
				// j=0, �� �ڸ����� 0�̶�� ���� �ڸ����� ù��° �ڸ����� ���� 
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				// j=9��� ���� �ڸ����� 8�� ����
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// �� ���� ��� ���� �ڸ����� �ڸ��� +1, -1 �� ���� �� 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		
		long result = 0;
		
		// �� �ڸ��������� ����� ���� ��� �����ش�. 
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % mod);
	}
 
}
 */
