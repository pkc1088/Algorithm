package BOJ.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9663 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int N, cnt = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dfs(0);
        System.out.println(cnt);
//        bw.write(cnt);
//        bw.flush();
//        bw.close();
    }
    public static boolean collision_check(int col) {
        // 이전 퀸들의 좌표와 비교해서 걸러야함
        for (int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) return false;
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int col) {
        if(col == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[col] = i;
            if(collision_check(col))
                dfs(col+1);
        }
    }
}
