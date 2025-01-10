import java.io.*;
import java.util.*;


public class BOJ_7569 {
    static class PointXYZ{
        int height;
        int row;
        int col;

        public PointXYZ(int height, int row, int col){
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowArr[] = {-1, 0, 1, 0, 0, 0};
    static int colArr[] = {0, 1, 0, -1, 0, 0};
    static int heightArr[] = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int arr[][][];
    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h + 1][n + 1][m + 1];

        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) 
                        queue.add(new PointXYZ(i, j, k));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()){
            PointXYZ point = queue.poll();

            int height = point.height;
            int row = point.row;
            int col = point.col;

            for(int i = 0 ; i < 6; i++){
                int moveHeight = height + heightArr[i];
                int moveRow = row + rowArr[i];
                int moveCol = col + colArr[i];
                
                // 6방향으로 토마토가 익을 수 있는지 여부 확인
                if(checkPoint(moveHeight, moveRow, moveCol)){
                    // 익은 토마토를 큐에 추가
                    queue.add(new PointXYZ(moveHeight, moveRow, moveCol));
                    // 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
                    arr[moveHeight][moveRow][moveCol] = arr[height][row][col] + 1;
                }
            }
        }
        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= m; k++){
                    if(arr[i][j][k] == 0) 
                        return -1;
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }
        if(result == 1) 
            return 0;
        else 
            return (result - 1);
    }

    private static boolean checkPoint(int height, int row, int col){
        if(height < 1 || height > h || row < 1 || row > n || col < 1 || col > m) 
            return false;
        if(arr[height][row][col] == 0) 
            return true;
        else 
            return false;
    }
}
