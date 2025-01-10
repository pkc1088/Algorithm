import java.util.Scanner;

public class NDB_13_6 {

    static int N;
    static char[][] map;
    static int moveR[] = { -1, 1, 0, 0 };
    static int moveC[] = { 0, 0, -1, 1 };
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                String s = sc.next();
                map[i][j] = s.charAt(0);
            }

        }

        dfs(0, -1, 0);

        if(answer == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static void dfs(int r, int c, int cnt) {
        if(cnt == 3) {
            boolean yes = true;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] != 'T')
                        continue;

                    // 감시 가능한 학생이 존재하는지
                    boolean sw = findS(i, j);
                    // 감시 가능
                    if(sw == true) {
                        yes = false;
                        break;
                    }
                }
                // 감시 가능
                if(yes == false)
                    break;
            }
            // 감시 불가
            if(yes == true)
                answer = 1;
            return;
        }

        for(int i=c+1; i<N; i++) {  //처음에 i=0 초기화   //가로로 체크
            if(map[r][i] != 'X')
                continue;

            map[r][i] = 'O';
            dfs(r, i, cnt+1);
            map[r][i] = 'X';
        }

        for(int i=r+1; i<N; i++) {  //처음에 i=1 초기화   //세로롤 체크
            for(int j=0; j<N; j++) {
                if(map[i][j] != 'X')
                    continue;
                map[i][j] = 'O';
                dfs(i, j, cnt+1);
                map[i][j] = 'X';
            }
        }
    }

    static boolean findS(int r, int c) {

        for(int i=0; i<4; i++) {
            int nextR = r;
            int nextC = c;
            while(true) {
                nextR += moveR[i];
                nextC += moveC[i];
                if(nextR<0 || nextR>=N || nextC<0 || nextC>=N)
                    break;
                if(map[nextR][nextC] == 'O')
                    break;

                if(map[nextR][nextC] == 'S')
                    return true;

            }
        }

        return false;
    }

}

/*

//내 풀이 lil error? 
import java.io.*;
import java.util.*;
public class NDB_13-6 {
    public static int n;
    public static char[][] board;
    public static char[][] temp;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        temp = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        if(dfs(0))
            System.out.println("NO");
        else
            System.out.println("YES");
    }

    public static boolean dfs(int count) {
        if (count == 3) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][j] == 'T') {
                        for (int dir = 0; dir < 4; dir++) {
                            if(Collision_Check(i, j, dir)) {
                                return true;
                            }
                        }
                    }
                }
            }
            
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = 'O';
                    dfs(count+1);
                    board[i][j] = 'X';
                }
            }
        }
        return false;
    }

    public static boolean Collision_Check(int x, int y, int direction) {
        // 왼쪽 방향으로 감시
        if (direction == 0) {
            while (y >= 0) {
                if (temp[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (temp[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                y -= 1;
            }
        }
        // 오른쪽 방향으로 감시
        if (direction == 1) {
            while (y < n) {
                if (temp[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (temp[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                y += 1;
            }
        }
        // 위쪽 방향으로 감시
        if (direction == 2) {
            while (x >= 0) {
                if (temp[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (temp[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                x -= 1;
            }
        }
        // 아래쪽 방향으로 감시
        if (direction == 3) {
            while (x < n) {
                if (temp[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (temp[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                x += 1;
            }
        }
        return false;
    }

}
*/