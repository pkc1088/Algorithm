import java.io.*;
import java.util.*;
// ��������̶� �޸� 1�� ��Ʈ �ƴ� �� ������
// ����� Ž���� ���� ���� ��湮 ������ ���� �湮���θ� üũ����� �Ѵ�.
public class Main {
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

        dp[pos][0] = 0; // ���� x
        dp[pos][1] = weight[pos]; // ���� o

        if(child_num == 0)
            return;

        check[pos] = true;

        for(int child : v[pos]) {
            if(!check[child]) {
                dfs(child);

                // �ڽ� x  > �ڽ� o
                if(dp[child][0] > dp[child][1]) {
                    dp[pos][0] += dp[child][0]; // �θ� x �ڽ� x

                }else { //  �ڽ� x  < �ڽ� o
                    dp[pos][0] += dp[child][1]; // �θ� x �ڽ� o
                }

                dp[pos][1] += dp[child][0]; // (����) �θ� o �ڽ� x
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
