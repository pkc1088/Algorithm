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
            // ���� ���׺��� i ���ױ��� j�� ����� �Һ��ϸ� �̵��� �ð� �� �ּ� �ð�
            // �̹� M�� �̳��� �����߱� ������, M�� �̳��� �̵��� ��� �� �ִ� �ð��� ã�Ƴ��� �ϱ� ����
            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                Arrays.fill(dp[i], INF);
            }

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken()); // ���
                int d = Integer.parseInt(st.nextToken()); // �ҿ�ð�
                graph.get(u).add(new Airport(v, c, d));
            }

            dijkstra(n, m, 1);

            int min = INF;
            for(int i = 0; i <= m; i++) { // ���� �ּ� �ð��� ���غ���
                min = Math.min(min, dp[n][i]);
            }

            if(min == INF) { // �������� ������ ��
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

            if(nowAirport == n) { // �ִ� �ð��� ������ ����. n�� LA
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
                    // �̹� �ش� �ݾ����� �ش� �� �������� ���� ����
                    // �ּ� �ð����� ũ�� ������Ʈ�� �ǹ̰� ����.
                    continue;
                }

                // ���ʿ��� ���� ������ ���� �� �̻��� ��� ���� ���� �ִܽð� ���� �������ش�.
                // �׷��� �� ���ǿ� �����ؼ� continue ���� �Ѿ��.
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
