import java.io.*;
import java.util.*;

public class BOJ_1260 {
    static int[][] check; //간선 연결상태
    static boolean[] checked; //확인 여부
    static int n; //정점개수
    static int m; //간선개수
    static int start; //시작정점

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        check = new int[1001][1001];
        checked = new boolean[1001];

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            check[x][y] = check[y][x] = 1;
        }

        dfs(start); //dfs호출

        checked = new boolean[1001]; //확인상태 초기화
        System.out.println(); //줄바꿈

        bfs(); //bfs호출
    }

    public static void dfs(int i) {
        checked[i] = true;
        System.out.print(i + " ");

        for(int j = 1; j <= n; j++) {
            if(check[i][j] == 1 && !checked[j]) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        checked[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int j = 1; j <= n; j++) {
                if(check[temp][j] == 1 && !checked[j]) {
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
} 
