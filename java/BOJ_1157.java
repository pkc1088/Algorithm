import java.util.*;

public class BOJ_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        int[] x = new int[26], ch = new int[26];
        
        for (int i = 0; i < 26; i++) {
            ch[i]='A'+i;
        }

        for (int i = 0; i < s.length(); i++) {
            x[s.charAt(i)-'A']++;
        }

        int mi = 0, smi = 1;
        if(x[mi]<x[smi]) {
            mi = 1;
            smi = 0;
        }

        for (int i = 2; i < x.length; i++) {
            if(x[mi]<=x[i]) {
                smi = mi;
                mi = i;
            }
        }
       
        if(x[mi]==x[smi])
            System.out.println("?");
        else
            System.out.println((char)ch[mi]);
    }
}
