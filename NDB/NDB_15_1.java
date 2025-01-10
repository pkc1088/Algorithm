import java.util.*;

public class NDB_15_1 {

    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // ���� [left_value, right_value]�� �������� ������ ��ȯ�ϴ� �Լ�
    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        // ����: lowerBound�� upperBound�� end ������ ���� �迭�� ���̷� ����
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // �������� ���� N, ã���� �ϴ� �� x �Է¹ޱ�
        int n = sc.nextInt();
        int x = sc.nextInt();

        // ��ü ������ �Է¹ޱ�
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // ���� [x, x] ������ �ִ� �������� ���� ���
        int cnt = countByRange(arr, x, x);
        
        // ���� x�� ���Ұ� �������� �ʴ´ٸ�
        if (cnt == 0) System.out.println(-1);
        //  ���� x�� ���Ұ� �����Ѵٸ�
        else System.out.println(cnt);
    }
}
