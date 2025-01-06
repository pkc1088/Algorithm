import java.util.*;

class Virus implements Comparable<Virus> {

    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSecond() {
        return this.second;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // ���� ������ '��ȣ�� ���� ����'
    @Override
    public int compareTo(Virus other) {
        if (this.index < other.index) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static int n, k;
    // ��ü ���� ������ ��� �迭
    public static int[][] graph = new int[200][200];
    public static ArrayList<Virus> viruses = new ArrayList<Virus>();
    
    // ���̷����� �������� �� �ִ� 4������ ��ġ
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                // �ش� ��ġ�� ���̷����� �����ϴ� ���
                if (graph[i][j] != 0) {
                    // (���̷��� ����, �ð�, ��ġ X, ��ġ Y) ����
                    viruses.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        // ���� ���Ŀ� ť�� �ű�� (���� ��ȣ�� ���̷����� ���� �����ϹǷ�)
        Collections.sort(viruses);
        Queue<Virus> q = new LinkedList<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }

        int targetS = sc.nextInt();
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();

        // �ʺ� �켱 Ž��(BFS) ����
        while (!q.isEmpty()) {
            Virus virus = q.poll();
            // ��Ȯ�� second��ŭ �ʰ� �����ų�, ť�� �� ������ �ݺ�
            if (virus.getSecond() == targetS) break;
            // ���� ��忡�� �ֺ� 4���� ��ġ�� ���� Ȯ��
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                // �ش� ��ġ�� �̵��� �� �ִ� ���
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // ���� �湮���� ���� ��ġ���, �� ��ġ�� ���̷��� �ֱ�
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.getIndex();
                        q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(graph[targetX - 1][targetY - 1]);
    }
}
