package BOJ.GraphSearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import static java.lang.System.exit;

public class BOJ_16928 {
    static int n, m;
    static boolean[] visited = new boolean[101];
    static int[] board = new int[101];
    static Map<Integer, Integer> moves = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            moves.put(x, y);
        }
        bfs();
        System.out.println(board[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int pos = current + i;
                if (pos > 100) continue;
                if (moves.containsKey(pos)) pos = moves.get(pos); // 그 자릴 바로 대체시켜야함

                if (!visited[pos]) {
                    visited[pos] = true;
                    queue.add(pos);
                    board[pos] = board[current] + 1;
                }
            }
        }
    }
}
/*
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import static java.lang.System.exit;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static Queue<int[]> queue;
    static boolean[] visited;
    static int[] dp, brr, arr, crr, board, check, result;
    static int tc, n, m, h, r, k, a, b, c, count, ans = 0, cnt = 0, sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int lader, snake;
    static HashMap<Integer, Integer> hmlader, hmsnake;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        lader = Integer.parseInt(st.nextToken()); // 4
        snake = Integer.parseInt(st.nextToken()); // 3
        board = new int[100 + 1];
        visited = new boolean[100 + 1];
        queue = new LinkedList<>();
        hmlader = new HashMap<>();
        hmsnake = new HashMap<>();
        for (int i = 1; i < lader + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int at = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            hmlader.put(at, to);
        }
        for (int i = 1; i < snake + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int at = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            hmlader.put(at, to);
        }
        ans = bfs();
        System.out.println(ans - 1);
    }

    private static int bfs() {
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] model = queue.poll();
            int curpos = model[0], curtoss = model[1];

            for (int dice = 1; dice <= 6; dice++) {
                int nxpos = curpos + dice;
                if (nxpos > 100) continue;

                if (!visited[nxpos]) {
                    visited[nxpos] = true;

                    if (hmlader.containsKey(curpos)) {
                        int freemove = hmlader.get(curpos);
                        queue.offer(new int[]{freemove, curtoss + 1});
                    }
                    else
                        queue.offer(new int[]{nxpos, curtoss + 1});
                }

                if (nxpos == 100) {
                    return curtoss + 1;
                }
            }
        }
        return -1;
    }

    public static void print() {
        for (int i = 1; i < 100 + 1; i++) {
            System.out.print(board[i] + " ");
            if(i % 10 == 0)
                System.out.println();
        }
    }
}


 */