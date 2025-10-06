package BOJ.PriorityQueue;

// "디스크 컨트롤러"

import java.util.*;
/*
매번 pq를 flush 해줄 필요는 없겠네? pq에는 작업을 실시할 수 있는 상태의 얘들만 넣으니까,
매 sequence마다 우선순위 높은 애를 하나씩 뽑아서 처리하고 점프만 뛰어주면 되니까
 */
public class PG7 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시간 순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 작업시간 짧은 순

        int curTime = 0;
        int totalTime = 0;
        int jobIdx = 0;
        int completed = 0;

        while (completed < jobs.length) {
            // 현재 시간 이전에 요청된 job을 모두 큐에 추가
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= curTime) {
                pq.add(jobs[jobIdx++]);
            }

            // 큐가 비어 있으면 다음 job의 요청시간으로 건너뜀
            if (pq.isEmpty()) {
                curTime = jobs[jobIdx][0];
                continue;
            }

            // 가장 짧은 작업 수행
            int[] job = pq.poll();
            curTime += job[1]; // 작업 소요시간만큼 진행
            totalTime += curTime - job[0]; // (끝난 시간 - 요청시간)
            completed++;
        }

        return totalTime / jobs.length;
    }
}
/*
static int[][] jobs = {{1, 3}, {2, 9}, {1, 4}, {5, 5}};

    public static int solution() {
        // period 짧은것, request 작은 것, num 작은 것
        // 음수면 앞에 위치함 (- 0 +)
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