import java.io.*;
import java.util.*;

public class BOJ_2606 {
    static int[][] check; //간선 연결상태
    static boolean[] checked; //확인 여부
    static int com; //정점개수
    static int num; //간선개수
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        com = sc.nextInt();
        num = sc.nextInt();

        check = new int[101][101];
        checked = new boolean[101];

        for(int i = 0; i < num; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            check[x][y] = check[y][x] = 1;
        }

        dfs(1); //dfs호출
        System.out.println(cnt-1);

    }

    public static void dfs(int i) {
        checked[i] = true;
        cnt++;

        for(int j = 1; j <= com; j++) {
            if(check[i][j] == 1 && !checked[j]) {
                dfs(j);
            }
        }
    }

   
}
