package BOJ.Kakao.Lv1;
import java.util.*;

public class PG_������ {
    public int[] solution(int N, int[] stages) {
        int totalPlayers = stages.length;
        int[] count = new int[N + 2]; // �ε���: 1..N, N+1�� Ŭ������ �����
        for (int s : stages) {
            if (s <= N) count[s]++;
            else count[N+1]++; // Ȥ�� �ʿ��ϸ�
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

        // �������� ��ȣ ����Ʈ ����� �������� ����
        Integer[] stagesIdx = new Integer[N];
        for (int i = 0; i < N; i++) stagesIdx[i] = i + 1;

        Arrays.sort(stagesIdx, (a, b) -> {
            if (fail[b] == fail[a]) return Integer.compare(a, b); // ������ ������ ���� ��ȣ �켱
            return Double.compare(fail[b], fail[a]); // ������ ū ��
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