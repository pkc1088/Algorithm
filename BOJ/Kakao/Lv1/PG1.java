package BOJ.Kakao.Lv1;

// "비밀지도"

import java.util.*;
public class PG1 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            //System.out.println("i:"+i);
            answer[i] = modulo(n, arr1[i], arr2[i]);
        }
        return answer;
    }

    public String modulo(int k, int num1, int num2) {

        StringBuilder sb = new StringBuilder();
        while(k-->0) {
            int s1 = num1 % 2;
            int s2 = num2 % 2;
            if(s1 == 0 && s2 == 0) sb.append(" ");
            else sb.append("#");

            if(num1 != 0) num1 /= 2;
            if(num2 != 0) num2 /= 2;
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < sb.length(); i++) {
            ans.append(sb.charAt(sb.length() - i - 1));
        }

        return ans.toString();
    }
}

/*
30 % 2  = 0
15 % 2  = 1
7 % 2   = 1
3 % 2   = 1
1 % 2   = 1
*/
