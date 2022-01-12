import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        bw.write((int) (Math.pow(2, N) - 1) + "\n");
        Hanoi(N, 1, 2, 3);

        bw.flush();
        bw.close();
    }
 
    public static void Hanoi(int N, int start, int mid, int to) throws IOException {
        // �̵��� ������ ���� 1�����?
        if (N == 1) {
            bw.write(start + " " + to + "\n");
            return;
        }
        // STEP 1 : N-1���� A���� B�� �̵�
        Hanoi(N - 1, start, to, mid);

        // STEP 2 : 1���� A���� C�� �̵�
        bw.write(start + " " + to + "\n");

        // STEP 3 : N-1���� B���� C�� �̵�
        Hanoi(N - 1, mid, start, to);

    }
}

