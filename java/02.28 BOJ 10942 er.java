import java.io.*;
import java.util.*;
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n + 1];
        dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        solve(arr, n);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(dp[start][end]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }
    public static void solve(int[] arr, int n){
        for(int i = 1; i <= n; i++) //자기 자신 (길이가 1)
            dp[i][i] = true;

        for(int i = 1; i <= n - 1; i++) //길이가 2인 경우
            if(arr[i] == arr[i + 1])
                dp[i][i + 1]= true;

        for(int i = 2; i < n; i++){     //길이가 2보다 큰 경우
            for(int j = 1; j <= n - i; j++){
                if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
         /*
        2~4 즉 arr[2][4]가 참이고 arr[1]==arr[1+4]이면 
        1~5 즉 arr[1][5]에 참을 줄 수 있는거임
         */
    }
}

/*
import java.io.*;
import java.util.*;

public class Main {

	static int[] num;
	static int[][] dp;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		dp = new int[n+1][n+1];
		for(int i=0; i< n+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
            
			boolean flag = checkPalin(start, end) == 1? true : false;
			if(flag) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	static int checkPalin(int s, int e) {
		if( s >= e) return 1;
		
		if(dp[s][e] != -1) return dp[s][e];
		
		if(num[s]==num[e]) {
			return dp[s][e] = checkPalin(s+1, e-1);
		}
		return 0;
	
	}
}
 */

