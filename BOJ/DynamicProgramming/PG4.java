package BOJ.DynamicProgramming;

// "N���� ǥ��"
import java.util.*;

class PG4 {
    public int solution(int N, int number) {
        // dp[i] = N�� i�� ����ؼ� ���� �� �ִ� ���� ����
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            // NNN... (i�� �̾���� ����)
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeated);

            // j�� + (i-j)�� ����
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            // ��ǥ�� ã���� �ٷ� ��ȯ
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
