import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode{
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminal;

        public TrieNode(){}

        public void insert(String word) {
            TrieNode trieNode = this;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                // Key ���� �����ϴ� ��� Map�� Value�� ���� ��ȯ�ϰ�,
                // Key���� �������� �ʴ� ��� Key�� Value�� Map�� �����ϰ� Null�� ��ȯ�մϴ�.
                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);

                if(i==word.length()-1) {
                    trieNode.terminal = true;
                }
            }
        }

        public int autoModule(String word) {
            TrieNode trieNode = this;
            int cnt=0;
            for(int i=0; i<word.length(); i++) {
                char c= word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);
                if(i==0) {
                    cnt++;
                }
                else if(trieNode.terminal || trieNode.childNode.size()>1) {
                    cnt++;
                }
                trieNode = node;
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine())!=null) {
            int n = Integer.parseInt(line);
            List<String> inputData = new ArrayList<>();
            TrieNode trie = new TrieNode();
            for(int i=0; i<n; i++) {
                String str = br.readLine();
                inputData.add(str);
                trie.insert(str);
            }

            double res=0;

            for(String str : inputData) {
                res+= trie.autoModule(str);
            }
            System.out.println(String.format("%.2f",res/inputData.size()));
        }
    }
}
