import java.io.*;
import java.util.*;
public class NDB_15_2 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(upperBound());
    }

    /*private static int lowerBound() {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (mid <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }*/

    private static int upperBound() {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (mid == arr[mid]) {
                return arr[mid];
            }

            else if (mid < arr[mid]) {
                hi = mid;
            }

            else {              //arr[mid] < mid
                lo = mid + 1;
            }
        }
        return -1;
    }

}
