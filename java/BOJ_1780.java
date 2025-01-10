import java.io.*;
import java.util.*;

public class BOJ_1780 {
    public static int minus = 0;
    public static int zero = 0;
    public static int plus = 0;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if(board[row][col] == 0) {
                zero++;
            }
            else if(board[row][col] == -1){
                minus++;
            }
            else if(board[row][col] == 1) {
                plus++;
            }
            return;
        }

        int newSize = size / 3;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + newSize*2, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + newSize*2, newSize);
        partition(row + newSize*2, col, newSize);
        partition(row + newSize*2, col + newSize, newSize);
        partition(row + newSize*2, col + newSize*2, newSize);
    }

    // 현재 파티션의 컬러가 같은지 체크한다.
    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];	// 첫 번째 원소를 기준으로 검사
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
