import java.io.*;
import java.util.*;

public class BOJ_3584{

    static List<Integer>[] list;
    static int[] parent, depth;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());

            parent = new int[n+1];
            depth = new int[n+1];
            list = new ArrayList[n+1];
            for(int i=1; i<n+1; i++) {
                list[i] = new ArrayList<>();
            }

            boolean[] rootCheck = new boolean[n+1];
            Arrays.fill(rootCheck, true);
            StringTokenizer st;
            for(int i=0; i<n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                rootCheck[b] = false;   //a가 b의 부모이기 떄문
            }
            int rootIdx=0;
            for(int i=1; i<n+1; i++) {      // 루트 노드 구하기
                if(rootCheck[i] == true) {
                    rootIdx = i;
                    break;
                }
            }

            init(rootIdx,1,0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a,b));
        }

    }

    static void init(int cur, int d, int pa) {  // 각 노드들에 부모 설정해주기
        depth[cur] = d;
        parent[cur] = pa;
        for(int next : list[cur]) {
            if(next != pa) {
                init(next, d+1, cur);
            }
        }
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];
        while(ah > bh) {
            a = parent[a];
            ah--;
        }

        while(bh > ah) {
            b = parent[b];
            bh--;
        }

        while(a!=b) {
            a = parent[a];
            b = parent[b];
        }

        return a;   //b로 줘도 노상관
    }
}
