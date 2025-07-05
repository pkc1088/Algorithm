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

/* 2차원 풀이

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, cnt;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 4
        visited = new boolean[n + 2][n + 2];

        //         dfs(1);
        for (int startPoint = 1; startPoint < n + 1; startPoint++) {
            visited[1][startPoint] = true;
            dfs(2);
            visited[1][startPoint] = false;
        }
        System.out.println(cnt);
    }

    public static void dfs(int row) { // 2

        if (row == n + 1) {
            cnt++;
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if(!collision(row, i)) {
                visited[row][i] = true;
                dfs(row + 1);
                visited[row][i] = false;
            }
        }
    }

public static boolean collision(int row, int col) { // 1, 2
    for (int i = 1; i < row; i++) {
        for (int j = 1; j < n + 1; j++) {
            if(visited[i][j]) { // 이전에 기록해놓은 애들과 모두 비교
                if(j == col) return true; // 가로선 비교
                if(Math.abs(i - row) == Math.abs(j - col)) return true; // 대각 비교
            }
        }
    }

    return false;
}
}


 */