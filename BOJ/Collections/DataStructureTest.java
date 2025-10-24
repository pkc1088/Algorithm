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
        int[] brr = Arrays.copyOfRange(arr, 0, 1);
        // ���� ����Ʈ ����(list)
        List<Integer> list = new ArrayList<>();
        // ���� �׷��� ����
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // �׷��� 10��ŭ �ʱ�ȭ
        for (int i = 0; i < 10; i++) graph.add(new ArrayList<>());


        // ť
        Queue<Integer> q = new LinkedList<>();
        // ������� Ȯ�� �� �߰� �� ����
        if(!q.isEmpty()) { q.offer(1); q.add(2); q.poll(); }
        // �� �ʱ�ȭ + ������
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // ����
        Stack<Integer> stk = new Stack<>();
        // �߰� �� ����
        stk.push(10); stk.pop();
        // ��
        Set<Integer> set = new HashSet<>();
        // 4 �����ϴ��� üũ �� 4 �߰�
        if(!set.contains(4)) set.add(4);
        // �� <String, Integer>
        Map<String, Integer> map = new HashMap<>();
        // �߰� 2���� ����
        map.put("asd", 1); map.put("asd", map.getOrDefault("asde", 2));
        System.out.println(map.get("asd"));
        // �ʿ��� Ű�� �� ����
        for(String str : map.keySet()) map.get(str);
        // Ű�� �������� ���� ���� ���ο� ���� ����Ͽ� Map �� �߰��ϰ� �� ���� ��ȯ
        map.computeIfAbsent("asde", k -> 3);
        System.out.println(map.get("asde"));
        // �ʿ��� Ư�� Ű Ȯ���ϰ� ���� �ϰų� ����
        if(map.containsKey("asd")) map.replace("asd", 4);
        System.out.println(map.get("asd"));
        map.remove("asd");
        // �� <String, List<String>>
        Map<String, List<String>> groups = new HashMap<>();
        // Alice Ű ������ ���ο� ����Ʈ ���� �� ������ ���ڿ� �ֱ�, Ű �̹� �����ϸ� ���� list ��ȯ
        String student = "Alice";
        List<String> aliceCourses1 = groups.computeIfAbsent(student, k -> new ArrayList<>());
        aliceCourses1.add("Math");
        System.out.println(groups);
        System.out.println(aliceCourses1);
        // * ��ť
        Deque<Integer> dq = new ArrayDeque<>();
        // ���� �߰�/����, ���� �߰�/����
        dq.addFirst(1); dq.addLast(2); dq.pollFirst(); dq.pollLast();


        // arr -> Integer[]
        Integer[] warr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // Integer[] -> arr
        arr = Arrays.stream(warr).mapToInt(i->i).toArray();
        // arr -> list
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // list -> arr
        arr = list.stream().mapToInt(i->i).toArray();
        // Integer[] -> list
        list = Arrays.stream(warr).collect(Collectors.toList());
        List<Integer> list2 = new ArrayList<>(Arrays.asList(warr));
        System.out.println(list);
        System.out.println(list2);
        // * list -> Integer[]
        Integer[] newArr = list.toArray(new Integer[0]);


        // Integer[] ������
        Arrays.sort(warr, Comparator.reverseOrder());
        // int[] arr ����
        Arrays.sort(arr);
        // int[] arr ������
        // ~~
        // List ������ �� ����
        Collections.sort(list, Comparator.reverseOrder());
        Collections.reverse(list);
        // 2���� �� ��° ��ҷ� �������� ����
        Arrays.sort(arr2, (a,b)->a[1]-b[1]);
        // 2���� ù ��ҷ� ��������, �ι�° ��ҷ� �������� ����
        Arrays.sort(arr2, (a,b)->a[1]==b[1]?a[0]-b[0]:b[1]-a[1]);


        // ���ڿ� str ����� substr 0~3
        String str = "123";
        String substr = str.substring(0, 3);
        // ���ڿ� �迭 ������
        String[] p = str.split("");
        // ���ڿ� �迭 ������ ���Խ�
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        // �Ľ� int �� str
        int k = Integer.parseInt(str);
        str = String.valueOf(k);
        // BR, BW
        // StringTokenizer, ��ū ���� ���� �� ���� ��ū
    }
}
