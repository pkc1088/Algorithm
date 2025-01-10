import java.util.*;

import static java.lang.Long.valueOf;

public class BOJ_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine().trim();
        String y = sc.nextLine().trim();
        int sum = 0;
        for (int i = 2, j = 1; i >= 0; i--) {
            int ans = Integer.parseInt(x) * (y.charAt(i)-'0');
            System.out.println(ans);
            sum += ans * j;
            j*=10;
        }
        System.out.println(sum);
    }
}
