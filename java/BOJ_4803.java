import java.io.*;
import java.util.*;

public class BOJ_4803 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] board;
    public static boolean[] visited;
    public static boolean hasCycle = false;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        int k = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m ==0)
                break;

            board = new int[n+1][n+1];
            visited = new boolean[n+1];
            int t = func(n, m);
            if(t==1) {
                System.out.println("Case "+k+": There is one tree.");
            } else if(t==0) {
                System.out.println("Case "+k+": No trees.");
            } else {
                System.out.println("Case "+k+": A forest of "+t+" trees.");
            }
            k++;
        }
    }

    public static int func(int n, int m) throws IOException {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            board[node2][node1] = 1;
            board[node1][node2] = 1;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("****i : "+i+" ****");
            if(!visited[i]){
                hasCycle = false;
                recursive(0, i);
                if(!hasCycle)
                    cnt++;
            }
        }

        return cnt;
    }

    public static void recursive(int before, int cur) {
        System.out.println("recursive("+before+", "+cur+")");

        visited[cur] = true;

        for (int next = 1; next <= n; next++) {
            if(board[cur][next] == 1 && next != before) {
                if(!visited[next])
                    recursive(cur, next);

                else {
                    hasCycle = true;
                    System.out.println("next "+next);
                }

            }

        }
    }

}

/*
/////////////////////////
import java.io.*;
import java.util.*;
public class BOJ_4803 {

    static int N, M;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int ans = 0;
            tree = new ArrayList[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                tree[a].add(b);
                tree[b].add(a);
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (dfs(-1, i)) ans++;
                }
            }

            sb.append("Case ").append(T).append(": ");
            if (ans == 0) {
                sb.append("No trees.\n");
            } else if (ans == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(ans).append(" trees.\n");
            }
            T++;
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean dfs(int root, int num) {
        for (int i : tree[num]) {
            
			if (i == root) 
				continue;
            
			if (visited[i]) 
				return false;
            visited[i] = true;
            
			if (!dfs(num, i)) 
				return false;
        }
        return true;
    }
}*/
