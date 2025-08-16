package BOJ.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.io.*;
import java.util.*;

public class BOJ_13549 {
    static int N, K;
    static int[] time; // 각 위치까지의 최소 시간을 저장하는 배열
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[MAX];
        Arrays.fill(time, Integer.MAX_VALUE);

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        dijkstra();
        System.out.println(time[K]);
    }

    public static void dijkstra() {
        // 우선순위 큐. int[] = {위치, 걸린 시간}
        // 시간이 적은 순서대로 정렬됨
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 시작점 설정
        pq.offer(new int[]{N, 0});
        time[N] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentPos = current[0];
            int currentTime = current[1];

            // 이미 더 빠른 경로로 해당 위치에 도달했다면 무시
            if (currentTime > time[currentPos]) {
                continue;
            }

            // 목적지에 도달하면 종료 (PriorityQueue 특성상 처음 도달한 것이 최단 시간)
            if (currentPos == K) {
                return;
            }

            // 1. 걷기: X-1
            int nextPos1 = currentPos - 1;
            if (nextPos1 >= 0 && time[nextPos1] > currentTime + 1) {
                time[nextPos1] = currentTime + 1;
                pq.offer(new int[]{nextPos1, time[nextPos1]});
            }

            // 2. 걷기: X+1
            int nextPos2 = currentPos + 1;
            if (nextPos2 < MAX && time[nextPos2] > currentTime + 1) {
                time[nextPos2] = currentTime + 1;
                pq.offer(new int[]{nextPos2, time[nextPos2]});
            }

            // 3. 순간이동: 2*X
            int nextPos3 = currentPos * 2;
            if (nextPos3 < MAX && time[nextPos3] > currentTime) {
                time[nextPos3] = currentTime; // 순간이동은 0초 소요
                pq.offer(new int[]{nextPos3, time[nextPos3]});
            }
        }
    }
}
/*
// bfs 풀이 & dp 풀이
// dp 라기 보단 Queue 를 사용하면서도, 가중치가 0인 간선(순간이동)을 가중치가 1인 간선(걷기)보다
// 항상 먼저 처리하도록 순서를 조작하는 데 있음 (0-1 BFS 기법).
public class BOJ_13549 {
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
        int n = 0;
        visited[node] = 1;
        while (!queue.isEmpty()) {
            n = queue.remove();

            if (n == K) return visited[n] - 1;

            if (2 * n <= 100000 && visited[2 * n] == 0) {
                visited[2 * n] = visited[n];
                queue.add(2 * n);
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }

        }
        return -1;
    }
}*/

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