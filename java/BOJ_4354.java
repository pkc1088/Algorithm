import java.io.*;
import java.util.*;
/*
    ababab ���ڿ��� Pi���� ���غ��� = [0, 0, 1, 2, 3, 4] ��°� �� �� �ִ�.
    ���⼭ Pi���� ������ ��Ÿ���� ������ �����غ��ٸ� Pi[x] = y �� �Ҷ�
    0~y �� �迭����  (length - y) ~ x ���� ���ϰ� �Ȱ��ٶ�� ���� ��Ÿ����.
    0~ y : abab
    (length - y) ~ x : abab
    
    <EX>
        a b a b a b 
    pi  0 0 1 2 3 4
    idx 0 1 2 3 4 5
 */
public class BOJ_4354 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String Pattern = br.readLine();
            if (Pattern.charAt(0) == '.')
                break;
            int[] Pi = makeTable(Pattern);
            int ans = Pi.length % (Pi.length - Pi[Pi.length - 1]) == 0
                    ?
                    Pi.length / (Pi.length - Pi[Pi.length - 1])
                    :
                    1;

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }

    public static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++) {
            while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            if(pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }
} 
