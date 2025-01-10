import java.io.*;
import java.util.*;

public class BOJ_1920 {
    public static int[] arrr, brr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arrr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrr);

        int m = Integer.parseInt(br.readLine());
        brr = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        for (int target : brr) {
            int result = binarySearch(arrr, target, 0, n - 1);
            if (result == -1) {
                System.out.println("0");
            }
            else {
                System.out.println("1");
            }
        }

    }


    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        // 찾은 경우 중간점 인덱스 반환
        if (arr[mid] == target)
            return mid;

        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (arr[mid] > target)
            return binarySearch(arr, target, start, mid - 1);

        // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else
            return binarySearch(arr, target, mid + 1, end);
    }
}


