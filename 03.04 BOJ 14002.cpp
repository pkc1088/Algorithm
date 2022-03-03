import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> a = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
                }
            }
        }


        int max = -1;
        for(int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

        for (int i = N - 1; i >= 0; i--) {
            if(max == dp[i]) {
                a.push(arr[i]);
                max--;
            }
        }

        while(!a.isEmpty()) {
            System.out.print(a.pop()+" ");
        }
    }
}
