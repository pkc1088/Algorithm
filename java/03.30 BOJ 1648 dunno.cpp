import java.util.*;
import java.io.*;

public class Main {
    static int dp[][];
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.println(1<<M);
        dp = new int [14*14][1<<M];
        for(int i = 0 ; i < 14*14;i++)
            Arrays.fill(dp[i],-1);

        System.out.println(proc(0,0));

        for (int i = 0; i < 14 * 14; i++) {
            for (int j = 0; j < 1<<M; j++) {
       //         System.out.print(dp[i][j]+" ");
            }
         //   System.out.println();
        }
    }
    public static int proc(int index,int state)
    {
        if (index == N*M && state == 0) {
            return 1;
        }
        if (index >= N*M) {
            return 0;
        }

        if(dp[index][state]>=0)
            return dp[index][state];

        dp[index][state] = 0;
        if((state & 1) == 0) {
            dp[index][state] = proc(index+1,(state>>1)|(1<<(M-1)));
            if(index%M !=M-1 &&(state&2)==0)
                dp[index][state]+= proc(index+2,state>>2);
        }
        else
            dp[index][state]= proc(index+1,state>>1);

        dp[index][state]%=9901;

        return dp[index][state];

    }
}



/*
public class Main {
    public static int a[][];
    public static long s[][];
    public static long sum(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x2][y1-1] - s[x1-1][y2] + s[x1-1][y1-1];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        a = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            String line = " " + sc.nextLine();
            for (int j=1; j<=m; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }
        s = new long[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                s[i][j] = s[i-1][j]+s[i][j-1]-s[i-1][j-1]+(long)a[i][j];
            }
        }
        long ans = 0;
        for (int i=1; i<=m-2; i++) {
            for (int j=i+1; j<=m-1; j++) {
                long r1 = sum(1,1,n,i);
                long r2 = sum(1,i+1,n,j);
                long r3 = sum(1,j+1,n,m);
                if (ans < r1*r2*r3) {
                    ans = r1*r2*r3;
                }
            }
        }
        for (int i=1; i<=n-2; i++) {
            for (int j=i+1; j<=n-1; j++) {
                long r1 = sum(1,1,i,m);
                long r2 = sum(i+1,1,j,m);
                long r3 = sum(j+1,1,n,m);
                if (ans < r1*r2*r3) {
                    ans = r1*r2*r3;
                }
            }
        }
        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=m-1; j++) {
                long r1 = sum(1,1,n,j);
                long r2 = sum(1,j+1,i,m);
                long r3 = sum(i+1,j+1,n,m);
                if (ans < r1*r2*r3) {
                    ans = r1*r2*r3;
                }
                r1 = sum(1,1,i,j);
                r2 = sum(i+1,1,n,j);
                r3 = sum(1,j+1,n,m);
                if (ans < r1*r2*r3) {
                    ans = r1*r2*r3;
                }
                r1 = sum(1,1,i,m);
                r2 = sum(i+1,1,n,j);
                r3 = sum(i+1,j+1,n,m);
                if (ans < r1*r2*r3) {
                    ans = r1*r2*r3;
                }
                r1 = sum(1,1,i,j);
                r2 = sum(1,j+1,i,m);
                r3 = sum(i+1,1,n,m);
                if (ans < r1*r2*r3) {
                    ans = r1*r2*r3;
                }
            }
        }
        System.out.println(ans);
    }
}

 */

