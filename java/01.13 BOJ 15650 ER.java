import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}

/* my solution
import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());   // 4
        M = Integer.parseInt(st.nextToken());   // 2
        arr = new int[M];
        visit = new boolean[N];
        dfs(0, -1);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int check) {
        if (depth == M) {
            for (int val : arr) sb.append(val).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && i > check) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}
*/
