package BOJ.DynamicProgramming;

// "N으로 표현"
import java.util.*;

class PG4 {
    public int solution(int N, int number) {
        // dp[i] = N을 i번 사용해서 만들 수 있는 숫자 집합
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            // NNN... (i번 이어붙인 숫자)
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeated);

            // j번 + (i-j)번 조합
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

            // 목표값 찾으면 바로 반환
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
