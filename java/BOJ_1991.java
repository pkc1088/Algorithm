import java.io.*;
import java.util.*;

public class BOJ_1991 {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;

        }
    }

    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<n+1; i++) {
            String[] line = br.readLine().split(" ");
            int data = line[0].charAt(0) -'A'+1;
            int left = line[1].charAt(0) -'A'+1;
            int right = line[2].charAt(0) -'A'+1;
            list[data].add(new Node(left, right));
        }

        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb.toString());

    }

    // ���� ��ȸ root > left > right
    static void preorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            sb.append((char)(start+'A'-1));
            if(l != -18) preorder(l);
            if(r != -18) preorder(r);
        }
    }

    // ���� ��ȸ left > root > right
    static void inorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) inorder(l);
            sb.append((char)(start+'A'-1));
            if(r != -18) inorder(r);
        }
    }

    // ���� ��ȸ left > right > root
    static void postorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) postorder(l);
            if(r != -18) postorder(r);
            sb.append((char)(start+'A'-1));
        }
    }
}

/*
import java.io.*;
import java.util.*;

class Node {
	char data;
	Node left;
	Node right;

	Node(char data) {
		this.data = data;
	}
}

class Tree {
	Node root; //��Ʈ ��� ó���� null ����

	public void createNode(char data, char leftData, char rightData) {
		if(root == null) { //�ƹ��͵� ���� �ʱ� ���� - A ��Ʈ ��� ����
			root = new Node(data);

			//�¿� ���� �ִ� ��쿡�� ��� ����
			if(leftData != '.') {
				root.left = new Node(leftData);
			}
			if(rightData != '.') {
				root.right = new Node(rightData);
			}
		} else { //�ʱ���°� �ƴϸ� ��� �������� ã�ƾ��� - A ��Ʈ ��� ����
			searchNode(root, data, leftData, rightData);
		}
	}

    //���⿡�� root�� �Ű� ������ ���� ���ú��� root���� ����
	public void searchNode(Node root, char data, char leftData, char rightData) {
		if(root == null) { //������ ��尡 null�̸� ��� ���� - ã��(������) ��� X
			return;
		} else if(root.data == data) { //�� ��ġ�� ã�Ҵٸ�
			if(leftData != '.') { //.�� �ƴ϶� ���� �ִ� ��쿡�� �¿� ��� ����
				root.left = new Node(leftData);
			}
			if(rightData != '.') {
				root.right = new Node(rightData);
			}
		} else { //���� ã�����߰� Ž���� ��尡 ���� �ִٸ�
			searchNode(root.left, data, leftData, rightData); //���� ��� Ž��
			searchNode(root.right, data, leftData, rightData); //������ ��� Ž��
		}
	}

	// ������ȸ : ��Ʈ -> �� -> ��
	public void preorder(Node root){
		System.out.print(root.data); //���� ��� ���
		if(root.left!=null) preorder(root.left); //�� ���� ����
		if(root.right!=null) preorder(root.right); //������ ������
	}

	// ������ȸ : �� -> ��Ʈ -> ��
	public void inorder(Node root){
		if(root.left!=null) inorder(root.left); //���� ����
		System.out.print(root.data); //�� ���� �߾� ���
		if(root.right!=null) inorder(root.right); //���������� ������
	}

	// ������ȸ : �� -> �� -> ��Ʈ
	public void postorder(Node root){
		if(root.left!=null) postorder(root.left); //���� ����
		if(root.right!=null) postorder(root.right); //�� ���� ������
		System.out.print(root.data);
	}

}

public class BOJ_1991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Tree tree = new Tree();

		for(int i = 0; i < N; i++) {
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		}

		//���� ��ȸ
		tree.preorder(tree.root);
		System.out.println();

		//���� ��ȸ
		tree.inorder(tree.root);
		System.out.println();

		//���� ��ȸ
		tree.postorder(tree.root);

		br.close();
	}

}
 */
