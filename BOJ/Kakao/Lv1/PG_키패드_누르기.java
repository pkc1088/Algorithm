package BOJ.Kakao.Lv1;

import java.util.*;

public class PG_키패드_누르기 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Map<Integer, int[]> map = new HashMap<>();
    static int left = 10, right = 11;

    public String solution(int[] num, String hand) {
        map.put(1, new int[]{0,0});
        map.put(2, new int[]{0,1});
        map.put(3, new int[]{0,2});
        map.put(4, new int[]{1,0});
        map.put(5, new int[]{1,1});
        map.put(6, new int[]{1,2});
        map.put(7, new int[]{2,0});
        map.put(8, new int[]{2,1});
        map.put(9, new int[]{2,2});
        map.put(10, new int[]{3,0});
        map.put(0, new int[]{3,1});
        map.put(11, new int[]{3,2});

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length; i++) {
            if(num[i] == 1 || num[i] == 4 || num[i] == 7) {
                left = num[i];
                sb.append("L");
            } else if (num[i] == 3 || num[i] == 6 || num[i] == 9) {
                right = num[i];
                sb.append("R");
            } else {
                int left_len = bfs(left, num[i]);
                int right_len = bfs(right, num[i]);

                if(left_len < right_len) {
                    left = num[i];
                    sb.append("L");
                } else if(left_len > right_len) {
                    right = num[i];
                    sb.append("R");
                } else if(left_len == right_len) {
                    if(hand.equals("right")) { right = num[i]; sb.append("R"); }
                    else { left = num[i]; sb.append("L"); }
                }
            }
        }

        return sb.toString();
    }

    public int bfs(int src, int trg) {
        int sr = map.get(src)[0], sc = map.get(src)[1];
        int tr = map.get(trg)[0], tc = map.get(trg)[1];
        int[][] dis = new int[4][3];
        dis[3][0] = dis[3][2] = -1;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, 0});

        while(!q.isEmpty()) {
            int[] dto = q.poll();

            if(dto[0] == tr && dto[1] == tc) {
                return dto[2];
            }

            for(int i = 0; i < 4; i++) {
                int nr = dr[i] + dto[0];
                int nc = dc[i] + dto[1];
                int step = dto[2];
                if(nr < 0 || nr > 3) continue;
                if(nc < 0 || nc > 2) continue;
                if(dis[nr][nc] == -1) continue; // 샾별

                q.offer(new int[]{nr, nc, step + 1});
            }

        }
        return -100;
    }
}
