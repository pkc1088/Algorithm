import java.io.*;
import java.util.*;
class Virus {
    int VirusNum;
    int posX;
    int posY;

    Virus(int a, int b, int c) {
        VirusNum = a;
        posX = b;
        posY = c;
    }
    int GetVirusNum() {return VirusNum;}
    int GetPosX() {return posX;}
    int GetPosY() {return posY;}
}

public class Main {
    public static int n, k, s, x, y;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static PriorityQueue<Virus> q = new PriorityQueue<>(new Comparator<Virus>() {
        @Override
        public int compare(Virus o1, Virus o2) {
            if(o1.VirusNum < o2.VirusNum) {
                return -1;
            }else if(o1.VirusNum > o2.VirusNum) {
                return 1;
            }else {
                return 0;
            }
        }
    });


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        if(s==0) {
            System.out.println(arr[x][y]);
            System.exit(0);
        }

        while(s-1 >= 0) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(!visited[i][j] && arr[i][j] != 0) {
                        q.offer(new Virus(arr[i][j], i, j));
                        visited[i][j] = true;
                    }
                }
            }
            s--;
            bfs();
            print();
        }

        System.out.println(arr[x][y]);
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Virus cVirus = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cVirus.GetPosX() + dx[i];
                int ny = cVirus.GetPosY() + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = cVirus.GetVirusNum();
                    }
                }
            }
        }

    }

}
