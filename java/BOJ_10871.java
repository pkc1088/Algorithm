import java.util.*;

public class BOJ_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] x = sc.nextLine().split(" ");
        for (int i = 0; i < H; i++) {
            if(Integer.parseInt(x[i]) <M)
                System.out.print(Integer.parseInt(x[i])+" ");
        }
    }
}
