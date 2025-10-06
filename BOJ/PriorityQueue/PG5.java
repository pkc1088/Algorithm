package BOJ.PriorityQueue;

// "�ٸ��� ������ Ʈ��"

import java.util.ArrayDeque;

public class PG5 {
    static int bridge_length = 2;
    static int weight = 10;
    static int[] truck_weights = {7,4,5,6};

    public int solution() {

        int time = 1; // �ð�, 1�ʺ��� Ʈ���� ���� �� �ִ�
        int total = 0; // �ٸ� ���� Ʈ�� ����
        ArrayDeque<Truck> queue = new ArrayDeque<>();
        // �Ʒ��� ���� �� �ٸ� ���� Ʈ�� ���� ������� �ʴ´�. Ʈ���� 1�ʿ� �� �뾿 ������, ������ ���� ����ϱ⿡
        for (int i = 0; i < truck_weights.length; i++) {
            // �ð��ʰ��� Ʈ���� ��
            if (!queue.isEmpty() && queue.peek().t + bridge_length < time) {
                total -= queue.poll().w;
            }
            // ���ο� Ʈ���� ������ ���� ������ �����ϱ� ���� Ʈ������ ��
            int w = truck_weights[i];
            while (total + w > weight) {
                Truck truck = queue.poll();
                total -= truck.w;
                time = truck.t + bridge_length;
            }
            // ���ο� Ʈ���� �������
            queue.add(new Truck(w, time));
            total += w;
            time++; // 1�ʰ� ������ ���ο� Ʈ���� ���� �� �ִ�
        }
        // ������ Ʈ���� ���� �ð��� �ٸ� ���̷� ���� ���
        return queue.peekLast().t + bridge_length;
    }
    private class Truck {
        int w, t; // ����, �ٸ� ���� ������ �ð�

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
