import java.util.*;

public class BOJ_4673 {
    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int x = i;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                x += s.charAt(j)-'0';
            }
            v.add(x);
        }
        for (int i = 0; i < 10000; i++) {
            if(v.contains(i))
               continue;
            else
                System.out.println(i);
        }
    }
}
