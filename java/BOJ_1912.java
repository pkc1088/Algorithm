import java.util.Scanner;
 
public class BOJ_1912 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
 
		/*
		 * dp[0]�� ù ���ҷ� ������ ���̻� Ž���� ���� ���� ������
		 * arr[0] ��ü ���� �ǹǷ� arr[0]���� �ʱ�ȭ ���ش�.
		 * max���� ù ��° ���ҷ� �ʱ�ȭ ���ش�.
		 */
		dp[0] = arr[0];
		int max = arr[0];
		
		for (int i = 1; i < N; i++) {
			// (���� dp + ���� arr��) �� ���� arr�� �� ū ���� dp�� ���� 
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			// �ִ� ���� 
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
 
	}
}
