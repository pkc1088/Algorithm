package BOJ.Kakao.Lv2;

import java.util.*;

class PG_이모티콘_할인행사 {
    static int[] dc = {40, 30, 20, 10};
    static int[] adj_dc;
    static int emolen;
    static List<int[]> results = new ArrayList<>();

    public int[] solution(int[][] users, int[] emo) {
        emolen = emo.length;
        adj_dc = new int[emolen];

        dfs(0, users, emo);

        // 가장 좋은 결과 선택
        int[] best = {0, 0}; // {가입자 수, 매출}
        for (int[] r : results) {
            if (r[0] > best[0]) best = r;
            else if (r[0] == best[0] && r[1] > best[1]) best = r;
        }

        return best;
    }

    public void dfs(int idx, int[][] users, int[] emo) {
        if (idx == emolen) {
            int[] res = check(users, adj_dc, emo);
            results.add(res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            adj_dc[idx] = dc[i];
            dfs(idx + 1, users, emo);
        }
    }

    public int[] check(int[][] users, int[] discount, int[] emo) {
        int plus = 0;
        int revenue = 0;

        for (int[] u : users) {
            int userBuy = 0;
            for (int j = 0; j < emo.length; j++) {
                if (discount[j] >= u[0]) {
                    userBuy += emo[j] * (100 - discount[j]) / 100.0;
                }
            }

            if (userBuy >= u[1]) plus++;
            else revenue += userBuy;
        }

        return new int[]{plus, revenue};
    }
}