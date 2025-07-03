import java.io.*;
import java.util.*;

public class BOJ_11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                sum += p[j];
            }
        }
        System.out.println(sum);
    }
}
