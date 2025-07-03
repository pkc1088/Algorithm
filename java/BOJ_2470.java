import java.io.*;
import java.util.*;
public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), indexZero = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.parallelSort(arr);	// 원소의 개수가 많을 때 더 유리.

        int left = 0;
        int right = n-1;
        int max = 2000000000;
        int ans1 = -1, ans2 = -1;

        while(left < right) {
            int sum = arr[left] + arr[right];

            // 두 용액 갱신
            if(Math.abs(sum) < max) {
                ans1 = arr[left];
                ans2 = arr[right];
                max = Math.abs(sum);
            }

            if(sum > 0)
                right--;
            else
                left++;
        }

        System.out.println(ans1 + " " + ans2);
    }
}

