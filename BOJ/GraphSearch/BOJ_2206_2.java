
package BOJ.GraphSearch;
import java.io.*;
import java.util.*;

public class BOJ_2206_2 {
    static int board_row, board_col;
    // 1. 맵 데이터는 변하지 않으므로 2차원 배열로 충분합니다.
    static int[][] board;
    // 2. 방문 여부와 차원을 별도로 관리하는 3차원 boolean 배열
    static boolean[][][] visited;

    static int[] move_row = {0, 0, -1, 1};
    static int[] move_col = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        board_row = Integer.parseInt(st.nextToken());
        board_col = Integer.parseInt(st.nextToken());

        board = new int[board_row][board_col];
        visited = new boolean[board_row][board_col][2]; // [0]: 벽 안 부순 세계, [1]: 벽 부순 세계

        for(int i = 0; i < board_row; i++) {
            String str = br.readLine();
            for(int j = 0; j < board_col; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

        print_0();
        System.out.println();
        print_1();
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        // 큐에는 {현재 행, 현재 열, 현재 스텝, 벽 부숨 여부} 를 넣습니다.
        q.offer(new int[]{0, 0, 1, 0});

        // 시작점 방문 처리
        visited[0][0][0] = true;
        visited[0][0][1] = true; // 우리가 알아냈던 최적화 (역주행 방지)

        while(!q.isEmpty()) {
            int[] dto = q.poll();
            int cur_row = dto[0];
            int cur_col = dto[1];
            int cur_step = dto[2];
            int ability_used = dto[3];

            // 목적지 도착 시 즉시 종료
            if (cur_row == board_row - 1 && cur_col == board_col - 1) {
                return cur_step;
            }

            for (int i = 0; i < 4; i++) {
                int next_row = cur_row + move_row[i];
                int next_col = cur_col + move_col[i];

                // 맵 밖으로 나가는 경우 패스
                if(0 > next_row || next_row >= board_row || 0 > next_col || next_col >= board_col) continue;

                // 시나리오 1: 다음 칸이 그냥 '빈 칸(0)'일 때
                if (board[next_row][next_col] == 0) {
                    // 현재 내 상태(ability_used)의 세계에서 아직 방문 안 했다면
                    if (!visited[next_row][next_col][ability_used]) {
                        visited[next_row][next_col][ability_used] = true;
                        q.offer(new int[]{next_row, next_col, cur_step + 1, ability_used});
                    }
                }
                // 시나리오 2: 다음 칸이 '벽(1)'일 때
                else if (board[next_row][next_col] == 1) {
                    // 내가 아직 벽을 부술 수 있는 상태(0)이고, 그 벽을 부순 세계[1]를 방문한 적 없다면
                    if (ability_used == 0 && !visited[next_row][next_col][1]) {
                        visited[next_row][next_col][1] = true; // 차원 전환 기록!
                        q.offer(new int[]{next_row, next_col, cur_step + 1, 1}); // 명찰을 1로 바꿔서 큐에 넣음
                    }
                }
            }
        }

        // 목적지에 도달하지 못하고 큐가 비었을 때
        return -1;
    }

    public static void print_0() {
        for (int i = 0; i < board_row; i++) {
            for (int j = 0; j < board_col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print_1() {
        for (int i = 0; i < board_row; i++) {
            for (int j = 0; j < board_col; j++) {
                System.out.print(visited[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < board_row; i++) {
            for (int j = 0; j < board_col; j++) {
                System.out.print(visited[i][j][1] + " ");
            }
            System.out.println();
        }
    }
}

/** 다른 방식(내 방식)
import java.io.*;
import java.util.*;

public class BOJ_2206_2 {
    static int board_row, board_col, break_scenario;
    static int[][][] board;
    static int[] move_row = {0, 0, -1, 1};
    static int[] move_col = {-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        board_row = Integer.parseInt(st.nextToken());
        board_col = Integer.parseInt(st.nextToken());
        break_scenario = 2;
        board = new int[board_row][board_col][break_scenario];

        for(int i = 0; i < board_row; i++) {
            String str = br.readLine();
            for(int j = 0; j < board_col; j++) {
                board[i][j][0] = board[i][j][1] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
        print_0();
        System.out.println();
        print_1();
    }

    public static int bfs() {

        q.offer(new int[]{0, 0, 1, 0}); // cr cc step ability_used
        board[0][0][0] = 1;
        board[0][0][1] = 1;

        while(!q.isEmpty()) {
            int[] dto = q.poll();
            int cur_row = dto[0];
            int cur_col = dto[1];
            int cur_step = dto[2];
            int ability_used = dto[3];

            if (cur_row == board_row - 1 && cur_col == board_col - 1) return cur_step;

            // ability_used 에 따라 애초에 분기 다르게 처리해야함 여기서 부터.
            if(ability_used == 0) {
                abilityNotUsedScenario(cur_row, cur_col, cur_step);
            } else {
                abilityUsedScenario(cur_row, cur_col, cur_step);
            }

        }

        return -1;
    }

    public static void abilityNotUsedScenario(int cur_row, int cur_col, int cur_step) {

        for (int i = 0; i < 4; i++) {
            int next_row = cur_row + move_row[i];
            int next_col = cur_col + move_col[i];
            int next_step = cur_step + 1;

            if(0 > next_row || next_row >= board_row) continue;
            if(0 > next_col || next_col >= board_col) continue;

            // 아직 벽뚫 가능한데 벽 만남.
            if(board[next_row][next_col][0] == 1) {

                q.offer(new int[]{next_row, next_col, next_step, 1});
                board[next_row][next_col][1] = next_step;
            }
            // 그냥 길 있음.
            else if(board[next_row][next_col][0] == 0) {

                q.offer(new int[]{next_row, next_col, next_step, 0});
                board[next_row][next_col][0] = next_step;
            }

        }
    }


    public static void abilityUsedScenario(int cur_row, int cur_col, int cur_step) {

        for (int i = 0; i < 4; i++) {
            int next_row = cur_row + move_row[i];
            int next_col = cur_col + move_col[i];
            int next_step = cur_step + 1;

            if(0 > next_row || next_row >= board_row) continue;
            if(0 > next_col || next_col >= board_col) continue;

            // 이미 벽뚫 소진했는데 벽 만남.
            if(board[next_row][next_col][1] == 1) {
                continue;
            }
            // 그냥 길 있음.
            else if(board[next_row][next_col][1] == 0) {

                q.offer(new int[]{next_row, next_col, next_step, 1});
                board[next_row][next_col][1] = next_step;
            }

        }
    }

    public static void print_0() {
        for (int i = 0; i < board_row; i++) {
            for (int j = 0; j < board_col; j++) {
                System.out.print(board[i][j][0] + " ");
            }
            System.out.println();
        }
    }

    public static void print_1() {
        for (int i = 0; i < board_row; i++) {
            for (int j = 0; j < board_col; j++) {
                System.out.print(board[i][j][1] + " ");
            }
            System.out.println();
        }
    }
}
*/
