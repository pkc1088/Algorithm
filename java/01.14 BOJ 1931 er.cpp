import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());	// ���۽ð�
            time[i][1] = Integer.parseInt(st.nextToken());	// ����ð�
        }
        // ������ �ð��� �������� �����ϱ� ���� compare ������
        Arrays.sort(time, (o1, o2) -> {
            // ����ð��� ���� ��� ���۽ð��� ���������� �����ؾ��Ѵ�.
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int prev_end_time = 0;
        for(int i = 0; i < N; i++) {
            // ���� ����ð��� ���� ȸ�� ���� �ð����� �۰ų� ���ٸ� ����
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
