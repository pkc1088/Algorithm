import java.io.*;
import java.util.*;
// 우수마을이랑 달리 1이 루트 아닐 수 있으니
// 양방향 탐색을 해준 다음 재방문 방지를 위해 방문여부를 체크해줘야 한다.
public class BOJ_2213 {
    static ArrayList<Integer>[] v;
    static int[] weight;
    static int[][] dp;
    static boolean[] check;
    static ArrayList<Integer> res;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        weight = new int[n+1];
        v = new ArrayList[n+1];
        dp = new int[n+1][2];
        check = new boolean[n+1];
        res = new ArrayList<>();
        for(int i=0; i<n+1; i++) {
            v[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<n+1; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            v[b].add(a);
            v[a].add(b);
        }

        dfs(1);

        if(dp[1][1]> dp[1][0] ) {
            System.out.println(dp[1][1]);
            trace(1,1);
        }else {
            System.out.println(dp[1][0]);
            trace(1,0);
        }

        Collections.sort(res);
        for(int num : res ) {
            System.out.print(num+" ");
        }
    }

    static void dfs(int pos) {

        int child_num = v[pos].size();

        dp[pos][0] = 0; // 참석 x
        dp[pos][1] = weight[pos]; // 참석 o

        if(child_num == 0)
            return;

        check[pos] = true;

        for(int child : v[pos]) {
            if(!check[child]) {
                dfs(child);

                // 자식 x  > 자식 o
                if(dp[child][0] > dp[child][1]) {
                    dp[pos][0] += dp[child][0]; // 부모 x 자식 x

                }else { //  자식 x  < 자식 o
                    dp[pos][0] += dp[child][1]; // 부모 x 자식 o
                }

                dp[pos][1] += dp[child][0]; // (공통) 부모 o 자식 x
            }
        }
        check[pos] = false;
    }

    static void trace(int pos, int attend) {
        check[pos] = true;
        if(attend==1) {
            res.add(pos);
            for(int i=0; i<v[pos].size(); i++) {
                int next = v[pos].get(i);
                if(!check[next]) {
                    trace(next, 0);
                }
            }
        }
        else {
            for(int i=0; i<v[pos].size(); i++) {
                int next = v[pos].get(i);
                if(!check[next]) {
                    if(dp[next][1] > dp[next][0]) {
                        trace(next, 1);
                    }else {
                        trace(next, 0);
                    }
                }
            }
        }
        check[pos] = false;

    }
}
