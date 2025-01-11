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

