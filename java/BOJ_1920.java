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

        // ã�� ��� �߰��� �ε��� ��ȯ
        if (arr[mid] == target)
            return mid;

        // �߰����� ������ ã���� �ϴ� ���� ���� ��� ���� Ȯ��
        else if (arr[mid] > target)
            return binarySearch(arr, target, start, mid - 1);

        // �߰����� ������ ã���� �ϴ� ���� ū ��� ������ Ȯ��
        else
            return binarySearch(arr, target, mid + 1, end);
    }
}


