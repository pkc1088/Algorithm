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

        N = Integer.parseInt(st.nextToken()); //입력받는 체스판의 행
        M = Integer.parseInt(st.nextToken()); //입력받는 체스판의 열
        K = Integer.parseInt(st.nextToken()); //만들어야하는 체스판(K*K)

        chessBoard = new char[N][M];

        char[] tmp;

        for(int i = 0; i < N; i++){
            tmp = br.readLine().toCharArray(); //한줄씩 입력받아서 해당 문자들을 문자열 1차원 배열로 넣음
            for(int j = 0; j < M; j++) {
                chessBoard[i][j] = tmp[j]; //체스판에 하나하나씩 넣음
            }
        }

        int[][] prefixSumBlack = prefixSum('B'); //블랙으로 시작하는 체스판의 누적합(전체)
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(prefixSumBlack[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] prefixSumWhite = prefixSum('W'); //화이트로 시작하는 체스판의 누적합(전체)
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(prefixSumWhite[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(Math.min(cutChessBoard(prefixSumBlack), cutChessBoard(prefixSumWhite)));
    }

    //체스판 KxK로 자르기
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

    //체스 누적합 구하기
    private static int[][] prefixSum(char color){
        int[][] tmp = new int[N+1][M+1];

        for(int i = 0; i < N; i++){
            for(int j = 0;  j < M; j++){
                //현재가 블랙인지 화이트인지에 따라 결정 (해당 파라미터 color에 맞춰 바꿔야하는 경우 1 아닌 경우 0)
                int currentValue = 0;

                if((i+j) % 2 == 0){ //체스판의 격자를 균등하게 칠하기 위해
                    //->(i + j) % 2가 0이면, i와 j의 합이 짝수이므로 짝수 행과 짝수 열이 모두 같은 색으로 칠해짐
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