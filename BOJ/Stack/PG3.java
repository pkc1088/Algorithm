package BOJ.Stack;

// "올바른 괄호"

import java.util.*;
class PG3 {
    boolean solution(String s) {

        Stack<Character> st = new Stack<>();
//         ) () ()
        if(s.charAt(0) == ')') return false;

        for(int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if(check == '(') {
                st.push(check);
            } else if(!st.isEmpty() && check == ')') {
                st.pop();
            }
        }
        if(!st.isEmpty()) return false;

        return true;
    }
}