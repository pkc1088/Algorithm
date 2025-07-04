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
		 * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
		 * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
		 * max또한 첫 번째 원소로 초기화 해준다.
		 */
		dp[0] = arr[0];
		int max = arr[0];
		
		for (int i = 1; i < N; i++) {
			// (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 dp에 저장 
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			// 최댓값 갱신 
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
 
	}
}
