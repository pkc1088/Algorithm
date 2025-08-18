package BOJ;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    // static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static List<int[]> list = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, h, r, v, e, t, k, l, s, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean[] visit;
    static int[] arr;
    static int[][] brr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100000 + 1];


    }

    public static void bfs(int cur, int time) {


    }
}


/*public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n, m, r, v, t, k, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100000 + 1];
        visit = new boolean[100000 + 1];

        arr[n] = 0;
        if(n == k) System.out.println(0);
        else bfs(n, 0);

//        System.out.println(arr[m]);
    }

    public static void bfs(int cur, int time) { // 5
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {cur - 1, time + 1}); // 4
        q.offer(new int[] {cur + 1, time + 1}); // 6
        q.offer(new int[] {cur * 2, time + 1}); // 10

        while(!q.isEmpty()) {
            // k에 도달하면 그게 바로 최소가 될테니
            // 바로 return 하면 됨
            int[] dto = q.poll();
            if(dto[0] == k) {
                System.out.println(dto[1]);
                return;
            }
            int nxt_step1 = dto[0] - 1;
            int nxt_step2 = dto[0] + 1;
            int nxt_step3 = dto[0] * 2;
            int nxt_time = dto[1] + 1;
            if(0 <= nxt_step1 && nxt_step1 <= 100000 && arr[nxt_step1] == 0) {
                arr[nxt_step1] = nxt_time;
                q.offer(new int[] {nxt_step1, nxt_time});
            }
            if(0 <= nxt_step2 && nxt_step2 <= 100000 && arr[nxt_step2] == 0) {
                arr[nxt_step2] = nxt_time;
                q.offer(new int[] {nxt_step2, nxt_time});
            }
            if(0 <= nxt_step3 && nxt_step3 <= 100000 && arr[nxt_step3] == 0) {
                arr[nxt_step3] = nxt_time;
                q.offer(new int[] {nxt_step3, nxt_time});
            }

        }
    }
}*/








