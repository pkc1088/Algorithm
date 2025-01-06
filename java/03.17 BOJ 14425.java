import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt = 0;

    static class Node{
        HashMap<String, Node> childs = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] strArr = new String[n];
        String[] checkStr = new String[m];
        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            checkStr[i] = br.readLine();
        }

        Node root = new Node();

        for(int i = 0; i < n; i++) {
            Node cur = root;

            String s = strArr[i];

            if(!cur.childs.containsKey(s)) {
                cur.childs.put(s, new Node());
            }

            cur = cur.childs.get(s);
        }

        for (int i = 0; i < m; i++) {
            count(root, checkStr[i]);
        }

        System.out.println(cnt);
    }

    public static void count(Node root, String str) {
        Object[] key = root.childs.keySet().toArray();
        for (Object s : key) {
            if(s.equals(str)) {
                cnt++;
                return;
            }
            count(root.childs.get(s),str);
        }
    }

}

