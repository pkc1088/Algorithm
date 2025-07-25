import java.io.*;
import java.util.*;
//error
public class NDB_4_4 {
    static int d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] board = new int[N][M];
        boolean [][] bVisited = new boolean[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    bVisited[i][j] = true;
                else
                    bVisited[i][j] = false;
            }
        }

        Outer :
        while(true) {
            switch(d) {
                case 0 :
                    if(board[x-1][y] == 0 && !bVisited[x-1][y]) {
                        x--;
                        cnt++;
                    }
                    d=3;
                    break;
                case 1 :
                    if(board[x][y-1] == 0 && !bVisited[x][y-1]) {
                        y--;
                        cnt++;
                    }
                    d=0;
                    break;
                case 2 :
                    if(board[x+1][y] == 0 && !bVisited[x+1][y]) {
                        x++;
                        cnt++;
                    }
                    d=1;
                    break;
                case 3 :
                    if(board[x][y+1] == 0 && !bVisited[x][y+1]) {
                        y++;
                        cnt++;
                    }
                    d=2;
                    break;
            }
            if(bVisited[x-1][y]&&bVisited[x+1][y]&&bVisited[x][y-1]&&bVisited[x][y+1]) {
                switch(d) {
                        case 0 : if(board[x][y+1] != 1) y++; else break Outer; break;
                        case 1 : if(board[x+1][y] != 1) x++; else break Outer; break;
                        case 2 : if(board[x][y-1] != 1) y--; else break Outer; break;
                        case 3 : if(board[x-1][y] != 1) x--; else break Outer; break;
                }
            }
        }
        System.out.println(cnt);
    }
}

/*
import java.util.*;

public class NDB_4-4 {

    public static int n, m, x, y, direction;
    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];
    // 전체 맵 정보
    public static int[][] arr = new int [50][50];

    // 북, 동, 남, 서 방향 정의
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        
        // 현재 캐릭터의 X 좌표, Y 좌표, 방향을 입력받기
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1; // 현재 좌표 방문 처리

        // 전체 맵 정보를 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 시뮬레이션 시작
        int cnt = 1;
        int turn_time = 0;
        while (true) {
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else turn_time += 1;
            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
                turn_time = 0;
            }
        }

        System.out.println(cnt);
    }

}
*/
