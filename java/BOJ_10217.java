import java.util.*;
import java.io.*;


public class BOJ_10217 {
    static class Airport implements Comparable<Airport> {
        int number;
        int money;
        int time;


        Airport(int number, int money, int time) {
            this.number = number;
            this.time = time;
            this.money = money;
        }

        @Override
        public int compareTo(Airport o) {
            if(this.time < o.time) {
                return -1;
            }
            else if(this.time == o.time) {
                if(this.money < o.money) {
                    return -1;
                }
                return 0;
            }
            return 1;
        }
    }

    static ArrayList<ArrayList<Airport>> graph;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(tc --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dp = new int[n + 1][m + 1];
            // 시작 공항부터 i 공항까지 j의 비용을 소비하며 이동한 시간 중 최소 시간
            // 이미 M원 이내를 충족했기 때문에, M원 이내로 이동한 경우 중 최단 시간을 찾아내야 하기 때문
            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                Arrays.fill(dp[i], INF);
            }

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken()); // 비용
                int d = Integer.parseInt(st.nextToken()); // 소요시간
                graph.get(u).add(new Airport(v, c, d));
            }

            dijkstra(n, m, 1);

            int min = INF;
            for(int i = 0; i <= m; i++) { // 가장 최소 시간을 구해보자
                min = Math.min(min, dp[n][i]);
            }

            if(min == INF) { // 도착하지 못했을 때
                sb.append("Poor KCM");
            }
            else {
                sb.append(min);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dijkstra(int n, int m, int start) {
        PriorityQueue<Airport> pq = new PriorityQueue<Airport>();
        pq.offer(new Airport(start, 0, 0));
        dp[start][0] = 0;

        while(!pq.isEmpty()) {
            Airport airport = pq.poll();
            int nowAirport = airport.number;
            int nowMoney = airport.money;
            int nowTime = airport.time;

            if(nowAirport == n) { // 최단 시간에 목적지 도착. n은 LA
                break;
            }

            for(Airport air : graph.get(nowAirport)) {
                int nextNum = air.number;
                int nextMoney = air.money + nowMoney;
                int nextTime = air.time + nowTime;

                if(nextMoney > m) {
                    continue;
                }

                if(dp[nextNum][nextMoney] <= nextTime) {
                    // 이미 해당 금액으로 해당 번 공항으로 왔을 때의
                    // 최소 시간보다 크면 업데이트할 의미가 없다.
                    continue;
                }

                // 불필요한 삽입 방지를 위해 그 이상의 모든 값에 현재 최단시간 값을 설정해준다.
                // 그래야 위 조건에 부합해서 continue 떠서 넘어가지.
                for(int j = nextMoney; j <= m; j++){
                    if(dp[nextNum][j] > nextTime) {
                        dp[nextNum][j] = nextTime;
                    }
                }

                dp[air.number][nextMoney] = nextTime;
                pq.offer(new Airport(air.number, nextMoney, nextTime));
            }
        }
    }
}
