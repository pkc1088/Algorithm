import java.io.*;
import java.util.*;

public class BOJ_11505 {
    static long[] arr, tree;
    static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

		int k = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int size = (int) Math.pow(2, k);
		tree = new long[size];

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                arr[b] = c;
                update(1, N, 1, b, c);
            } else if (a == 2) {
                sb.append(multi(1, N, 1, b, (int) c) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2)
                          * init(mid + 1, end, node * 2 + 1) % MOD;
    }

    public static long multi(int start, int end, int node, int left, int right) {

        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return multi(start, mid, node * 2, left, right)
             * multi(mid + 1, end, node * 2 + 1, left, right) % MOD;
    }

    public static long update(int start, int end, int node, int idx, long dif) {

        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = dif;
        }

        int mid = (start + end) / 2;
        return tree[node] =
                update(start, mid, node * 2, idx, dif) *
                update(mid + 1, end, node * 2 + 1, idx, dif) % MOD;
    }

}
