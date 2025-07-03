import java.io.*;
import java.util.*;

public class BOJ_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] brr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        
        int[] arr = new int[brr.length];
        for (int i = brr.length - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = brr[i];
        }
        //LCS 
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]  && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        //배열 안뒤집고 그냥 LDS 써도 됨
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(N - maxValue);
    }
}
