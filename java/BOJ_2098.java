import java.io.*;
import java.util.*;

public class BOJ_2098 {

	static int n, statusFullBit, INF = 987654321;
	static int[][] w;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		statusFullBit = (1<<n) -1;
		w = new int[n][n];
		dp = new int[n][statusFullBit];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1)); // 0번도시 부터 탐색 시작 (check: 0001)
	}
	
	static int tsp(int x, int check) {
        
		// 모든 도시 방문 완료
		if(check == statusFullBit) {
			if(w[x][0] == 0) return INF; // 경로 없으면 INF로 탐색 무효화 (Math.min)
			else return w[x][0]; // 경로가 존재하면 w[x][0]
		}
        
		// 이미 방문한 도시 
		if(dp[x][check] != -1) return dp[x][check];
        
		// 해당 도시에 출석 표시
		dp[x][check] = INF;
        
		// 방문하지 않은 도시 탐색 
		for(int i=0; i<n; i++) {
			// next : i 도시 방문
			int next = check | (1<<i); 
            
			// 경로가 없거나 i 도시를 이미 방문했을 경우 continue 
			if(w[x][i] ==0 || (check & (1<<i)) != 0) continue;
			
			dp[x][check] = Math.min(dp[x][check], tsp(i, next) + w[x][i]);
		}
		
		return dp[x][check];
	}
}
/*
// 밑에껀 시간초과뜸
import java.io.*;
import java.util.*;

public class BOJ_2098 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static final int INF = 11000000;	
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        // i : 현재 위치한 도시, j : 지금까지 방문한 도시 2진수
        dp = new int[n][(1 << n) - 1];	
        // ex) 1 << 4 = 10000(2) = 16인데 우리의 최대값은 1111(2) 이므로 1 빼기

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int weight = Integer.parseInt(st.nextToken());
                map[i][j] = weight;
            }
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 1));
    }

    // 어느 도시에서 시작하든지 최소비용은 같기 때문에 편안하게 0번도시부터 시작하자
    // city - 현재 위치한 도시 인덱스, visitBitMask - 지금까지 방문한 도시 2진수
    public static int dfs(int city, int visitBitmask) {

        if(visitBitmask == (1 << n) - 1) {	// 모든 도시를 방문했다면
            if(map[city][0] == 0) {	// 이런 경우는 거의 없겠지만, 혹시 발생하는 경우 예외 처리
                return INF;
            }

            return map[city][0];	// 현재 도시 -> 0번(시작) 도시 이동 거리
        }

        if(dp[city][visitBitmask] != INF) {	// dp값이 존재하는경우
            return dp[city][visitBitmask];
        }

        for(int i = 0; i < n; i++) {// 현재 도시에서 각 i의 도시로 이동한 경우에 대해 DFS 수행
            if((visitBitmask & (1 << i)) == 0 && map[city][i] != 0) {
            // 한 번이라도 그 도시를 방문했는데 다시 그 도시를 방문하는 경우 예외처리
            //d[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때, 
            // 방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용.
            //즉, 방문해야하는 도시(여기에 시작지점으로 돌아오는 것 포함) 들까지 가는 최소 비용
                dp[city][visitBitmask] = Math.min(dp[city][visitBitmask], 
                        dfs(i, visitBitmask | (1 << i)) + map[city][i]);	
            // dfs(다음 도시, 다음도시 방문했다고 가정)
            // + 여기서 다음 도시까지의 거리 와 최소거리 비교
            }
        }

        return dp[city][visitBitmask];
    }
}
*/