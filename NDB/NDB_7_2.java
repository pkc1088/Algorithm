import java.io.*;
import java.util.*;

public class NDB_7_2 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int low = 0;
        int high = arr[n-1]+1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int len = 0;

            for (int i = 0; i < n; i++) {
                if(arr[i] > mid)
                    len += arr[i] - mid;
            }

            if (len < m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }


        System.out.println(low - 1);
    }
}
