import java.io.*;
import java.util.Arrays;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
           bw.write(String.valueOf(arr[i]));
           bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        // ���� ���� (0 ~ 10000) ��ǻ� 0�� ����
        int[] cnt = new int[10001];
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int N = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < N; i++) {
            // �ش� �ε����� ���� 1 ����
            cnt[Integer.parseInt(br.readLine())] ++;
        }
 
        br.close();
 
        StringBuilder sb = new StringBuilder();
 
        // 0�� �Է¹������� �����Ƿ� 1���� ����
        for(int i = 1; i < 10001; i++){
            // i ���� ������ 0 �� �� �� ���� ��� (�󵵼��� �ǹ�)
            while(cnt[i] > 0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}
*/
