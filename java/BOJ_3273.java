import java.io.*;
import java.util.*;
public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.parallelSort(arr);	// 원소의 개수가 많을 때 더 유리.

        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = n - 1;
        int sum = 0;

        while(start < end) {
            sum = arr[start] + arr[end];
            if(sum == x) {
                count++;
            }

            if(sum <= x) {
                start++;
            }
            else {
                end--;
            }
        }


        System.out.println(count);
    }
}
/*
public class BOJ_3273 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if(arr[i] >= x)
                continue;

            for (int j = i+1; j < n; j++) {
                if(arr[j] == x - arr[i]) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}*/
