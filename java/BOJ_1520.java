import java.io.*;
import java.util.*;
//한 번 끝점까지 탐색이 완료된 점은 dp를 사용하여 경로의 개수를 저장해 놓고,
//다른 점에서 또 탐색이 되었을 때는 이 경로를 더해주는 방향으로 로직
public class BOJ_1520 {
static int M, N;
static int[][] arr, dp;
static int[] rangeX = { -1, 0, 1, 0 };
static int[] rangeY = { 0, 1, 0, -1 };

public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
        st = new StringTokenizer(br.readLine());

        for (int j = 1; j <= N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        }
        }

        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++) {
        dp[i][j] = -1;
        }
        }

        bw.write(DFS(1, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
        }

public static int DFS(int x, int y) {
        if (x == M && y == N) {
        return 1;
        }

        if (dp[x][y] != -1) {
        return dp[x][y];
        }

        dp[x][y] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화.
        for (int i = 0; i < 4; i++) {
        int dx = x + rangeX[i];
        int dy = y + rangeY[i];

        if (dx < 1 || dy < 1 || dx > M || dy > N) {
        continue;
        }

        // arr[x][y]보다 arr[dx][dy]가 높이가 더 낮다면
        // arr[dx][dy]에서 끝점까지 도달하는 경로의 개수를 더한다. (DFS의 정의)
        if (arr[x][y] > arr[dx][dy]) {
        dp[x][y] += DFS(dx, dy);
        }
        }

        return dp[x][y];
        }

        }

/*
public class acmicpc_1520_DownhillPath_DP {

	static int R, C, cnt;
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};

	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		dp = new int[R][C];
		visited = new boolean[R][C];

		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[R-1][C-1] = 1;
		dfs(0,0);

		System.out.println(dp[0][0]);
	}


	private static void dfs(int i, int j) {
		if(i==R-1 && j==C-1) {
			return;
		}

		if(visited[i][j]) {
			return;
		}

		visited[i][j] = true;

		for(int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if(nx >=0 && nx <R && ny >=0 && ny <C && map[i][j] > map[nx][ny]) {
				if(dp[nx][ny] != 0) {
					dp[i][j] += dp[nx][ny];
					continue;
				}else {
					dfs(nx,ny);
					dp[i][j] += dp[nx][ny];
				}
			}
		}
	}
}

 */
