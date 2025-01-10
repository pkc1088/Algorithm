import java.io.*;
import java.util.*;
public class BOJ_2618 {
    static class point {
        int x, y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, W;
    static point[] event;
    static int[][] dp;
    // dp[i][j] = 1�� �������� i�� ����� ó���߰�, 2�� �������� j�� ����� ó�������� �ּҺ��
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        event = new point[W + 1];

        StringTokenizer st;
        int y, x;
        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            event[i] = new point(x, y);
        }

        dp = new int[W + 1][W + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        sb = new StringBuilder();
        sb.append(getTotDistance(0, 0) + "\n");

        getPath(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int getTotDistance(int police1, int police2) {
        // 1. Ż������
        if (police1 == W || police2 == W) {
            return 0;
        }

        // 2. �̹� ����� dp�� ����ġ��
        if (dp[police1][police2] != -1) {
            return dp[police1][police2];
        }

        // ���� ��� ��ȣ
        int next = Math.max(police1, police2) + 1;

        int dist1, dist2;
        // ���� 1�� ���ݱ����� �Ÿ�
        if (police1 == 0) {
            dist1 = getDist(1, 1, event[next].x, event[next].y);
        } else {
            dist1 = getDist(event[police1].x, event[police1].y,
                            event[next].x, event[next].y);
        }

        // ���� 2�� ���ݱ����� �Ÿ�
        if (police2 == 0) {
            dist2 = getDist(N, N, event[next].x, event[next].y);
        } else {
            dist2 = getDist(event[police2].x, event[police2].y,
                            event[next].x, event[next].y);
        }

        // result1 : ����1�� ���� �ذ��� ���
        int result1 = dist1 + getTotDistance(next, police2);
        // result2 : ����2�� ���� �ذ��� ���
        int result2 = dist2 + getTotDistance(police1, next);

        // �ּڰ�
        return dp[police1][police2] = Math.min(result1, result2);
    }

    static void getPath(int police1, int police2) {
        if (police1 == W || police2 == W)
            return;

        int next = Math.max(police1, police2) + 1;
        int dist1, dist2;

        if (police1 == 0) {
            dist1 = getDist(1, 1, event[next].x, event[next].y);
        } else {
            dist1 = getDist(event[police1].x, event[police1].y,
                            event[next].x, event[next].y);
        }

        if (police2 == 0) {
            dist2 = getDist(N, N, event[next].x, event[next].y);
        } else {
            dist2 = getDist(event[police2].x, event[police2].y,
                            event[next].x, event[next].y);
        }

        if (dp[next][police2] + dist1 < dp[police1][next] + dist2) {
            sb.append("1\n");
            getPath(next, police2);
        } else {
            sb.append("2\n");
            getPath(police1, next);
        }
    }

    static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

}
