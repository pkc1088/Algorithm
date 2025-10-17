package BOJ.Collections;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class DataStructureTest {

    public static void main(String[] args) throws IOException {
        Test();
    }
    /*
    deque 만들기
    StringTokenizer, moreElements
     */
    public static void Test() throws IOException {
        // 1차원 배열 선언(arr)
        int[] arr = new int[10];
        // -1로 arr 채우기
        Arrays.fill(arr, -1);
        // 2차원 배열 선언(arr2)
        int[][] arr2 = new int[10][10];
        // arr2에 arr로 복사하기
        for(int i = 0; i < arr.length; i++) arr2[i] = arr.clone();
        // 리스트 선언
        List<Integer> list = new ArrayList<>();
        // 그래프 선언
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 그래프 10만큼 초기화
        for(int i = 0; i < 10; i++) graph.add(new ArrayList<>());
        // 큐
        Queue<Integer> q = new LinkedList<>();
        // 비었는지 확인 후 추가 및 제거
        if(!q.isEmpty()) q.poll(); else q.offer(1);
        // 힙
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
        map.put("basd", 1);
        map.put("cve", map.getOrDefault(100, 1));
        // ** 맵에서 키와 값 추출
        for(String s : map.keySet()) map.get(s);
        // ** 키가 존재하지 않을 때만 새로운 값을 계산하여 Map 에 추가하고 그 값을 반환
        map.computeIfAbsent("basd", k -> 1);
        // ** 맵에서 특정 키 확인하고 변경 하거나 제거
        if(map.containsKey("basd")) map.replace("basd", 1);
        map.remove("basd");
        // 맵 <String, List<String>>
        Map<String, List<String>> groups = new HashMap<>();
        // Alice 키 없으면 새로운 리스트 생성 후 값으로 문자열 넣기, 키 이미 존재하면 기존 list 반환
        String student = "Alice";
        List<String> aliceCourses1 = groups.computeIfAbsent(student, k -> new ArrayList<>());

        // ** arr -> Integer[]
        Integer[] wrappedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // * arr -> list
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // * list -> arr
        arr = list.stream().mapToInt(i->i).toArray();
        // 0 <= arr 인덱스 < 1 만큼 brr 로 복사
        int[] brr = Arrays.copyOfRange(arr, 0, 1);
        // ** Integer[] -> List<Integer>
        list = new ArrayList<>(Arrays.asList(wrappedArr));
        // List<Integer> -> Integer[]
        Integer[] newArr = list.toArray(new Integer[0]);
        // Integer[] 역정렬
        Arrays.sort(wrappedArr, Comparator.reverseOrder());
        // int[] arr 정렬
        Arrays.sort(arr);
        // int[] arr 역정렬
            // do
        // List 역정렬 세 가지
        Collections.sort(list, Comparator.reverseOrder());
        Collections.reverse(list);
        list.sort(Comparator.reverseOrder());
        // 2차원 두 번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a,b)-> a[1] - b[1]);
        // 2차원 첫 요소로 내림차순, 두번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
