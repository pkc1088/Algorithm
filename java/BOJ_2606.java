import java.io.*;
import java.util.*;

public class BOJ_2606 {
    static int[][] check; //���� �������
    static boolean[] checked; //Ȯ�� ����
    static int com; //��������
    static int num; //��������
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

        dfs(1); //dfsȣ��
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
