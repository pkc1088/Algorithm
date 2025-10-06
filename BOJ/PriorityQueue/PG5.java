package BOJ.PriorityQueue;

// "다리를 지나는 트럭"

import java.util.ArrayDeque;

public class PG5 {
    static int bridge_length = 2;
    static int weight = 10;
    static int[] truck_weights = {7,4,5,6};

    public int solution() {

        int time = 1; // 시간, 1초부터 트럭이 들어올 수 있다
        int total = 0; // 다리 위의 트럭 무게
        ArrayDeque<Truck> queue = new ArrayDeque<>();
        // 아래의 로직 상 다리 위의 트럭 수를 고려하지 않는다. 트럭은 1초에 한 대씩 들어오며, 나가는 것을 계산하기에
        for (int i = 0; i < truck_weights.length; i++) {
            // 시간초과된 트럭을 뺌
            if (!queue.isEmpty() && queue.peek().t + bridge_length < time) {
                total -= queue.poll().w;
            }
            // 새로운 트럭이 들어오기 위한 조건을 만족하기 위해 트럭들을 뺌
            int w = truck_weights[i];
            while (total + w > weight) {
                Truck truck = queue.poll();
                total -= truck.w;
                time = truck.t + bridge_length;
            }
            // 새로운 트럭을 집어넣음
            queue.add(new Truck(w, time));
            total += w;
            time++; // 1초가 지나야 새로운 트럭을 넣을 수 있다
        }
        // 마지막 트럭이 들어온 시간과 다리 길이로 답을 계산
        return queue.peekLast().t + bridge_length;
    }
    private class Truck {
        int w, t; // 무게, 다리 위에 진입한 시간

        public Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }

        @Override
        public String toString() {
            return "[w = " + w + ", t = " + t + "]";
        }
    }
}
