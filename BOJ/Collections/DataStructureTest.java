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
        for(int i = 0; i < 10; i++) arr2[i] = arr.clone();
        // 0 <= arr 인덱스 < 1 만큼 brr 로 복사
        int[] brr = Arrays.copyOfRange(arr, 0, 1);
        // 정수 리스트 선언(list)
        List<Integer> list = new ArrayList<>();
        // 정수 그래프 선언
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 그래프 10만큼 초기화
        for (int i = 0; i < 10; i++) graph.add(new ArrayList<>());


        // 큐
        Queue<Integer> q = new LinkedList<>();
        // 비었는지 확인 후 추가 및 제거
        if(!q.isEmpty()) { q.offer(1); q.add(2); q.poll(); }
        // 힙 초기화 + 역정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 스택
        Stack<Integer> stk = new Stack<>();
        // 추가 및 제거
        stk.push(10); stk.pop();
        // 셋
        Set<Integer> set = new HashSet<>();
        // 4 포함하는지 체크 후 4 추가
        if(!set.contains(4)) set.add(4);
        // 맵 <String, Integer>
        Map<String, Integer> map = new HashMap<>();
        // 추가 2가지 버전
        map.put("asd", 1); map.put("asd", map.getOrDefault("asde", 2));
        System.out.println(map.get("asd"));
        // 맵에서 키와 값 추출
        for(String str : map.keySet()) map.get(str);
        // 키가 존재하지 않을 때만 새로운 값을 계산하여 Map 에 추가하고 그 값을 반환
        map.computeIfAbsent("asde", k -> 3);
        System.out.println(map.get("asde"));
        // 맵에서 특정 키 확인하고 변경 하거나 제거
        if(map.containsKey("asd")) map.replace("asd", 4);
        System.out.println(map.get("asd"));
        map.remove("asd");
        // 맵 <String, List<String>>
        Map<String, List<String>> groups = new HashMap<>();
        // Alice 키 없으면 새로운 리스트 생성 후 값으로 문자열 넣기, 키 이미 존재하면 기존 list 반환
        String student = "Alice";
        List<String> aliceCourses1 = groups.computeIfAbsent(student, k -> new ArrayList<>());
        aliceCourses1.add("Math");
        System.out.println(groups);
        System.out.println(aliceCourses1);
        // * 디큐
        Deque<Integer> dq = new ArrayDeque<>();
        // 앞쪽 추가/제거, 뒤쪽 추가/제거
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


        // Integer[] 역정렬
        Arrays.sort(warr, Comparator.reverseOrder());
        // int[] arr 정렬
        Arrays.sort(arr);
        // int[] arr 역정렬
        // ~~
        // List 역정렬 세 가지
        Collections.sort(list, Comparator.reverseOrder());
        Collections.reverse(list);
        // 2차원 두 번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a,b)->a[1]-b[1]);
        // 2차원 첫 요소로 내림차순, 두번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a,b)->a[1]==b[1]?a[0]-b[0]:b[1]-a[1]);


        // 문자열 str 선언과 substr 0~3
        String str = "123";
        String substr = str.substring(0, 3);
        // 문자열 배열 나누기
        String[] p = str.split("");
        // 문자열 배열 나누기 정규식
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        // 파싱 int 와 str
        int k = Integer.parseInt(str);
        str = String.valueOf(k);
        // BR, BW
        // StringTokenizer, 토큰 존재 여부 및 다음 토큰
    }
}
