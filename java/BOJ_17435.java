import java.io.*;
import java.util.*;
//https://imucoding.tistory.com/1067
//https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-17435%EB%B2%88-%ED%95%A9%EC%84%B1%ED%95%A8%EC%88%98%EC%99%80-%EC%BF%BC%EB%A6%AC-Java-Python
public class BOJ_17435 {
	private final static int log = 19;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		int[][] dp = new int[log + 1][M + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			dp[0][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < log + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				dp[i][j] = dp[i - 1][dp[i - 1][j]];
			}
		}

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for (int b = 0; b < log; b++) {
				if ((n & (1 << b)) > 0) {
					x = dp[b][x];
				}
			}
			sb.append(x).append("\n");
		}

		bw.write(sb.toString() + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}

