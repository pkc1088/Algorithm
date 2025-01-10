import java.io.*;
import java.util.*;

public class BOJ_5430 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            String command = br.readLine();	// �������� p�� �ش��ϴ� ��ɾ�
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<Integer>();
            for(int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(command, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String command, ArrayDeque<Integer> deque) {
        boolean isRight = true;
        for(char cmd : command.toCharArray()) {
            if(cmd == 'R') {
                isRight = !isRight;	// ������ �ٲ��ش�.
                continue;
            }
            if(isRight) {
                if(deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
            else {
                if(deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makePrintString(deque, isRight);
    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
        sb.append('[');	// ���� ���ȣ ���� StringBuilder�� ����
        if(deque.size() > 0) {	//���� ��� �� ���Ұ� �� �� �̻��� ���
            if(isRight) {	// �������ϰ��
                sb.append(deque.pollFirst());	// ���� ù ��° ���Ҹ� �Ѱ��ش�.
                // �� ���� ���Һ��� ������ ���� �Ѱ��� �� ���� ���Ҹ� �ϳ��� �̾� �ѱ��.
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {	// �������ϰ��
                sb.append(deque.pollLast());	// ���� �ڿ������� ù ��° ���Ҹ� �Ѱ��ش�.
                // �� ���� ���Һ��� ������ ���� �Ѱ��� �� ���� ���Ҹ� �ڿ������� �ϳ��� �̾� �ѱ��.
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');	// �ݴ� ���ȣ �� �������� ������
    }
}
