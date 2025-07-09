package BOJ.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 250709
import java.util.*;
import java.io.*;

public class Main {
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
}
 */

// bfs 풀이 & dp 풀이
public class BOJ_1697 {
    static int N;
    static int K;

    static int visited[] = new int[100001];
    // X-1, X+1
    // 2*X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        int result = bfs(N);
        System.out.println(result);
    }

    private static int  bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;
        while (!queue.isEmpty()) {
            n = queue.remove();

            if (n == K) return visited[n] - 1;

            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            if (2 * n <= 100000 && visited[2 * n] == 0) {
                visited[2 * n] = visited[n] + 1;
                queue.add(2 * n);
            }
        }
        return -1;
    }
}
/*
public class Main {
	static int distance[] = new int[100001]; // 전체 거리
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		if(N >= K) {
			System.out.println(N-K);
			return;
		}

		for(int i=0; i<N; i++) {
			distance[i] = N-i;
		}

		DP();
		System.out.print(distance[K]);
	} // End of main

	private static void DP() {
		for(int i=N+1; i<=K; i++) {
			int min;

			if(i % 2 == 0) {
				min = distance[i/2] + 1;
			}
			else {
				min = Math.min(distance[(i+1)/2], distance[(i-1)/2]) +2;
			}

			distance[i] = Math.min(min,  distance[i-1]+1);
		}
	}// End of DP
} // End of class

 */