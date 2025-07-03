package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25682 {
    static int N, M, K;
    static char[][] chessBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //�Է¹޴� ü������ ��
        M = Integer.parseInt(st.nextToken()); //�Է¹޴� ü������ ��
        K = Integer.parseInt(st.nextToken()); //�������ϴ� ü����(K*K)

        chessBoard = new char[N][M];

        char[] tmp;

        for(int i = 0; i < N; i++){
            tmp = br.readLine().toCharArray(); //���پ� �Է¹޾Ƽ� �ش� ���ڵ��� ���ڿ� 1���� �迭�� ����
            for(int j = 0; j < M; j++) {
                chessBoard[i][j] = tmp[j]; //ü���ǿ� �ϳ��ϳ��� ����
            }
        }

        int[][] prefixSumBlack = prefixSum('B'); //������ �����ϴ� ü������ ������(��ü)
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(prefixSumBlack[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] prefixSumWhite = prefixSum('W'); //ȭ��Ʈ�� �����ϴ� ü������ ������(��ü)
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(prefixSumWhite[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(Math.min(cutChessBoard(prefixSumBlack), cutChessBoard(prefixSumWhite)));
    }

    //ü���� KxK�� �ڸ���
    private static int cutChessBoard(int[][] prefixSum){
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int num = prefixSum[i + K - 1][j + K - 1] - prefixSum[i - 1][j + K - 1] - prefixSum[i + K - 1][j - 1] + prefixSum[i - 1][j - 1];
                result = Math.min(num, result);
            }
        }
        return result;
    }

    //ü�� ������ ���ϱ�
    private static int[][] prefixSum(char color){
        int[][] tmp = new int[N+1][M+1];

        for(int i = 0; i < N; i++){
            for(int j = 0;  j < M; j++){
                //���簡 ������ ȭ��Ʈ������ ���� ���� (�ش� �Ķ���� color�� ���� �ٲ���ϴ� ��� 1 �ƴ� ��� 0)
                int currentValue = 0;

                if((i+j) % 2 == 0){ //ü������ ���ڸ� �յ��ϰ� ĥ�ϱ� ����
                    //->(i + j) % 2�� 0�̸�, i�� j�� ���� ¦���̹Ƿ� ¦�� ��� ¦�� ���� ��� ���� ������ ĥ����
                    currentValue = chessBoard[i][j] == color ? 0 : 1;
                }else{
                    currentValue =  chessBoard[i][j] != color ? 0 : 1;
                }

                tmp[i+1][j+1] = tmp[i+1][j] + tmp[i][j+1] - tmp[i][j] + currentValue;
            }
        }
        return tmp;
    }
}