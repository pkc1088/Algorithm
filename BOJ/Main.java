package BOJ;

import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }

        // �÷��̵� �ͼ� �˰��� ����
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        print(V, arr);

        int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }

                // �ڱ� �ڽ��� ������ �� ������
                // ���ο��� ���� ��ΰ� �ִٸ�, ����Ŭ�� �����Ѵٴ� ��.
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }

        // ans�� �ʱⰪ�̸� ����Ŭ�� �������� ����.
        ans = (ans == INF) ? -1 : ans;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void print(int V, int[][] arr) {
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if(arr[i][j] == INF) System.out.print("-1 ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}