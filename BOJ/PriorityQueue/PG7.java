package BOJ.PriorityQueue;

// "��ũ ��Ʈ�ѷ�"

import java.util.*;
/*
�Ź� pq�� flush ���� �ʿ�� ���ڳ�? pq���� �۾��� �ǽ��� �� �ִ� ������ ��鸸 �����ϱ�,
�� sequence���� �켱���� ���� �ָ� �ϳ��� �̾Ƽ� ó���ϰ� ������ �پ��ָ� �Ǵϱ�
 */
public class PG7 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // ��û �ð� �� ����
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // �۾��ð� ª�� ��

        int curTime = 0;
        int totalTime = 0;
        int jobIdx = 0;
        int completed = 0;

        while (completed < jobs.length) {
            // ���� �ð� ������ ��û�� job�� ��� ť�� �߰�
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= curTime) {
                pq.add(jobs[jobIdx++]);
            }

            // ť�� ��� ������ ���� job�� ��û�ð����� �ǳʶ�
            if (pq.isEmpty()) {
                curTime = jobs[jobIdx][0];
                continue;
            }

            // ���� ª�� �۾� ����
            int[] job = pq.poll();
            curTime += job[1]; // �۾� �ҿ�ð���ŭ ����
            totalTime += curTime - job[0]; // (���� �ð� - ��û�ð�)
            completed++;
        }

        return totalTime / jobs.length;
    }
}
/*
static int[][] jobs = {{1, 3}, {2, 9}, {1, 4}, {5, 5}};

    public static int solution() {
        // period ª����, request ���� ��, num ���� ��
        // ������ �տ� ��ġ�� (- 0 +)
        PriorityQueue<Job> pq = new PriorityQueue<>(
                (a,b) ->
                    a.period == b.period
                    ? (a.request == b.request
                            ? a.num - b.num
                            : a.request - b.request
                    )
                    : a.period - b.period
        );

        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // (1, 3)
        // (1, 4)
        // (2, 9)
        // (5, 5)

        int k = 0;
        for(int[] batch : jobs) {
            pq.add(new Job(k++, batch[0], batch[1]));
        }

        int curTime = 0;
        int[] avg = new int[jobs.length];

        while(!pq.isEmpty()) {
            Job job = pq.poll();
            if(curTime < job.request) {
                curTime = job.request;
            }
            curTime += job.period;
            System.out.println("curTime: "+curTime);
            avg[job.num] = curTime - job.request;
            System.out.println("["+job.num+"]: "+ (curTime - job.request));
        }

        int sum = 0;
        for(int av : avg) {
            sum += av;
        }

        System.out.println(sum/jobs.length);
        return sum/jobs.length;
    }

    public static class Job {
        int num;
        int request;
        int period;
        int turn = 0;

        public Job(int num, int request, int period) {
            this.num = num;
            this.request = request;
            this.period = period;
        }
    }
 */