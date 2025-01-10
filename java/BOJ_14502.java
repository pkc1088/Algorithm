import java.io.*;
import java.util.*;
public class BOJ_14502 {
    public static int n, m, result = 0;
    public static int[][] arr = new int[8][8]; // �ʱ� �� �迭
    public static int[][] temp = new int[8][8]; // ���� ��ġ�� ���� �� �迭

    // 4���� �̵� ���⿡ ���� �迭
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // ���� �켱 Ž��(DFS)�� �̿��� �� ���̷����� ������� �������� �ϱ�
    public static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // ��, ��, ��, �� �߿��� ���̷����� ���� �� �ִ� ���
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == 0) {
                    // �ش� ��ġ�� ���̷��� ��ġ�ϰ�, �ٽ� ��������� ����
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    // ���� �ʿ��� ���� ������ ũ�� ����ϴ� �޼���
    public static int getScore() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    }

    // ���� �켱 Ž��(DFS)�� �̿��� ��Ÿ���� ��ġ�ϸ鼭, �� �� ���� ������ ũ�� ���
    public static void dfs(int count) {
        // ��Ÿ���� 3�� ��ġ�� ���
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            // �� ���̷����� ��ġ���� ���� ����
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            // ���� ������ �ִ밪 ���
            result = Math.max(result, getScore());
            return;
        }
        // �� ������ ��Ÿ���� ��ġ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    count += 1;
                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
            dfs(0);
            System.out.println(result);
    }
}

