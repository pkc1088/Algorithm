//import java.util.Scanner;
import java.util.*;

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("두자리 정수를 하나 입력해주세요. ");
        final int i=2;  int j=5;    j=10;
        System.out.printf("%d, %d%n", i, j);

        Scanner sc1 = new Scanner(System.in);
        String str1 = sc1.nextLine();
        String str2 = sc1.next();
        int num1 = sc1.nextInt();
        System.out.println("str1: "+str1);
        System.out.println("str2: "+str2);
        System.out.println(num1);
    }
}
