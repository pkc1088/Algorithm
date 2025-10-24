package BOJ.Collections;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class DataStructureAnswer {

    public static void main(String[] args) throws IOException {
        Test();
    }

    public static void Test() throws IOException {
        ArrayList<Stack<Integer>> arrStk = new ArrayList<>();
        for(int i = 0; i < 1; i++) arrStk.add(new Stack<Integer>());
        arrStk.get(0).push(1);
        // 1���� �迭 ����
        int[] arr = new int[10];
        // -1�� arr ä���
        Arrays.fill(arr, -1);
        // 2���� �迭 ����
        int[][] arr2 = new int[10][10];
        // arr2�� arr�� �����ϱ�
        for(int i = 0; i < arr.length; i++) arr2[i] = arr.clone();
        // 0 <= arr �ε��� < 1 ��ŭ brr �� ����
        int[] brr = Arrays.copyOfRange(arr, 0, 1);
        // ����Ʈ ����
        List<Integer> list = new ArrayList<>();
        // �׷��� ����
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // �׷��� 10��ŭ �ʱ�ȭ
        for(int i = 0; i < 10; i++) graph.add(new ArrayList<>());


        // ť
        Queue<Integer> q = new LinkedList<>();
        // ������� Ȯ�� �� �߰� �� ����
        if(!q.isEmpty()) { q.add(1); q.offer(2); q.poll(); }
        // �� �ʱ�ȭ + ������
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // ����
        Stack<Integer> stk = new Stack<>();
        // �߰� �� ����
        stk.push(3); stk.pop();
        // ��
        Set<Integer> set = new HashSet<>();
        // 4 �����ϴ��� üũ �� 4 �߰�
        if(!set.contains(4)) { set.add(4); }
        // �� <String, Integer>
        Map<String, Integer> map = new HashMap<>();
        // �߰� 2���� ����
        map.put("banana", map.getOrDefault("banana", 0));
        map.put("strawberry", 2);
        // �ʿ��� Ű�� �� ����
        for(String s : map.keySet()) map.get(s);
        // Ű�� �������� ���� ���� ���ο� ���� ����Ͽ� Map �� �߰��ϰ� �� ���� ��ȯ
        map.computeIfAbsent("apple", k -> 1);
        // �ʿ��� Ư�� Ű Ȯ���ϰ� ���� �ϰų� ����
        if (map.containsKey("banana")) map.replace("banana", 2);
        map.remove("banana");
        // �� <String, List<String>>
        Map<String, List<String>> groups = new HashMap<>();
        // Alice Ű ������ ���ο� ����Ʈ ���� �� ������ ���ڿ� �ֱ�, Ű �̹� �����ϸ� ���� list ��ȯ
        String student = "Alice";
        List<String> aliceCourses1 = groups.computeIfAbsent(student, k -> new ArrayList<>());
        // ��ť
        Deque<String> dq = new ArrayDeque<>();
        // ���� �߰�/����, ���� �߰�/����
        dq.addFirst("B"); dq.addLast("C");
        dq.pollFirst(); dq.pollLast();

        // arr -> Integer[]
        Integer[] wrappedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // Integer[] -> arr
        arr = Arrays.stream(wrappedArray).mapToInt(i->i).toArray();
        // arr -> list
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // list -> arr
        arr = list.stream().mapToInt(i->i).toArray();
        // Integer[] -> list
        list = Arrays.stream(wrappedArray).collect(Collectors.toList());
        List<Integer> list2 = new ArrayList<>(Arrays.asList(wrappedArray));
        // list -> Integer[]
        Integer[] newArr = list.toArray(new Integer[0]);


        // Integer[] ������
        Arrays.sort(wrappedArray, Comparator.reverseOrder());
        // int[] arr ����
        Arrays.sort(arr);
        // int[] arr ������
            // arr -> Integer[]
            // Integer[] ������
            // �̰� �׳� for �� ���°� ���� ��
        // List ������ �� ����
        Collections.reverse(list2);
        Collections.sort(list2, Comparator.reverseOrder());
        list2.sort(Comparator.reverseOrder());
        // 2���� �� ��° ��ҷ� �������� ����
        Arrays.sort(arr2, (a, b) -> a[1] - b[1]);
        // 2���� ù ��ҷ� ��������, �ι�° ��ҷ� �������� ����
        Arrays.sort(arr2, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // ���ڿ� str ����� substr 0~3
        String str = "1234";
        String substr = str.substring(0,3);
        // ���ڿ� �迭 ������
        String[] p = str.split("");
        // ���ڿ� �迭 ������ ���Խ�
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        String[] parts1 = text.split("[.,\\[\\]] | \\s+");
        String[] parts2 = text.split("[.,\\[\\]]");
        // �Ľ� int �� str
        int k = Integer.parseInt(str);
        String str2 = String.valueOf(k);
        // BR, BW
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(str, " ");
        if(st.hasMoreTokens()) st.nextToken();

    }
}
