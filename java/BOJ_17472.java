import java.io.*;
import java.util.*;

public class BOJ_17472 {

    static class Node implements Comparable<Node>{
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

    }

    static int n,m, islandCnt;
    static int[][] map;
    static boolean[][] check;
    static int[] parents;
    static Queue<int[]> q;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        islandCnt = 2;
        check = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==1 && !check[i][j]) {
                    BFS(j, i, islandCnt);
                    islandCnt++;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]!=0) {
                    makeBridge(j, i, map[i][j]);
                }
            }
        }

        islandCnt--;
        parents = new int[islandCnt];
        for(int i=1; i<islandCnt; i++) {
            parents[i] = i;
        }
        int answer = shortestPath();
        System.out.println(answer == 0 ? -1 : answer);

    }

    // 1번 로직 (그래프 색칠)
    static void BFS(int x, int y, int idx) {
        q = new LinkedList<>();

        q.add(new int[] {x,y});
        map[y][x] = idx;
        check[y][x] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for(int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx<0 || ny <0 || nx > m-1 || ny > n-1 || check[ny][nx])
                    continue;

                if(map[ny][nx]==1) {
                    map[ny][nx] = idx;
                    check[ny][nx] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }

    // 2번 로직 (그래프 연결)
    static void makeBridge(int x, int y, int idx) {
        q = new LinkedList<>();
        check = new boolean[n][m];

        for(int d=0; d<4; d++) {
            q.add(new int[] {x,y,0});
            check[y][x] = true;

            while(!q.isEmpty()) {
                int[] p = q.poll();
                int px = p[0];
                int py = p[1];
                int move = p[2];

                int nx = px + dx[d];
                int ny = py + dy[d];

                if(nx<0 || ny <0 || nx > m-1 || ny > n-1 || check[ny][nx])
                    continue;

                if(map[ny][nx]!=idx) {
                    if(map[ny][nx] !=0) {
                        int from = idx-1;
                        int to = map[ny][nx]-1;
                        int bridgeLen = move;

                        if(bridgeLen>1) {
                            pq.add(new Node(from, to, bridgeLen));
                            break;
                        }
                    }
                    else {
                        check[ny][nx] = true;
                        q.add(new int[] {nx, ny, move+1});
                    }
                }
            }
            q.clear();
        }
    }

    // 3번 로직 (최소 신장트리 -크루스칼)
    static int shortestPath() {
        int sum =0;
        int size = pq.size();
        for(int i=0; i< size; i++) {
            Node node = pq.poll();
            int x = node.from;
            int y = node.to;

            if(find(x) != find(y)) {
                sum += node.value;
                union(x,y);
            }
        }

        int rx = parents[1];
        for(int i=2; i<islandCnt; i++) {
            if(rx != find(parents[i])) {
                // System.out.println("연결 x ");
                return 0;
            }
        }

        return sum;
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x<y) {
            parents[y]=x;
        }
        else {
            parents[x] =y;
        }
    }
}

/*
public class BOJ_17472 {

	static int N, M, min;
	static int[][] map;
	// dfs - 정점
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	// 정점
	static int V = 0;

	// 크루스칼 - edge
	static int[] parent;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1,e2)->e1.cost -e2.cost);
	static long sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())*(-1);
			}
		}

		// 정점
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == -1 && !visited[i][j]) {
					dfs(i, j, num);
					num++;
				}
			}
		}

		V = num-1;
		parent = new int[V+1];
		makeSet(V);

		// 간선
		hr();
		vr();

		// 크루스칼
		int cnt = 0;
		while(!pqueue.isEmpty()) {

			Edge e = pqueue.poll();

			if(findSet(e.v1) == findSet(e.v2)) continue;
			union(e.v1, e.v2);

			min += e.cost;
			cnt++;

			if(cnt == V-1) break;
		}

		if(cnt!=V-1) min = -1;
		System.out.println(min==0 ? -1 : min);

	}

	static void makeSet(int num) {
		for (int i = 1; i <= num; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]); // 매번 부모를 찾은 것들을 업데이트 해주는 방법/대신 충분히 정리되었는데도 계속 해서 연산 늘어남
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px < py) parent[py] = px;
		else parent[px] = py;
	}

	static void addEdge(int v1, int v2, int cost) {
		Iterator<Edge> itr = pqueue.iterator();
		boolean same = false;

		while(itr.hasNext()) {
			Edge e = itr.next();
			if(e.v1 == v1 && e.v2 == v2) {
				same = true;
				if(e.cost > cost) e.cost = cost;
			}
		}

		if(!same) pqueue.offer(new Edge(v1,v2,cost));
	}

	// 수평 거리 계산
	static void hr() {

        for (int i = 0; i < N; i++) {
            int prev = 0;
            int curr = 0;
            int v1 = 0;
            int v2 = 0;
            int cost = 0;
            for (int j = 0; j < M; j++) {
                curr = map[i][j];
                if( prev == 0 && curr != 0 ) { // 0 (바다) => 0 아님 (섬)

                    if( v1 == 0 ) v1 = curr;  // 시작 섬
                    else {
                        // edge 발생
                        v2 = curr;
//                        System.out.println(v1 + "---" + v2 + " : " + cost );
                        if( cost > 1 ) {
                            // addEdge 에서 동일 다리가 있으면 최소값으로 갱신하고 없으면 넣는다.
                            addEdge(v1, v2, cost);
                            //addEdge(v2, v1, cost); // 쿠르스칼은 한쪽 만 해도 해결
                        }
                        v1 = v2;
                        v2 = 0;
                        cost = 0;
                    }
                }else if( v1 != 0 && curr == 0 ) {
                    cost++;
                }

                prev = curr;
            }
        }
    }

	// 수직 거리 계산
    static void vr() {

        for (int i = 0; i < M; i++) {
            int prev = 0;
            int curr = 0;
            int v1 = 0;
            int v2 = 0;
            int cost = 0;
            for (int j = 0; j < N; j++) {
                curr = map[j][i];
                if( prev == 0 && curr != 0 ) {
                    if( v1 == 0 ) v1 = curr;
                    else {
                        // edge 발생
                        v2 = curr;
//                        System.out.println(v1 + "---" + v2 + " : " + cost );
                        if( cost > 1 ) {
                            addEdge(v1, v2, cost);
                            //addEdge(v2, v1, cost); // 쿠르스칼은 한쪽 만 해도 해결
                        }
                        v1 = v2;
                        v2 = 0;
                        cost = 0;
                    }
                }else if( v1 != 0 && curr == 0 ) {
                    cost++;
                }

                prev = curr;
            }
        }
    }

	static void dfs(int y, int x, int num) {
		visited[y][x] = true;
		map[y][x] = num;

		for (int k = 0; k < 4; k++) {
			int ny = y+dy[k];
			int nx = x+dx[k];

			if(ny<0||nx<0||ny>=N||nx>=M||visited[ny][nx]) continue;
			if(map[ny][nx] == -1) dfs(ny,nx,num);
		}
	}

	static class Edge{
		int v1;
		int v2;
		int cost;

		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", cost=" + cost + "]";
		}

	}
}
 */
