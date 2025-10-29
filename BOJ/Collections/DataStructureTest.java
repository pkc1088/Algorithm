package BOJ.Collections;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class DataStructureTest {

    public static void main(String[] args) throws IOException {
        Test();
    }

    public static void Test() throws IOException {
        // 1���� �迭 ����(arr)
        int[] arr = new int[10];
        // -1�� arr ä���
        Arrays.fill(arr, -1);
        // 2���� �迭 ����(arr2)
        int[][] arr2 = new int[10][10];
        // arr2�� arr�� �����ϱ�
        for(int i = 0; i < 10; i++) arr2[i] = arr.clone();
        // 0 <= arr �ε��� < 1 ��ŭ brr �� ����
        Arrays.copyOfRange(arr, 0, 1);
        // ���� ����Ʈ ����(list)
        List<Integer> list = new ArrayList<>();
        // ���� �׷��� ����
        List<List<Integer>> graph = new ArrayList<>();
        // �׷��� 10��ŭ �ʱ�ȭ
        for(int i = 0; i < 10; i++) graph.add(new ArrayList<>());

        // ť
        Queue<Integer> q = new LinkedList<>();
        // ������� Ȯ�� �� �߰� �� ����
        if(!q.isEmpty()) q.offer(1); q.poll();
        // �� �ʱ�ȭ + ������
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // ����
        Stack<Integer> stk = new Stack<>();
        // �߰� �� ����
        stk.push(1); stk.pop();
        // ��
        Set<Integer> set = new HashSet<>();
        // 4 �����ϴ��� üũ �� 4 �߰�
        if(!set.contains(4)) set.add(4);
        // �� <String, Integer>
        Map<String, Integer> map = new HashMap<>();
        // �߰� 2���� ����
        map.put("basdf", 1);
        map.put("asd", map.getOrDefault("basd", 2));
        System.out.println(map.get("asd"));
        // �ʿ��� Ű�� �� ����
        for(String str : map.keySet()) map.get(str);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            entry.getKey();
            entry.getValue();
            entry.setValue(2);
        }
        // Ű�� �������� ���� ���� ���ο� ���� ����Ͽ� Map �� �߰��ϰ� �� ���� ��ȯ
        System.out.println(map.get("asddd"));
        map.computeIfAbsent("asddd", k -> 12);
        System.out.println(map.get("asddd"));


        // �ʿ��� Ư�� Ű Ȯ���ϰ� ���� �ϰų� ����
        if(map.containsKey("asd")) map.remove("asd");
        // �� <String, List<String>>
        Map<String, List<String>> group = new HashMap<>();
        // Alice Ű ������ ���ο� ����Ʈ ���� �� ������ ���ڿ� �ֱ�, Ű �̹� �����ϸ� ���� list ��ȯ
        String student = "Alice";
        List<String> check = group.computeIfAbsent(student, k->new ArrayList<>());
        System.out.println(group.get(student));
        check.add("qweqwe");
        System.out.println(group.get(student));
        // ��ť
        Deque<Integer> dq = new ArrayDeque<>();
        // ���� �߰�/����, ���� �߰�/����
        dq.addFirst(1); dq.pollFirst();
        dq.addLast(2);


        // arr -> Integer[]
        Integer[] warr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // list -> Integer[]
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        warr = list.toArray(Integer[]::new);
        System.out.println(warr[0]);
        // Integer[] -> arr
        arr = Arrays.stream(warr).mapToInt(i->i).toArray();
        // list -> arr
        arr = list.stream().mapToInt(i->i).toArray();
        // arr -> list
        // Integer[] -> list
        list = Arrays.stream(warr).collect(Collectors.toList());


        // Integer[] ������
        Arrays.sort(warr, Comparator.reverseOrder());
        // int[] arr ����
        Arrays.sort(arr);
        // int[] arr ������
            // ~
        // List ������ �� ����
        Collections.sort(list, Comparator.reverseOrder());
        Collections.reverse(list);
        // 2���� �� ��° ��ҷ� �������� ����
        Arrays.sort(arr2, (a, b) -> a[1] - b[1]);
        // 2���� ù ��ҷ� ��������, �ι�° ��ҷ� �������� ����
        Arrays.sort(arr2, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // 1���� ���� �迭�� double �迭�� ũ�� ������ ����
        Integer[] stg = new Integer[10];
        for (int i = 0; i < 10; i++) stg[i] = i + 1;
        double[] fail = new double[11];
        Arrays.sort(stg, (a, b) -> {
            if(fail[a] == fail[b])
                return Integer.compare(a, b);
            else
                return Double.compare(fail[b], fail[a]);
        });
        // ���ڿ� str ����� substr 0~3
        String str = "123";
        String substr = str.substring(0, 3);
        // ���ڿ� �迭 ������
        String[] sarr = str.split("");
        // ���ڿ� �迭 ������ ���Խ�
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        // �Ľ� int �� str
        // String[] -> List<String>
        // List<String> -> String[]
        // BR, BW
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer, ��ū ���� ���� �� ���� ��ū
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) st.nextToken();
    }
}
