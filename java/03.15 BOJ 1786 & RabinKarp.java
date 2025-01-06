import java.io.*;
import java.util.*;

public class Main {
    public static int cnt = 0, cnt2 = 0;
    public static Queue<Integer> q = new LinkedList<>();
    public static Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();

        KMP(t, p);
        System.out.println(cnt);
        while(!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }

        System.out.println();

        search(t, p);
        System.out.println(cnt2);
        while(!q2.isEmpty()) {
            System.out.print(q2.poll() + " ");
        }
    }

    static void search(String s, String pattern) {
        for (int i = 0; i <= s.length() - pattern.length(); ++i) {
            int check = 1;
            // Iterating over the string for which is to be
            // searched using the length() method
            for (int j = 0; j < pattern.length(); ++j) {
                // Now, checking the elements of pattern
                // with the given string using the charAt()
                // method
                if (s.charAt(i + j) != pattern.charAt(j)) {
                    // Setting check to zero as pattern is
                    // not detected here
                    check = 0;
                    // Break statement to hault
                    // execution of code
                    break;
                }
            }
            // Now if the check remains same as declared
            // then pattern is detected at least once
            if (check == 1) {
                // Printing the position(index) of the
                // pattern string in the input string
                q2.offer(i + 1);
                cnt2++;
            }
        }
    }

    public static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++) {
            // ��ġ�ϴ� ���ڰ� �߻����� ��(idx>0), ���������� �� ��ġ���� ������ idx = table[idx-1]�� �����ش�.
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }

    static void KMP(String parent, String pattern) {
        int[] table = makeTable(pattern);

        int n1 = parent.length();
        int n2 = pattern.length();

        int idx = 0; // ���� �����Ǵ� ���� ��
        for(int i=0; i< n1; i++) {
            // idx�� ���ڿ� ¤������ �ش� ���ڰ� ����ġ�� ���,
            // ���� ������ ������ ���� table[idx-1]������ ���δ�.
            while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            // ���ڰ� ������ ���
            if(parent.charAt(i) == pattern.charAt(idx)) {
                if(idx == n2-1) {
                    cnt++;
                    q.offer(i-idx+1);
                    idx =table[idx];
                }else {
                    idx += 1;
                }
            }
        }
    }
}
