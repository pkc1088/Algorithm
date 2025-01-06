import java.util.*;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

public class Main {

    public static int n, m;
    public static int[][] graph = new int[201][201];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용 
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        // 큐가 빌 때까지 반복하기 
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                } 
            } 
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }
    /* 노드 안만들고 이렇게 써도 됨 이게 
    public static int bfs(int x, int y) {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        // 큐가 빌 때까지 반복하기
        while(!q.isEmpty()) {
            int[] h = q.poll();
            x = h[0];
            y = h[1];
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }

    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }

}

/* bfs 방법이지만 시간초과 날 수 
public static void dfs(int x, int y, int count) {
		if(x == n-1 && y == m-1) {
			minVal = Math.min(minVal, count);
			return;
		}
		
		if(count > minVal) return; //가지치기 - 이미 count가 minVal보다 커졌다면 return;
		
        	//방향배열 사용하지 않고 조건문으로 4가지를 나누어 보았다.
		if(x > 0 && !visited[x-1][y] && map[x-1][y] == 1) { //상
			visited[x-1][y] = true;
			dfs(x-1, y, count + 1);
			visited[x-1][y] = false;
		}
		if(x < n-1 && !visited[x+1][y] && map[x+1][y] == 1) { //하
			visited[x+1][y] = true;
			dfs(x+1, y, count + 1);
			visited[x+1][y] = false;
		}
		if(y > 0 && !visited[x][y-1] && map[x][y-1] == 1) { //좌
			visited[x][y-1] = true;
			dfs(x, y-1, count + 1);
			visited[x][y-1] = false;
		}
		if(y < m-1 && !visited[x][y+1] && map[x][y+1] == 1) { //우
			visited[x][y+1] = true;
			dfs(x, y+1, count + 1);
			visited[x][y+1] = false;
		}
	}
*/
