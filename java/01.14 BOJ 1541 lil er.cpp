import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;	// �ʱ� ���� ���� Ȯ���� ���� ������ ����
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        while (subtraction.hasMoreTokens()) {
            int temp = 0;

            // �������� ���� ��ū�� �������� �и��Ͽ� �ش� ��ū���� ���Ѵ�.
            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

            // �������� ���� ��ū���� ��� ���Ѵ�.
            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }

            // ù ��°��ū�� ��� temp���� ù ��° ���� ��
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
