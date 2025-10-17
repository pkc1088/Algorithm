package BOJ.Collections;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class DataStructureTest {

    public static void main(String[] args) throws IOException {
        Test();
    }
    /*
    deque �����
    StringTokenizer, moreElements
     */
    public static void Test() throws IOException {
        // 1���� �迭 ����(arr)
        int[] arr = new int[10];
        // -1�� arr ä���
        Arrays.fill(arr, -1);
        // 2���� �迭 ����(arr2)
        int[][] arr2 = new int[10][10];
        // arr2�� arr�� �����ϱ�
        for(int i = 0; i < arr.length; i++) arr2[i] = arr.clone();
        // ����Ʈ ����
        List<Integer> list = new ArrayList<>();
        // �׷��� ����
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // �׷��� 10��ŭ �ʱ�ȭ
        for(int i = 0; i < 10; i++) graph.add(new ArrayList<>());
        // ť
        Queue<Integer> q = new LinkedList<>();
        // ������� Ȯ�� �� �߰� �� ����
        if(!q.isEmpty()) q.poll(); else q.offer(1);
        // ��
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
        map.put("basd", 1);
        map.put("cve", map.getOrDefault(100, 1));
        // ** �ʿ��� Ű�� �� ����
        for(String s : map.keySet()) map.get(s);
        // ** Ű�� �������� ���� ���� ���ο� ���� ����Ͽ� Map �� �߰��ϰ� �� ���� ��ȯ
        map.computeIfAbsent("basd", k -> 1);
        // ** �ʿ��� Ư�� Ű Ȯ���ϰ� ���� �ϰų� ����
        if(map.containsKey("basd")) map.replace("basd", 1);
        map.remove("basd");
        // �� <String, List<String>>
        Map<String, List<String>> groups = new HashMap<>();
        // Alice Ű ������ ���ο� ����Ʈ ���� �� ������ ���ڿ� �ֱ�, Ű �̹� �����ϸ� ���� list ��ȯ
        String student = "Alice";
        List<String> aliceCourses1 = groups.computeIfAbsent(student, k -> new ArrayList<>());

        // ** arr -> Integer[]
        Integer[] wrappedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // * arr -> list
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // * list -> arr
        arr = list.stream().mapToInt(i->i).toArray();
        // 0 <= arr �ε��� < 1 ��ŭ brr �� ����
        int[] brr = Arrays.copyOfRange(arr, 0, 1);
        // ** Integer[] -> List<Integer>
        list = new ArrayList<>(Arrays.asList(wrappedArr));
        // List<Integer> -> Integer[]
        Integer[] newArr = list.toArray(new Integer[0]);
        // Integer[] ������
        Arrays.sort(wrappedArr, Comparator.reverseOrder());
        // int[] arr ����
        Arrays.sort(arr);
        // int[] arr ������
            // do
        // List ������ �� ����
        Collections.sort(list, Comparator.reverseOrder());
        Collections.reverse(list);
        list.sort(Comparator.reverseOrder());
        // 2���� �� ��° ��ҷ� �������� ����
        Arrays.sort(arr2, (a,b)-> a[1] - b[1]);
        // 2���� ù ��ҷ� ��������, �ι�° ��ҷ� �������� ����
        Arrays.sort(arr2, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
