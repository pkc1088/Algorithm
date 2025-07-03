import java.io.*;
import java.util.*;
/*
    ababab 문자열의 Pi값을 구해보면 = [0, 0, 1, 2, 3, 4] 라는걸 알 수 있다.
    여기서 Pi값은 무엇을 나타내는 것일지 생각해본다면 Pi[x] = y 라 할때
    0~y 의 배열들이  (length - y) ~ x 까지 패턴과 똑같다라는 것을 나타낸다.
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
