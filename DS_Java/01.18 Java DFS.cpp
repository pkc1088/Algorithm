import java.util.*;

public class Main {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // DFS �Լ� ����
    public static void dfs(int x) {
        // ���� ��带 �湮 ó��
        visited[x] = true;
        System.out.print(x + " ");
        // ���� ���� ����� �ٸ� ��带 ��������� �湮
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }

    public static void main(String[] args) {
        // �׷��� �ʱ�ȭ
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // ��� 1�� ����� ��� ���� ���� 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // ��� 2�� ����� ��� ���� ���� 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // ��� 3�� ����� ��� ���� ���� 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // ��� 4�� ����� ��� ���� ���� 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // ��� 5�� ����� ��� ���� ���� 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // ��� 6�� ����� ��� ���� ���� 
        graph.get(6).add(7);
        
        // ��� 7�� ����� ��� ���� ���� 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // ��� 8�� ����� ��� ���� ���� 
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }
}
/*
import java.util.*;

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + this.index + "," + this.distance + ") ");
    }
}

public class Main {

    // ��(Row)�� 3���� ���� ����Ʈ ǥ��
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {
        // �׷��� �ʱ�ȭ
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // ��� 0�� ����� ��� ���� ���� (���, �Ÿ�)
        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        // ��� 1�� ����� ��� ���� ���� (���, �Ÿ�)
        graph.get(1).add(new Node(0, 7));

        // ��� 2�� ����� ��� ���� ���� (���, �Ÿ�)
        graph.get(2).add(new Node(0, 5));

        // �׷��� ���
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}
*/
