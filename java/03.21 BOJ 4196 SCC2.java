import java.io.*;
import java.util.*;
// scc �ڻ���� 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, N, M;
    static ArrayList<ArrayList<Integer>> conn = new ArrayList<>(); // ������ �׷���
    static ArrayList<ArrayList<Integer>> reconn = new ArrayList<>(); // ������ �׷���
    static int[] scc; // �� ���̳밡 � scc�� ���ϴ���
    static int[] parent; // �������� �� �� scc �տ� ����Ǿ�� �� scc�� ��� �ִ���
    static boolean[] visit; // �湮 üũ
    static Stack<Integer> stack = new Stack<>();
 
    public static void dfs(int now) { // ������ dfs (now: ���� ���̳� ��ȣ)
 
        visit[now] = true; // �湮 üũ
 
        for (int i = 0; i < conn.get(now).size(); i++) { // ������ �׷����� �̿��� dfs ����
            int next = conn.get(now).get(i);
 
            if (visit[next] == true)
                continue;
 
            dfs(next);
        }
        stack.push(now); // Ž���� ���� ���̳�� ���ÿ� push
    }
 
    public static void redfs(int now, int number) { // ������ dfs (now: ���� ���̳� ��ȣ, number: ���� scc ��ȣ)
 
        visit[now] = true; // �湮 üũ
        scc[now] = number; // �ش� ���̳밡 � scc�� ���ϴ��� üũ
 
        for (int i = 0; i < reconn.get(now).size(); i++) {// ������ �׷����� �̿��� dfs ����
            int next = reconn.get(now).get(i);
 
            if (visit[next] == true) { // �̹� �湮�� ���̳��̰�,
                if (scc[next] != number) { // ���� ���̳��� scc�� �ٸ� scc���
                                           // next�� ���� scc�� ���� scc���� ����Ǿ�� ��
                    parent[number]++; // ���� scc���� ����Ǿ�� �� scc�� 1�� ����
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
 
            for (int i = 0; i < M; i++) { // ������ �׷����� ������ �׷��� ����
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
 
                conn.get(a).add(b);
                reconn.get(b).add(a);
            }
 
            for (int i = 1; i <= N; i++) { // ������ dfs ����
                if (visit[i] == true)
                    continue;
 
                dfs(i);
            }
 
            Arrays.fill(visit, false);
            int scc_num = 1; // ���� scc ��ȣ
            while (!stack.isEmpty()) { // ������ dfs ����
                int now = stack.pop();
 
                if (visit[now] == true)
                    continue;
 
                redfs(now, scc_num);
                scc_num++; // scc ��ȣ ����
            }
 
            int cnt = 0;
            for (int i = 1; i < scc_num; i++) {
                if (parent[i] == 0) { // �ش� scc���� ����Ǿ�� �� scc�� ������
                    cnt++; // �Ѿ�߷��� �� ���̳� + 1
                }
            }
 
            if (cnt == 0) // ���� �Ѿ�߸� ���̳밡 ���ٸ�? == ��� ���̳밡 �ϳ��� scc���?
                cnt = 1;  // �׷��� �ϳ��� �Ѿ�߷��� ��
            bw.write(String.valueOf(cnt) + "\n");
 
            for (int i = 0; i <= N; i++) { // ����� ArrayList�� �ʱ�ȭ
                conn.get(i).clear();
                reconn.get(i).clear();
            }
            Arrays.fill(visit, false); // ����� �迭�� �ʱ�ȭ
            Arrays.fill(parent, 0);
            Arrays.fill(scc, 0);
            stack.clear();
        }
 
 
        bw.flush();
        bw.close();
        br.close();
    }
}
