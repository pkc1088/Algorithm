package BOJ.Kakao.Lv1;

import java.util.*;

public class PG_ũ����_�����̱�_���� {
    public int solution(int[][] board, int[] moves) {
        // �ٱ����� ���� ���� ���� ����, �� �ؿ� ������ �����ؾ���. <- �̰͵� stack���� ����
        ArrayList<Stack<Integer>> arrStk = new ArrayList<>();
        for(int i = 0; i < board.length; i++) arrStk.add(new Stack<Integer>());

        for(int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != 0) arrStk.get(j).push(board[i][j]);
            }
        }
        Stack<Integer> bag = new Stack<>();

        int ans = 0;
        for(int i = 0; i < moves.length; i++) {
            if(arrStk.get(moves[i] - 1).isEmpty()) continue;

            int cur = arrStk.get(moves[i] - 1).pop();

            if(!bag.isEmpty() && bag.peek() == cur) {
                bag.pop();
                ans++;
            }

            else bag.push(cur);
        }

        return ans * 2;
    }
}