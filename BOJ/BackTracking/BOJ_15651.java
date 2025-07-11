package BOJ.BackTracking;

import java.util.*;
import java.io.*;

public class BOJ_15651 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 4
        m = Integer.parseInt(st.nextToken()); // 2

        arr = new int[m + 1];
        visited = new boolean[n + 1];

        dfs(1);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m + 1) {
            for (int i = 1; i < m + 1; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}


//import java.io.*;
//import java.util.StringTokenizer;
//
//public class BOJ_15651 {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
//    static int[] arr;
//    static boolean[] visit;
//    static int N, M, cnt = 0;
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        visit = new boolean[N]; //4
//        arr = new int[M]; // 2
//
//        dfs(0);
//        bw.write(String.valueOf(sb));
//        bw.flush();
//        bw.close();
//    }
//    public static void dfs(int dp) { // N = 4, M = 2
//        if(dp == M) {
//            for (int val : arr) {
//                sb.append(val).append(' ');
//            }
//            sb.append('\n');
//            return;
//        }
//        //System.out.println("dfs("+dp+")");
//        for (int i = 0; i < N; i++) { // N is 4, M is 2
//            if (!visit[i]) {
//
//                arr[dp] = i + 1;    //System.out.println("arr["+dp+"]="+(i+1));
//                //visit[i] = true;    //System.out.println("visit["+i+"] true");
//                dfs(dp + 1);
//                //visit[i] = false;   //System.out.println("visit["+i+"] false");
//            }
//        }
//    }
//
//    public static void print() throws IOException {
//
//    }
//}