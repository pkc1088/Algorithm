import java.util.*;

public class BOJ_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        M -= 45;
        if (M < 0) {
            M = 60 - (M * -1);
            H--;
            if (H < 0) {
                H = 23;
            }
        }
        System.out.println(H + " " + M);
    }
}
