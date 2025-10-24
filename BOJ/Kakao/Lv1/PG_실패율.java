package BOJ.Kakao.Lv1;
import java.util.*;

public class PG_실패율 {
    public int[] solution(int N, int[] stages) {
        int totalPlayers = stages.length;
        int[] count = new int[N + 2]; // 인덱스: 1..N, N+1은 클리어한 사람들
        for (int s : stages) {
            if (s <= N) count[s]++;
            else count[N+1]++; // 혹시 필요하면
        }

        double[] fail = new double[N + 1]; // 1..N
        int remain = totalPlayers;
        for (int i = 1; i <= N; i++) {
            if (remain == 0) {
                fail[i] = 0.0;
            } else {
                fail[i] = (double) count[i] / remain;
            }
            remain -= count[i];
        }

        // 스테이지 번호 리스트 만들고 실패율로 정렬
        Integer[] stagesIdx = new Integer[N];
        for (int i = 0; i < N; i++) stagesIdx[i] = i + 1;

        Arrays.sort(stagesIdx, (a, b) -> {
            if (fail[b] == fail[a]) return Integer.compare(a, b); // 실패율 같으면 작은 번호 우선
            return Double.compare(fail[b], fail[a]); // 실패율 큰 순
        });

//         Arrays.sort(stagesIdx, (a, b) -> (fail[a] == fail[b])
//                         ? b-a
//                         : ( (fail[a] > fail[b]) ? a-b : b-a)
//                    );

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = stagesIdx[i];
        return answer;
    }
}