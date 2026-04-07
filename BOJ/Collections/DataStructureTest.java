package BOJ.Collections;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class DataStructureTest {

    public static void main(String[] args) throws IOException {
        Test();
    }

    public static void Test() throws IOException {
        // 1차원 배열 선언(arr)
        int[] arr = new int[10];
        // -1로 arr 채우기
        Arrays.fill(arr, -1);
        // 2차원 배열 선언(arr2)
        int[][] arr2 = new int[10][10];
        // arr2에 arr로 복사하기
        for (int i = 0; i < arr2.length; i++) arr2[i] = arr.clone();
        // 0 <= arr 인덱스 < 1 만큼 brr 로 복사
        int[] brr = Arrays.copyOfRange(arr, 0, 1);
        // 정수 리스트 선언(list)
        List<Integer> list = new ArrayList<>();
        // 정수 그래프 선언
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 그래프 10만큼 초기화
        for(int i = 0; i < 10; i++) graph.add(new ArrayList<>());

        // 큐
        Queue<Integer> q = new LinkedList<>();
        // 비었는지 확인 후 추가 및 제거
        if(q.isEmpty()) q.offer(10); q.poll();
        // 힙 초기화 + 역정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 스택
        Stack<Integer> stk = new Stack<>();
        // 추가 및 제거
        stk.push(10); stk.pop();
        // 셋
        Set<String> set = new HashSet<>();
        // 4 포함하는지 체크 후 4 추가
        if(!set.contains("asd")) set.add("asd");
        // 맵 <String, Integer>
        Map<String, Integer> map = new HashMap<>();
        // 추가 2가지 버전
        map.put("apple", 1);
        map.put("banana", map.getOrDefault("banana", 1));
        // 맵에서 키와 값 추출
        for(String s : map.keySet()) {
            System.out.println(s);
            System.out.println(map.get(s));
        }
        // 키가 존재하지 않을 때만 새로운 값을 계산하여 Map 에 추가하고 그 값을 반환
        map.computeIfAbsent("pearl", k->1);
        // 맵에서 특정 키 확인하고 변경 하거나 제거
        if(map.containsKey("pearl")) map.replace("pearl", 3);
        // 맵 <String, List<String>>
        Map<String, List<String>> group = new HashMap<>();
        // Alice 키 없으면 새로운 리스트 생성 후 값으로 문자열 넣기, 키 이미 존재하면 기존 list 반환
        String student = "Alice";
        group.computeIfAbsent(student, k->new ArrayList<>()).add("java");
        group.computeIfAbsent(student, k->new ArrayList<>()).add("C++");
        // 디큐
        Deque<Integer> dq = new ArrayDeque<>();
        // 앞쪽 추가/제거, 뒤쪽 추가/제거
        dq.offerFirst(3); dq.offerLast(5);
        dq.pollFirst(); dq.pollLast();

        // int[] -> Integer[]
        Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // List<Integer> -> Integer[]
        Integer[] integerArray2 = list.toArray(Integer[]::new);
        // Integer[] -> int[]
        int[] intArr = Arrays.stream(integerArray).mapToInt(i->i).toArray();
        // List<Integer> -> int[]
        int[] intArr2 = list.stream().mapToInt(i->i).toArray();
        // int[] -> List<Integer>
        List<Integer> intList = Arrays.stream(intArr).boxed().toList();
        // Integer[] -> List<Integer>
        List<Integer> intList2 = Arrays.stream(integerArray).toList();

        // Integer[] 역정렬
        Arrays.sort(integerArray, Comparator.reverseOrder());
        // int[] arr 정렬
        Arrays.sort(arr);
        // int[] arr 역정렬
        int[] brr2 = new int[arr.length];
        for(int i = 0; i < arr.length; i++) brr2[brr2.length - i - 1] = arr[i];
        // List 뒤집기
        Collections.reverse(list);
        // List 역정렬 세 가지
        Collections.sort(list, Comparator.reverseOrder());
        Collections.sort(list, Collections.reverseOrder());
        list.sort(Comparator.reverseOrder());
        // 2차원 두 번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a,b) -> a[1] - b[1]);
        // 2차원 첫 요소로 내림차순, 두번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // 1차원 순서 배열(stages)을 double 배열(fail)의 크기 순으로 정렬(실패율 큰 순, 실패율 같으면 작은 번호 우선)
        Integer[] stages = new Integer[10];
        for (int i = 0; i < 10; i++) stages[i] = i + 1;
        double[] fail = new double[11];

        Arrays.sort(stages, (a, b) -> {
            if (fail[a] == fail[b]) return Integer.compare(a, b); // 실패율 같으면 작은 번호 우선
            return Double.compare(fail[b], fail[a]); // 실패율 큰 순
        });

        // 문자열 str 선언과 substr 0~3
        String str = "12 34 56";
        String str2 = str.substring(0, 3);
        // 문자열 배열 나누기
        String[] p = str.split(" ");
        System.out.println(">>>>>" + p[2]);
        // 문자열 배열 나누기 정규식
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        String[] reg = text.split("[,.]");
        System.out.println("[" + reg[0] + "], [" + reg[1] + "], [" + reg[2] + "]");

        // 파싱 int 와 str
        int k = Integer.parseInt("123");
        String str3 = String.valueOf(k);
        // String[] -> List<String>
        List<String> stringList = new ArrayList<>(Arrays.asList(text));
        // List<String> -> String[], 그 후 출력
        String[] stringArray = stringList.toArray(String[]::new);
        System.out.println(Arrays.toString(stringArray));
        // BR, BW
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer, 토큰 존재 여부 및 다음 토큰
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        if(st.hasMoreTokens()) st.nextToken();
    }
}
