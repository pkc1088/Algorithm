import java.io.*;
import java.util.*;
public class BOJ_1012 {
    public static int n, m, cnt = 0;
    public static int[][] arr;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            int k = Integer.parseInt(st.nextToken());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                arr[p][q] = 1;
            }

            dfs();
            System.out.println(cnt);
            cnt = 0;
        }
    }

    public static void landBreath(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 100;
                    landBreath(nx, ny);
                }
            }
        }
    }

    public static void dfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    landBreath(i, j);
                    cnt++;
                }
            }

        }
    }
}

/* BFS 풀이방법 
public class Exam1012 {

	static int M, N, K;
	static int[][] cabbage;
	static boolean[][] visit;
	static int count;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void bfs(int x, int y) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] { x, y });

		while (!qu.isEmpty()) {
			x = qu.peek()[0];
			y = qu.peek()[1];
			visit[x][y] = true;
			qu.poll();
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
						qu.add(new int[] { cx, cy });
						visit[cx][cy] = true;
					}
				}

			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int c = 0; c < T; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			 M = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());
			 K = Integer.parseInt(st.nextToken());
			cabbage = new int[M][N];
			visit = new boolean[M][N];
			count=0;

			for (int i = 0; i < K; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				cabbage[p1][p2] = 1;

			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (cabbage[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
}
*/
