import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_11780 {
    static int[][] map;
    static int[][] path;
    static int N;
    static int INF = 10000001;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        path = new int[N+1][N+1];
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                path[i][j] = INF;
                if(i==j) continue;
                map[i][j] = INF;
            }
        }

        for(int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            map[start][end] = Math.min(map[start][end], cost);
            path[start][end] = start;
        }
        floydWarshall();

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j]==INF)
                    System.out.print(0+" ");
                else
                    System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(path[i][j]==INF)
                    System.out.println(0);

                else {
                    int pre = j;
                    stack.push(j);
                    while(i != path[i][pre]) {
                        pre = path[i][pre];
                        stack.push(pre);
                    }
                    System.out.print((stack.size()+1)+" ");
                    System.out.print(i+" ");
                    while(!stack.empty())
                        System.out.print(stack.pop()+" ");
                    System.out.println();
                }
            }
        }
    }

    public static void floydWarshall() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][j] > map[i][k]+map[k][j]) {
                        map[i][j] = map[i][k]+map[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
    }
}
