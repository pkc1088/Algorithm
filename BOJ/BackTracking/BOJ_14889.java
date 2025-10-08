package BOJ.BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int N;
    static int[][] abil;
    static boolean[] recruited;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        abil = new int[N][N];
        recruited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                abil[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(Min);

    }
    // idx�� �ε���, count�� ���� ����(=��� ����)
    static void combi(int idx, int count) {
        // �� ������ �ϼ��� ���
        if(count == N / 2) {
			/*
			 �湮�� ���� �湮���� ���� ���� ���� ������
			 �� ���� ������ ���� �� �ּڰ��� ã�´�.
			*/
            diff();
            return;
        }
        for(int i = idx; i < N; i++) {
            // �湮���� �ʾҴٸ�?
            if(!recruited[i]) {
                recruited[i] = true;	// �湮���� ����
                combi(i + 1, count + 1);	// ��� ȣ��
                recruited[i] = false;	// ��Ͱ� ������ ��湮���� ����
            }
        }
    }
    // �� ���� �ɷ�ġ ���̸� ����ϴ� �Լ�
    static void diff() {
        int team_start = 0;
        int team_link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i ��° ����� j ��° ����� true��� ��ŸƮ������ ���� �÷���
                if (recruited[i] && recruited[j]) {
                    team_start += abil[i][j];
                    team_start += abil[j][i];
                }
                // i ��° ����� j ��° ����� false��� ��ũ������ ���� �÷���
                else if (!recruited[i] && !recruited[j]) {
                    team_link += abil[i][j];
                    team_link += abil[j][i];
                }
            }
        }
        // �� ���� ���� ���� (����)
        int val = Math.abs(team_start - team_link);
		/*
		  �� ���� �������� 0�̶�� ���� ���� �ּڰ��̱� ������
		  ���̻��� Ž�� �ʿ���� 0�� ����ϰ� �����ϸ� �ȴ�.
		 */
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        Min = Math.min(val, Min);
    }
}

/*
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Integer> list = new ArrayList<>();
    static int[] team;
    static boolean[] visit;
    static int[][] arr, brr;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n, m, e, v;
    static int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        team = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1);
        System.out.println(minV);
    }

    public static void dfs(int idx) {

        if (list.size() == n / 2) {
            System.out.println(list);
            minV = Math.min(minV, ability());
            if(minV == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = idx; i < n + 1; i++) {
            if(!visit[i]) {
                visit[i] = true;
                list.add(i);
                dfs(i);
                list.remove(Integer.valueOf(i));
                visit[i] = false;
            }
        }

    }

    public static int ability() { // 1,3,6   // 2,4,5
        int startSum = 0, linkSum = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(list.contains(i) && list.contains(j)) {
                    startSum += arr[i][j];
                } else if(!list.contains(i) && !list.contains(j)) {
                    linkSum += arr[i][j];
                }
            }
        }

        return Math.abs(startSum - linkSum);
    }

}

 */