package BOJ.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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