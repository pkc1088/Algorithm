package BOJ.Kakao.Lv2;

import java.util.*;

class PG_������4��� {
    static String[][] board;
    static boolean[][] visit;
    static int n, m;

    public int solution(int tn, int tm, String[] bd) {
        n = tn;
        m = tm;
        board = new String[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = bd[i];
            for (int j = 0; j < m; j++) {
                board[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int totalRemoved = 0;
        while (true) {
            int removed = checkAndMark();
            if (removed == 0) break; // �� �̻� ����� ������ ����
            totalRemoved += removed;
            gravity();
        }

        return totalRemoved;
    }

    // 2x2 ��� üũ
    public int checkAndMark() {
        visit = new boolean[n][m]; // �Ź� ���� �ʱ�ȭ
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                String cur = board[i][j];
                if (cur.equals("x")) continue;
                if (cur.equals(board[i + 1][j]) &&
                        cur.equals(board[i][j + 1]) &&
                        cur.equals(board[i + 1][j + 1])) {
                    visit[i][j] = visit[i + 1][j] = visit[i][j + 1] = visit[i + 1][j + 1] = true;
                }
            }
        }

        // ���� ���� + ���� ����
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) {
                    board[i][j] = "x";
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // �߷� ����
    public void gravity() {
        for (int c = 0; c < m; c++) {
            List<String> temp = new ArrayList<>();

            // �Ʒ������� ���� �о ���� ��ϸ� temp�� ����
            for (int r = n - 1; r >= 0; r--) {
                if (!board[r][c].equals("x")) {
                    temp.add(board[r][c]);
                }
            }

            // �ٽ� �Ʒ��������� ä���
            int idx = 0;
            for (int r = n - 1; r >= 0; r--) {
                if (idx < temp.size()) board[r][c] = temp.get(idx++);
                else board[r][c] = "x";
            }
        }
    }
}
