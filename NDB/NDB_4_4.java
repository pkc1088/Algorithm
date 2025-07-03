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
    // �湮�� ��ġ�� �����ϱ� ���� ���� �����Ͽ� 0���� �ʱ�ȭ
    public static int[][] d = new int[50][50];
    // ��ü �� ����
    public static int[][] arr = new int [50][50];

    // ��, ��, ��, �� ���� ����
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    // �������� ȸ��
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M�� ������ �������� �����Ͽ� �Է¹ޱ�
        n = sc.nextInt();
        m = sc.nextInt();
        
        // ���� ĳ������ X ��ǥ, Y ��ǥ, ������ �Է¹ޱ�
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1; // ���� ��ǥ �湮 ó��

        // ��ü �� ������ �Է� �ޱ�
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // �ùķ��̼� ����
        int cnt = 1;
        int turn_time = 0;
        while (true) {
            // �������� ȸ��
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // ȸ���� ���� ���鿡 ������ ���� ĭ�� �����ϴ� ��� �̵�
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            // ȸ���� ���� ���鿡 ������ ���� ĭ�� ���ų� �ٴ��� ���
            else turn_time += 1;
            // �� ���� ��� �� �� ���� ���
            if (turn_time == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                // �ڷ� �� �� �ִٸ� �̵��ϱ�
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                // �ڰ� �ٴٷ� �����ִ� ���
                else break;
                turn_time = 0;
            }
        }

        System.out.println(cnt);
    }

}
*/
