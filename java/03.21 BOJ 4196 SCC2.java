import java.io.*;
import java.util.*;
// scc 코사라주 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, N, M;
    static ArrayList<ArrayList<Integer>> conn = new ArrayList<>(); // 순방향 그래프
    static ArrayList<ArrayList<Integer>> reconn = new ArrayList<>(); // 역방향 그래프
    static int[] scc; // 각 도미노가 어떤 scc에 속하는지
    static int[] parent; // 위상정렬 시 각 scc 앞에 선행되어야 할 scc가 몇개가 있는지
    static boolean[] visit; // 방문 체크
    static Stack<Integer> stack = new Stack<>();
 
    public static void dfs(int now) { // 순방향 dfs (now: 현재 도미노 번호)
 
        visit[now] = true; // 방문 체크
 
        for (int i = 0; i < conn.get(now).size(); i++) { // 순방향 그래프를 이용한 dfs 수행
            int next = conn.get(now).get(i);
 
            if (visit[next] == true)
                continue;
 
            dfs(next);
        }
        stack.push(now); // 탐색이 끝난 도미노는 스택에 push
    }
 
    public static void redfs(int now, int number) { // 역방향 dfs (now: 현재 도미노 번호, number: 현재 scc 번호)
 
        visit[now] = true; // 방문 체크
        scc[now] = number; // 해당 도미노가 어떤 scc에 속하는지 체크
 
        for (int i = 0; i < reconn.get(now).size(); i++) {// 역방향 그래프를 이용한 dfs 수행
            int next = reconn.get(now).get(i);
 
            if (visit[next] == true) { // 이미 방문한 도미노이고,
                if (scc[next] != number) { // 현재 도미노의 scc와 다른 scc라면
                                           // next가 속한 scc가 현재 scc보다 선행되어야 함
                    parent[number]++; // 현재 scc보다 선행되어야 할 scc가 1개 증가
                }
                continue;
            }
 
            redfs(next, number);
        }
    }
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        scc = new int[100001];
        parent = new int[100001];
        visit = new boolean[100001];
        for (int i = 0; i <= 100001; i++) {
            conn.add(new ArrayList<>());
            reconn.add(new ArrayList<>());
        }
 
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
 
            for (int i = 0; i < M; i++) { // 순방향 그래프와 역방향 그래프 생성
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
 
                conn.get(a).add(b);
                reconn.get(b).add(a);
            }
 
            for (int i = 1; i <= N; i++) { // 순방향 dfs 수행
                if (visit[i] == true)
                    continue;
 
                dfs(i);
            }
 
            Arrays.fill(visit, false);
            int scc_num = 1; // 현재 scc 번호
            while (!stack.isEmpty()) { // 역방향 dfs 수행
                int now = stack.pop();
 
                if (visit[now] == true)
                    continue;
 
                redfs(now, scc_num);
                scc_num++; // scc 번호 증가
            }
 
            int cnt = 0;
            for (int i = 1; i < scc_num; i++) {
                if (parent[i] == 0) { // 해당 scc보다 선행되어야 할 scc가 없으면
                    cnt++; // 넘어뜨려야 할 도미노 + 1
                }
            }
 
            if (cnt == 0) // 만약 넘어뜨릴 도미노가 없다면? == 모든 도미노가 하나의 scc라면?
                cnt = 1;  // 그래도 하나는 넘어뜨려야 함
            bw.write(String.valueOf(cnt) + "\n");
 
            for (int i = 0; i <= N; i++) { // 사용한 ArrayList들 초기화
                conn.get(i).clear();
                reconn.get(i).clear();
            }
            Arrays.fill(visit, false); // 사용한 배열들 초기화
            Arrays.fill(parent, 0);
            Arrays.fill(scc, 0);
            stack.clear();
        }
 
 
        bw.flush();
        bw.close();
        br.close();
    }
}
