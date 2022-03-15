import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] dp;
    static final int INF = 11000000;	
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        // i : ���� ��ġ�� ����, j : ���ݱ��� �湮�� ���� 2����
        dp = new int[n][(1 << n) - 1];	
        // ex) 1 << 4 = 10000(2) = 16�ε� �츮�� �ִ밪�� 1111(2) �̹Ƿ� 1 ����

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int weight = Integer.parseInt(st.nextToken());
                map[i][j] = weight;
            }
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 1));
    }

    // ��� ���ÿ��� �����ϵ��� �ּҺ���� ���� ������ ����ϰ� 0�����ú��� ��������
    // city - ���� ��ġ�� ���� �ε���, visitBitMask - ���ݱ��� �湮�� ���� 2����
    public static int dfs(int city, int visitBitmask) {

        if(visitBitmask == (1 << n) - 1) {	// ��� ���ø� �湮�ߴٸ�
            if(map[city][0] == 0) {	// �̷� ���� ���� ��������, Ȥ�� �߻��ϴ� ��� ���� ó��
                return INF;
            }

            return map[city][0];	// ���� ���� -> 0����(����) ���� �̵� �Ÿ�
        }

        if(dp[city][visitBitmask] != INF) {	// dp���� �����ϴ°��
            return dp[city][visitBitmask];
        }

        for(int i = 0; i < n; i++) {// ���� ���ÿ��� �� i�� ���÷� �̵��� ��쿡 ���� DFS ����
            if((visitBitmask & (1 << i)) == 0 && map[city][i] != 0) {
            // �� ���̶� �� ���ø� �湮�ߴµ� �ٽ� �� ���ø� �湮�ϴ� ��� ����ó��
            //d[i][j] = ���� �ִ� ���ð� i�̰� �̹� �湮�� ���õ��� ������ j�϶�, 
            // �湮���� ���� ������ ���õ��� ��� �湮�� �� ��� ���÷� ���ƿ� �� ��� �ּ� ���.
            //��, �湮�ؾ��ϴ� ����(���⿡ ������������ ���ƿ��� �� ����) ����� ���� �ּ� ���
                dp[city][visitBitmask] = Math.min(dp[city][visitBitmask], 
                        dfs(i, visitBitmask | (1 << i)) + map[city][i]);	
            // dfs(���� ����, �������� �湮�ߴٰ� ����)
            // + ���⼭ ���� ���ñ����� �Ÿ� �� �ּҰŸ� ��
            }
        }

        return dp[city][visitBitmask];
    }
}
