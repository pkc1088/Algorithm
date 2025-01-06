
==Sorting==
71. r은 십진수의 10에 해당함. 자리수만큼 달라짐
75. 179자리 -> 271 (*오류*) . 데이터의 끝자리 숫자에 맞춰서 어레이 번호에 맞게 쌓음. f는 1의 자리수로 소팅이 되어있음.
76. 10의 자리수로 정렬. 앞 패스에서 이미 1의 자리수로 정렬되어 있기에 같은 자리수에서 정렬만 해주면 둘 간 정렬은 자동으로 됨. 
77. 100의 자리수로 정렬. 
78. internal sorting들 간 비교.
81. external sorting은 disk라는 external memory에서 load time과 seek time 등을 합해서 고려해야함.

==Complexity of Algorithm==
19. 통상 linear time algorithm이 quadratic time algorithm보다 효율적이다. 적은 스텝으로 표현 가능하기에.
20. n이 들어옴에 따라 패턴을 체크하자는 분석임. 점근적임.
21. 그걸 simplificate하게 만든 수식임. 차수가 낮은 것들은 높은 것들에 의해 영향이 미비하게 됨. 


==Divide and Conquer==
9. ~넘어감
10. 주어진 일 n을 다음엔 반만 함 -> n/2
12. 홀짝 나눈느 방식 다름
13. n/2은 k에 포함되는 단계임. 귀납법으로 증명 (1일 떄, 일반 k 일 때, 홀짝 일 때).
21. ~참고
22. 마지막 merge에서 n (오른쪽) +m (왼쪽) - 1 번 비교함. 2^k  = n  -> k = logn 이다 -> nlogn이 도출됨.
25. h+m-1은 나누는 순간에 비교하게 되는 횟수 (머지할 때 걸리는 시간). 전체 원소 수 n = h + m임.  
26. n-1은 n/2+n/2-1으로 유도 됨. 
31. 단계별 비교횟수는 n/2이다 (1단계는 n/2, 2단계는 n/4 .. ) -> 결국 O(n)임. n/2^k = 1이 될 때 까지 내려옴 -> 단계 k 는 logn임.
36. worst case는 피봇이 제일 끝에 있고 다른 한쪽으로 다 몰렸을 때임 -> O(n^2) 나온다.
38. 넘어감
44. monotone : 일차함수 처럼 한 방향으로만 증가하는 형태. 2^n처럼 지수가 붙어있어도 쓸 수 없다. 
50. 행렬 연산이 n^3 (for 3번) 나오는데 이걸 개선하기 위해 strassen algorithm 나옴. 
51. element대신 block 단위로 연산이 일어남.


==Divide and Conquer addition==
6. 절반 나눠서 제일 가까운 거리 조사하고 추가적으로 (p1, q3)도 확인해 줌. 
7. 이걸 재귀적으로 확인 함.
9. 주변 델타 만큼만 비교하면 됨. 가까운점 6개만 비교하면 됨
12. recurseive하게 반반 탐색이 O(logn). 


==Dynamic Programming 1==
2. divide and conquer는 top down, dp는 bottom up 방식임. 
4. (n-1 / k-1) = (n-2 / k-2) + (n-1 / k-1) 이고 (n-1 / k) = (n-2 / k-1) + (n-2 / k) 이다.
9. 다이고날 라인은 (k / k) 즉 k개 중에 k개 뽑는 것. (2 / 1) 은 (1 / 1) + (1/ 0)임. 계수를 표현한 표임. (a+b)^는 세로 (1,1,1,1, 1)이 나옴. (a+b)^2이면 (1, 2, 1)이 나옴 
10. (n/k)는 (a+b)^m 일때 a^k b^(n-k)의 계수를 구하는 거임 (a^(n-k) b^k 계수와 같음)
15. optimal value는 항상 최종 정답안에 포함됨. optimize 하는 과정에서 계속 그 값을 끌고 가니까. 

==Dynamic Programming 2==
3. 나타나는 순서가 같으면 subsequence (연속일 필요 x).
48. mismatch아면 -1 
56. local 은 초기화를 0으로. 

==Greedy ALgo==
21. 빈도수 차이로
65. principle of optimality 보장해야함. 새로운걸 넣을생각이 없으면 이전 아이템의 이득을 유지하면됨. 새로 넣으려면 W-wn을 넘어서는 안됨. 
73. 2,3 문단 넘어감


----
----


==Back Tracking==
7. DFS를 약간 수정한게 back tracking이다. 
13. 1,1은 promising node, 2,1은 갈 필요없어서 뺵 쳤으니 non promising node임.
23. 절대값 i-k는 가로길이, col(i) - col(k)는 세로 길이인데 이 둘이 같다는건 정사각형 상에서 대각에 위치한다는 뜻이니. 
25. 그 방법을 체택한 promising backtracking 방법임.
26. 총 체크 횟수를 따질땐 각 레벨에서 전체 pruned state space를 모두 조사하니 레벨이 커지는 만큼 n승하게 됨. 
27. 하나 결정될 때 다음게 위치할 수 없는 경우를 제거하면 팩토리얼 형태로 나옴. 
- 몬테카를로 알고리즘은 백트래킹과 결합하여 초기 탐색 방향을 설정하거나 확률적 가지치기를 통해 탐색 공간을 줄이는 데 유용합니다. 이를 통해 복잡한 문제를 보다 효율적으로 해결할 수 있습니다. 특히, 해의 공간이 크고 탐색 시간이 중요한 문제에서 몬테카를로 알고리즘을 활용하여 백트래킹의 성능을 개선할 수 있습니다.
36. 언급된 단계는 주로 확장(Expansion)단계에서 발생합니다. 이 단계를 더 자세히 설명하면 다음과 같습니다:
    1. **현재 노드**: 이 시점에서 트리의 현재 노드를 선택했습니다. 이 노드는 검색 공간의 특정 상태(예: 게임의 위치)를 나타냅니다.
    2. **유망한 자식 노드 생성**:
    - **유망한 자식 노드**: 현재 노드에서 지금까지의 검색을 기반으로 가장 유망한 이동이나 행동을 나타내는 자식 노드입니다.
    - **무작위 선택**: 모든 가능한 자식을 체계적으로 생성하거나 하나를 결정론적으로 선택하는 대신, 유망한 자식 중 하나를 무작위로 생성합니다. 이 무작위성은 더 넓은 검색 공간을 탐색하고 결정론적 함정을 피하는 데 도움이 됩니다.
    3. **유망한 자식 노드의 수 (mi)**: 이것은 현재 노드에서 유망한 자식 노드의 수입니다. 선택된 자식을 무작위로 생성하는 것은 이 유망한 옵션들 중에서 무작위로 선택하는 것입니다.
37. ti : 레벨 i에 있는 노드의 총 자식 노드 수입니다. mi: 레벨 i에 있는 노드 중에서 유망한(즉, 추가적으로 탐색할 가치가 있는) 자식 노드의 수입니다.
- 레벨 2 : 레벨 1에서 선택된 유망한 자식 노드(m0)의 모든 자식 노드(t1)가 탐색됩니다. 그 중에서 유망한 노드(m1)만이 다음 레벨로 확장됩니다.
- 탐색 노드 수 = 1 + t0 + m0 * t1
- 레벨 3 : 레벨 2에서 선택된 유망한 자식 노드(m0 * m1)의 모든 자식 노드(t2)가 탐색됩니다. 그 중에서 유망한 노드(m2)만이 다음 레벨로 확장됩니다.
- 탐색 노드 수 = 1 + t0 + m0 * t1 + m0 * m1 * t2

==Back Tracking 2== *16pge까지 리뷰함*
6. 앞으로의 모든 remaining + i 까지의 합한 모든 weight가 W보다 작아도 non promising.
7. W보단 커야 promising 하다 할 수 있음.
14. W는 인접행렬. 1이면 connected, 0이면 disconnected.
24. 내가 얻을 수 있는 '계산상'의 최고이득을 bound로 놓는다. 이걸 기준으로 promising 여부를 따짐. 
25. 시그마(i+1 ~ k-1)에서 k는 weight를 초과하는 아이템임. 

==Branch and Bound==
20. 계산오류 있는 듯.
30. bound는 미래 이득까지 같이 더함. 초과되면 아이템을 쪼갬. total weight는 쪼개서 넣지 않음.
38. 맨 마지막 노드 4 중복 오타
40. 각 row에서 0이 아닌 최소 값들을 더한게 가장 minimal한 값이 된다 (그 루트가 실제로 존재하는지는 모르지만 이것 보다 최소가 되는 경로는 없음). 그게 low bound가 됨.
42. 부터 계산은 교재 참조로 넘어감

==A Star Algorithm==
11. g(n) : start ~ n 까지의 거리비용. h(n) : n ~ 목표까지의 추정된 거리비용.
12. 그리드그래프임. 파란색 : 장애물. 빨간색 : 목표. 
16. h값이 0인 Astar가 다익스트라이다. 
19. 다익은 탐색공간이 너무 크다. 
20. 추정잔여거리 + 실제거리 작은 값을 선택.
23. 7이 오른쪽, 6이 밑, 5가 왼쪽으로 이동하는 경우가 뎁스가 1인 상태임. 파이널 스테이트와 비교해서 위치 마다 정답이 다르면 감정 주면서 평가함.
24. h는 미스매치 점수임.  g는 뎁스(변화량). h+g 작은 케이스를 선택해서 반복. 이미 자기 자리를 잘 잡은 애는 케이스 옮기는 케이스를 고려하지 않는듯 (이미 closed list에 들어가 있으니).  
29. D 한 다음엔 D보다 이전에 게산한 A가 더 작으니(16) A에 대해 E를 구함.
30. F를 구하고 나면 F가 B나 D보다 작으므로 계속 G를 구함. 이때 B는 이밈 closed list에 들어가있으니 계산할 필요 없음. 그래서 AEFG가 최종 경로가 됨. (D의 경우 B와 F 갈 수 없으니 답 아님). 
31. BDF나 BDC에서 G로 못가는 이유는 이미 앞에서 AEFG로 G를 closed list에 넣었기 때문인듯.
32. (h, g, f)에 대해 a(0, 21, 21). b(9, 14, 23). c(4, 18, 22). d(7, 18, 25). 가장 작은 c를 선택. e(21, 5, 26). f(16, 8, 24). 이제 가장 작은 b 선택. 이때 e는 이미 업데이트 된 상태인데 한 번 더 해봄. e(20, 5, 25) 그래서 e는 저게 더 작으니 저걸로 업데이트. 이제 f에 대해 해보고 ~. 최종적으로 abez가 shortest path가 되는 듯.  

 ==String Matching==
 12. 시그마는 오토마타를 구축하는 시간 (알파벳 문자 수).
15. A[i] * d^(m-1) + A[i+1] * d^(m-2) ... + A[i+m-1] * d^0 를 묶어냄. 
16. 356에 a를 뺴고 c를 더해서 1782를 찾아냄. 
23. 한 칸씩 뒤로 보내는게 아니라 접두부와 접미부가 일치하는 부분 만큼 그 위치로 옮김. 
28. a끼리 매칭됐으면 더 이상 움직이지 않고 다음것들과 비교함. 
29. w에서 미스매칭 일어나면 a를 쭉밀어서 밑에 리스트 상으로 까지 밀고 비교한다는 뜻임. 

==String Matching 2==
4. suffix array를 binary search 형태로 찾는 방법이 있다. 
5. n이 길면 시간오래걸리니
6. 통으로 비교하는게 아니라 첫 글자 기준으로 비교함. a로 시작하면 다 rank 1.
7. 이제 두 글자로 비교함.  ana와 anana 간의 순서는 비교하지 않고 그냥 같은 그룹으로 묶는다는 의미임. 이건 차후에 더 나누어야함을 의미함. 
8. 3글자가 아니라 2^n이니 4글자를 봄. 
11. 뒷 네글자 ATCA는 트리에서 suffix 9를 가짐을 확인할 수 있음. 

==Geometry Algorithm==
27. p1프라임은 p0->p1 선상의 벡터임. po-p1 선분은 p2 기준으로 clockwise 방향에 있음. p1프 x p2프와 p2프 x p1프는 다른듯. 
52. 넘어감
58. 보르누이 부터는 개념만 알기

==Geometry Algorithm2==
17. 저 영역에 있는 어떤 점(1번)이 교차되는 부분이다. 
21. 그리드 상 사각형에 포함된 영역만 탐색함.
25. 우선 점들의 x 좌표상 가운데 있는 값을 기준으로 분할함. 그 후 y축 값들 중 중간값으로 분할함. 이걸 번갈아가면 영역을 양분함. 
31. 들어오는 순서대로 2d tree 구축
- x축양분 후 y축 양분하면 다음과 같음
                 (9,1)
          (2, 7)               (17, 15)
       (3,6)   (6,12)    (10,19)  (13,15)

----

==Genetric Algorithm==
29. 섞는 방법.
32. 0인 부분은 바꿈.
36. 랜덤하게 바꿈
39. 돌연변이
42. 윗그림 잘못, 박스 한 칸 앞으로 옮겨야함. 밑그림 69.4와 67.5 박스
45. 목표에 빨리 도달할 수 있도록 역할을 함. 냅색에서 fitness function은 가방안에 들어있는 물건의 토탈 가치이다. 
46. generational : 부모 세대 모두를 바꾸는 방식
52. fx가 점점 좋아지는 방향이 될 것.
54. fitness funciton으로 1이 몇개 있는지 체크하는 것으로 삼음. 
59. 6개중에 4개의 돌연변이 발생. 2개는 2개 바꾸고 2개는 1개, 나머지 2개는 변화 없음. 
65. 섞는 규칙은 임의로 정한거임 패런츠 중에 한 영역은 그대로 유지하는거임. 





**Sorting**
- 내부 방법 : 정렬할 리스트가 작아 메인메모리 상에서 실행 가능할 때
- 외부 방법 : 큰 리스트에 사용
- bubble sort(n^2) : i(outer) = 1 to length, j(inner) = length down to i+1
- insertion sort(n^2) : j(outer) = 2 to n, i(inner) = j-1
- insertion sort는 이미 정렬된 어레이에선 best case(n)이다. 역방향 정렬시 worst case이다. n2/2 comparisons + n2/2 exchanges 일어남.
- selection sort : i = 0 to n-1, j = i+1 to n. n2/2 comaprisons, n exchanges 일어남.
- selecton > insertion > bubble. (이미 입력이 정렬되어 있는 경우 bubble > select). (n이 크면 select > insert)
- quick sort : partition(0n) + conquer(Olog2N) = total(Onlogn). heapsort보다 비교횟수 적어 보통 더 빠름. 반복문 빠져 나오면 left와 high 원소를 교환하고 피봇 위치인 high를 리턴한다. 이미 정렬된 경우 n2.
- merge sort : 정렬된 sub1과 sub2 비교해서 각각의 원소 취한 후 한 쪽 다 떨어지면 나머지 배열 다 가져옴. 정렬한 레코드 수에 비례하여 저장 공간이 추가로 필요. O(n) or O(n)의 추가 공간 사용
- heap sort :  일정한 양의 저장 공간만 추가로 필요. O(nlogn). 터미널 노드를 루트로 보내고 그 후 조정함. 자기 위치 찾기까지 이진트리의 높이만큼 일을 함 -> logN. 이 일을 n번 반복함 -> nlogN. 즉 heapify로 최대 힙 만든 다음에 마지막 엘리먼트(최소)와 첫 엘리먼트(최대;루트)를 교환해주고 힙 사이즈를 1줄인 후 그 상태에서 다시 heapify를 해주고 첫 원소와 마지막(기존 마지막-1)을 바꿔주는 형태를 계속함. 그러면 배열이 정렬됨.
- radix sort : O(d(n+r)). d패스를 처리하면서 각 패스의 연산 시간은 n+r임. 큐임으로 먼저 들어온건 먼저 빠짐. 그리고 3자리면 1의자리 부터 시작함.
- (최악, 평균) - insert(n2, n2), heap(nlogn, nlog), merge(nlogn, nlogn), quicl(n2, nlogn).

1. Selection Sort:
    - 최선: O(n^2)
    - 평균: O(n^2)
    - 최악: O(n^2)
2. Insertion Sort:
    - 최선: O(n)
    - 평균: O(n^2)
    - 최악: O(n^2)
3. Bubble Sort:
    - 최선: O(n)
    - 평균: O(n^2)
    - 최악: O(n^2)
4. Quick Sort:
    - 최선: O(n log n)
    - 평균: O(n log n)
    - 최악: O(n^2)
5. Merge Sort:
    - 최선: O(n log n)
    - 평균: O(n log n)
    - 최악: O(n log n)
6. Heap Sort:
    - 최선: O(n log n)
    - 평균: O(n log n)
    - 최악: O(n log n)
7. Radix Sort:
    - 최선: O(nk)
    - 평균: O(nk)
    - 최악: O(nk)

**Complexity**
- algorithm : procedure for solving the problem.
- n이 충분히 큰 경우 6n2 + 20n이 n3보다 작다는게 빅오임. 6n2 + 20n < n3 인 c와 n0를 찾을 수 있다 1과 9. 
- 오메가에서 이 식이 n3에 속함을 증명하려면 어떤 C>0와 모든 n>n0에 대해 6n2+20n >= Cn3을 만족하는 n0가 존재해야함. n이 충분히 크다고 가정할 때 6n2 + 20n / Cn3 >= 1 만족하는 C와 n0로 없기에 오메가(N3)에 속하지 않음.
- 빅세타는 빅오와 빅오메가 둘 다 참일때 성립함
- 마지막 레벨 제외하고 다 채워진게 almost 완전 이진 트리임. 이 트리가 힙인지 판단하기 위해서 1. 자식 없으면 리프니까 리턴. 2. 자식 하나면 왼쪽 자식인지 판단하고 자식과 값 비교. 3. 자식 두개면 힙 성질 만족하는지 값비교하고 양쪽 자식에 대해 recursive하게 동작.

**Divide n Conquer**
- Master Theorem을 쓸 수 없는 경우 T(n) = aT(n/b) + f(n)), T(1) = c. 
    1. T(n)이 sin(x) 처럼 monotone이 아닐 때 
    2. f(n)이 polynomial이 아닐 때 T(n) = 2T(n/2) + 2^n
    3. b가 constant로 표현이 안될 때 T(n) = T루트(n) 처럼
- Divide-and-conquer algorithms should be avoided in the following two cases: 
- ►1. An instance of size n is divided into two or more instances each almost of size n. => time complexity : exponential time 
- ►2. An instance of size n is divided into almost n instances of size n/c, where c is a constant. => time complexity : exponential time Θ(nlg n)

- 최근접 쌍 찾기 : 중앙 부분 d = min(d1, d2)이고 중앙선 기준 좌우로 d만큼의 범위에서 최근접 쌍을 찾아 보면 됨. 이때 범위 안 점을 y좌표로 sorting해서 6개만 비교해본다. divide가 logn이고 merge가 n이라 이때 nlogn 만큼 걸림.

**DP**
- nCr  계산을 dp로 하면 B_i_j = B_j-1_j-1 + B_i-1_j이다. j가 0 or i이면 B_i_j = 1이다.
- Optimization probelm - TSP : D(k)(i, j) = min(D(k-1)(i, j), D(k-1)(i, k) + D(k-1)(k, j)). 전자의 경우 k-1개의 중간 노드만 거쳐서 i -> j의 최소 거리를 구하는거고 후자는 노드k를 지날 때 i->k->j의 최소거리를 구한 거임. 이 둘 중 더 짧은 걸 고르면 됨. 그게 k까지의 노드를 사용해서 i -> j 이동의 최소값임. 
- Floyd's algo : 3중 for 문.  D(i,j) = min(D(i,j), D(i,k)+D(k,j)). 세타 n^3이 나옴. 이건 모든 도시 쌍 간의 최단 거리를 계산한 거임. 그 후 P(i,j)로 중간 버텍스가 최소 하나라도 있으면 -> vi to vj 경로 중의 노드 중 가장 인덱스 높은 것, 만약 중간 노드가 없으면 0으로 설정. 그 후 노드 q, r을 알고리즘에 넣으면 path(q, P(q,r)); cout << P(q,r); path(P(q,r), r); 형태를 반복문 if(P(q,r) != 0)일 때 까지 반복함.
- D(vi, A) = min vj ∈ A( W(i, j) + D( vj , A - {vj} ) ) if A≠∅. D(vi, ∅) = W(i, 1).
- 즉 D(v4, {v2})의 경우 W(4, 2)로 4에서 2로 가는 최소값 + D(vj, {v2} - {vj})인 것을 합한 것의 최소값으로 구한다. 즉 이건 v4에서 v2를 거쳐서 v1(시작)으로 가는 최소 값임.
- 정리하면 D(v1, {하나 노드})에서 시작해서 D(v1, {v2, v3, v4})로 확장 해서 구하는 거임. 이 값이 TSP의 정답이 됨. 이게 W(1, 2) + D(v2, {v3, v4})와 W(1,3) + D(v3, {v2,v4})와 W(1,4) + D(v4, {v2,v3}) 중 min임.
-  TSP는  n^2 * 2^n 의 세타를 가짐

**DP2**
- LCS : if ( Xi == Yj ) c[i,j] = c[i-1,j-1] + 1 
- else c[i,j] = max( c[i-1,j], c[i,j-1] )
- O(mn)의 러닝타임을 갖는다
- 역순으로 매칭레터를 찾고 싶으면 제일 끝에서 주위를 보고 제일 제일 큰 쪽으로 가면 됨. 3 - 2 - (2, 1) 중 2인 왼쪽 이런식으로 왼 위 대각 위가 다 똑같으면 대각 위로 간다. 이때 대각 위로 가는 경우만 출력 한다.
- Sequence Align : match(샵) - mismatch(뮤) - indels(오)
- S(i,j)는 S(i-1,j-1)+p(i,j) / S(i-1.j)-2 / S(i, j-1)-2 중 max임
- 52p C-G의 (3,3)좌표의 경우 왼이나 위인 0에서 -2된 -2보다 이전 단계인 2에서 p(i,j)에서 미스매칭으로 -1된 값 먹여서 2-1 = 1을 저장하는게 이득이라 -2가 아닌 1이 되는거임. (4,.3)도 같은 원리.
- 추출은 그냥 화살표 따라 가면 됨. 근데 Trace-back is started at the highest value rather than in lower right corner. Trace-back is stopped as soon as a zero is encountered

**Greedy**
- q해서 얻는 이익 P(i-1, w-wi) + pi와 추가하지 않는 p(i-1, w) 중에 맥시멈을 고르면 됨. 만약 초과한다면 이전값인 P(i-1, w) 선택함

- P 문제 : 결정론적 튜링머신으로 다항시간 내에 해결할 수 있는 문제.
- NP 문제 : 비결정론적 튜링머신으로 다항시간 내에 풀 수 있는 문제. 다항시간에 답의 존재유무를 확인할 수 있는 문제 (즉 해결방법은 모르나 답의 유무를 확인 가능한 문제들의 집합). 즉 다차시간 비결정적 알고리즘임. 어떤 결정 문제에 대해서 검증을 다차 시간에 하는 알고리즘이 있다면, 그 결정 문제는 NP에 속한다. 어떤 결정 문제를 풀 수 있는 다차 시간 알고리즘을 찾을 수 없을 때, 다차 시간 비결정적 알고리즘을 찾으면 그 문제는 NP에 속한다. 다루기 힘들다고 증명되지 않았고, 다차시간알고리즘도 찾지 못한 문제(0-1배낭, 외판원, m coloring, 해밀토니안). 추측단계는 비결정적(아무답 추측), 검증단계는 결정적(yes or no로 대답). 
- NP에 속하지 않는 문제 : 다루기 힘들다(intractable)고 증명이 된 문제.
- 결정형문제(decision problem) : 답이 yes or no 하나로 결정되는 문제.
- 결정성 알고리즘 : 각 단계에서 다음 단계가 유일하게 결정되는 알고리즘 <-> 비결정성 알고리즘
- 다차시간 비결정 알고리즘 : 검증단계가 다차시간 알고리즘인 비결정성 알고리즘. 이때 다차시간은 시간복잡도의 상한이 입력 크기의 다항식인 알고리즘을 말함.
- NP hard : NP만큼 어려운 문제. NP에 속하는 모든 문제에 대해 다른 문제로 다항시간에 환원되는 문제
- NP Complete : NP인 동시에 NP hard인 문제면서 NP의 문제를 다항시간내에 다른 문제로 환원 가능한 문제
- P 문제 집합이 NP 문제 집합에 속하는 이유: P 문제를 해결하는데 다항식 시간이 걸리므로 이를 NP 알고리즘이 문제의 해를 다항식 시간에 확인하는 것과 대응시킬 수 있기 때문이다.
- 백트랙킹 : 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 알고리즘. DFS는 가능한 모든 경로(후보)를 탐색합니다. 따라서, 불필요할 것 같은 경로를 사전에 차단하거나 하는 등의 행동이 없으므로 경우의 수를 줄이지 못합니다.
- A* 알고리즘은 Best-First 검색을 이용해 시작점에서 도착점까지의 가장 적은 비용을 사용하는 경로를 찾아냄
- Geometry : 기하학 문제 해결을 위한 자료구조와 알고리즘에 대한 연구
- Genetic : 최적화 및 검색 문제에 대한 해 또는 근사해를 찾기 위해 컴퓨터 과학에서 사용되는 메타휴리스틱 알고리즘
- Convex Hull : Smallest (area ) convex polygon enclosing the points.
- Graham : abc가 clockwise면 b를 제외함.
- 구간검색트리 : left max endpoint < low => go right else go left.
- area > 0 반시계, p1xp2 > 0 시계(p1이 p2로 부터)


- *용어 개념 정의 외우기*
- nQueens : col (i) - col (k) = i - k or col (k) - col (i) = i - k 이면 대각.
- Subset sum : weight + wi+1 > W이거나 weight + totalr < W이면 nonpromising임.
- Graph coloring : start에서 색깔 개수만큼 자식 만들고(v1) 총 vertex만큼 N depth를 가짐 
- Hamiltonian circuit (state space tree) : 시작 노드를 트리의 레벨0에 넣고 레벨1에는 이전 단계(시작노드)에서 갈 수 있는 노드들을 넣음. i번째 노드는 i-1번째 노드와 인접해야하며 n-1번째 노드는 시작노드와 인접해야함. i번째 노드는 i-1번째의 첫노드가 될 수 없음. i번째 노드는 이미 방문한 노드가 아니어야 합니다. 가능한 모든 노드를 방문하고 시작 노드로 돌아오면 탐색을 중지하고 해밀토니안 회로를 찾았다고 보고합니다. 탐색 중에 방문할 노드가 없거나, 시작 노드로 돌아오는 경로가 없으면 해당 경로는 해밀토니안 회로가 아니므로 백트랙킹(backtracking)을 사용하여 이전 단계로 돌아갑니다. 완성 조건: n번째 레벨에서는 마지막으로 방문한 노드가 시작 노드와 인접해야 완전한 회로가 형성됩니다.
- knapsack with backtracking : *DFS 방식인듯* 현재 상태에서 앞으로의 선택이 최적의 해를 가져올 가능성이 없으면 그 선택을 배제하는 방식. 현재 용량 초과하면 유망하지 않음, 남은 물건들로 최적 가치 달성 가능 여부로 판단(이를 위해 upper bound를 계산 : 현재 선택된 물건들의 가치에 남은 물건들을 담을 수 있는 최대한의 가치를 더한 값을 의미). 이 상한값이 현재까지 발견된 최적해의 가치보다 낮다면, 더 이상 탐색할 필요가 없다. 바운드는 profit + 시그마Pj(i+1~k-1) + (W - totweight) x Pk / Wk. (profit per unit weight for kth item). 채울 수 있을 만큼 채운 다음 마지막 물건은 쪼게어서 빈틈없이 채운다. 이것이 이 노드를 계속 탐색했을 때 얻을 수 있는 최대 이익이다. 각 depth마다 아이템을 하나 갖는다.,아이템을 배치한 순서는 '가성비'이다. 값을 무게로 나누어 무게당 값이 높은 것 부터 위에 배치한다. 그렇게 아이템 1 ~ 4를 위에서 부터 아래로 배치한다. 각 노드에서 왼쪽 간선으로 뻗어 나가는건 그 depth번째의 물건을 담는다는 것을,  오른쪽 간선 쪽은 담지 않는다는 것을 의미한다.  각 노드는 price와 weight를 갖는다.  그리고 bound라는 값을 갖는데, 해당 노드에서 계속 뻗어 나갈 때 얻을 수 있는 최대 이득이다. bound의 계산은 그리디하게, 빈틈없이 채운다.  그러니까 아래로 내려가면서 채울 수 있는 만큼 모두 채운 다음, 마지막엔 남은 무게만큼 물건을 잘라 채운다. 그리고 전역적으로 최대 값인 maxPrice 변수를 갖는다. 이 maxPrice는 최고 price를 갖는 노드를 만날 때마다 갱신된다. 어떤 bound를 계산했을 때, maxPrice보다 작다면 그 노드의 자식노드들은 탐색 하나 마나 max가 될 수 없다. 물론 depth번째 물건을 담는 경우 배낭 무게 상한을 초과하면 그 노드도 더는 탐색하지 않아도 된다. 이 두 상황을 유망하지 않다 라고 표현하며, 유망한 노드만 탐색을 이어 나갈 것이다.
- *weight <= W && bound > maxprofit이여야 promising이다*.  [알고리즘: 되추적(BackTracking)을 이용한 0 - 1 배낭채우기 문제(0- 1 knapsack problem) 공부하기 :: Memo Memo (tistory.com)](https://seungjuitmemo.tistory.com/109)
- 즉 0레벨에선 하나도 안 담을때를 가정하니(profit=0) 1번과 2번 담을 담는데 3번 담으면 용량 초과되니까 3번을 쪼개서 비율만큼 담는것임. 즉 전체 16에서 1과2무게인 7을 뺀 9kg에 대해 3번의 비율 p/w = 5를 곱해 더한것이 바운드가 된다. 
- 레벨 1은 1번을 의무적으로 담고 위 방식을 계속함. profit은 아이템 1을 담으니 0+40이 된다. 기존 maxprofit 0보다 큼으로 40으로 갱신시킴. 바운드는 profit(40) + 30 + (16-7)50/10 = 115. maxprofit도 40임. 
- 노드 (2,1)에서는 1번과 2번 아이템을 의무적으로 담으니 profit은 40+30 = 70에 weight는 2+5 = 7. maxprofit은 profit(70) > maxprofit(40)이니 70이 된다. bound는 profit(70)+ (16-7)50/10 = 115. 
- 노드 (3,1)은 용량초과로 nonpromising->끝. 
- 여기서 노드 (2, 1)로 되추적해서 노드 (3, 2)로 간다. 아이템3을 포함하지 않으므로 profit은 70이고 maxprofit도 여전히 70. bound = 70 + 10 (4번째 넣어도 용량초과하지 않으니) = 80. bound(80) > maxprofit(70)이므로 유망함. 이 과정을 반복함
- totweight는 노드 포함 여부에 따라 효율 내림차순 순으로 해당 노드까지의 무게들 최대로 더하면되는거임

- Breadth First Branch and Bound : 시작 노드에서 부터 레벨 뎁스별로 왼->오로 조사함. promising여부 따지는건 기존방식과 동일. 큐를 이용해 구현함. 기존 되추적 알고리즘 보다 좋지 않음
- Best First Branch and Bound : 주어진 마디의 모든 자식을 검색하고 망하면서 확장되지 않은 마디들 중 가장 좋은 바운드를 가진 마디를 확장한다. 최고의 한계를 가진 마디를 우선적으로 선택하기 위해 우선순위 대기열인 힙을 사용해 구현함. Breadth First 보다 좋음. 즉 자식을 만들었을 때 bound 더 큰 애로 자식을 확장시킴. 지나친 쪽의bound가 만들어 놓은 자식들 보다 더 크면 그쪽으로 다시 가서 확장시킴. 그리고 maxprofit 갱신됐을 때 확장 안된 애들 중 bound < maxprofit 되는 애들 있으면 nonpromising임으로 확장 안 시켜버림.
- TSP with Branch and Bound : 레벨 별로 갈 수 있는 경로를 추가해서 만들고 완성된 트리에서 리프 노드들 중 가장 짧은 얘가 정답임. 총 노드가 5개면 마지막 하나의 노드와 최초 위치로 되돌아갈(노드1)는 알고 있으니 노드가 4개 일 때 까지만 확장시키면 됨. 
- 주어진 마디에서 뻗어 나가서 얻을 수 있는 여행경로의 길이의 최소치를 구하여 bound로 삼음. *bound < minpath이면 promising하다*. minpath(최소여행경로)의 초기값은 무한. A = V - (1~k경로에 속한 모든 노드의 집합) 이라고 할 때, 
- bound = 1~k 경로 총거리 + vk에서 A에 속한 정점으로 가는 간선 중 최소치 + 시그마(vi에서 A U {v1}-{vi}에 속한 정점으로 가는 간선 중 최소치)  
- 각 row에서 0이 아닌 최소 값들을 더한게 가장 minimal한 값이 된다 (그 루트가 실제로 존재하는지는 모르지만 이것 보다 최소가 되는 경로는 없음). 그게 low bound가 됨.
- (v1, v2)계산할 때 vx에서 v1 가는건 min의 후보에 넣어도 되자만 vx에서 v2로 가는건 후보로 넣으면 안됨 v2의 경우 v1에서 v2로 온거니까 v2->v1은 후보될 수 없음. 즉 (v1, v2)이 주어지고 각 로우별로 따질 때 v2 칼럼은 후보가 될 수 없고 v2의 경우 v1을 후보로 둘 수 없음
- 노트 참고하고, 최종 자식 바운드 보다 확장되지 않은(지나친) 노드의 바운드가 더 적으면 거기서 확장을 시킨다. 

- A star : 조사한 노드들은 closed list(초기 공집합), 조사하지 않은 노드는 open list(초기 시작점만)에 저장하고 closed list 중 f(x)값이 가장 좋은 노드(current 노드)를 찾음. 찾은 노드가 도착점이면 종료, 아니면 인정한 다른 노드들에서 찾음. 평가 fx(최소비용) = gx(목적함수-현노드까지의 경로 비용) + hx(휴리스틱값). [A* 알고리즘(A star algorithm) grid map 개념 및 구현 (tistory.com)](https://recall.tistory.com/40)
- 최초에 시작노드에서 다음 노드 잡을떄 인접 노드들 중 휴리스틱 값 가장 적은 노드로 가는 듯. (open list들 중 fn 가장 작은 값을 선택하는거임). 오픈리스트에는 인접노드들이 들어가고 거기서 선택된 노드는 클로즈리스트에 들어감.
- 다익스트라는 h가 0인 에이스타. h = 0은 실제 남은 거리보다 크지 않아야 된다는 조건을 만족하므로 에이스타라 볼 수 있음. Vertex x로부터 목적점에 이르는 잔여거리의 추정치 h(x)는 실제치보다 크면 안된다 (a star 조건).
- S->G로 가는 최단 경로 찾을 때 G에 도착해도 해당 f값보다 아직 덜 확장된 자식 노드들 중 더 작은 f값 갖는 애 있으면 거기서도 확장해서 확인해줘야함.

- substring S(2,4)는 2~4번째 문자(3글자)를 말함.
- subsequence는 zero나 단어 몇개 지워서 연속되면 됨
- Rabin Karp : 문자열 패턴을 특정 값으로 바꾸어 수치비교로 문자열비교를 대신함. 평균 수행시간 O(n+m)
- acebb -> cebbc 로 넘어갈때 cebb는 중복됨으로 acebb에서 맨 앞 a값(0x5^4) 빼준거에서 한 칸씩 쉬프트 했으니 x5해주고 마지막 값 c(2)를 더해주면 됨. 즉, a*i* = d(a*i-1* – d^*m-1* * A(i-1)) + A(i+m-1)
- a*i*가 매우 커지면 오버플로우 발생하니 모듈러로 제한한다. 
- KMP : 패턴을 전처리(preprocessing)하여 접미부와 일치하는 최대 접두부 SP를 구하고 이 정보를 이용하여 매칭하는 방법. 평균 수행시간 O(n+m). 즉 한 칸씩 뒤로 보내는게 아니라 접두부와 접미부가 일치하는 부분 만큼 그 위치로 옮김. 
- abcdabcwz 배열 구성할때 첫원소는 -1이고 그 뒤부터는 중복되는 캐릭터가 존재하지 않으면 처음부터 비교해야하니 다 0이됨. 그러다 중복되는 캐릭터가 발견되면 이건 0으로 잡고(패턴 처음이 a일때 a를 발견하면 0으로 셋팅) 그 뒤도 일치하면(b) 1씩 증가시키면서 준다. [[알고리즘] KMP 알고리즘 (velog.io)](https://velog.io/@hwan2da/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-KMP-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)
- 위 방식대로 접두사 접미사 일치하는 만큼 해준 배열에서 앞에 -1붙여주면 됨 000012300 -> -1000012300 처럼.
- Boyer-Moore : 패턴의 오른쪽 부터 비교함. 최선의 경우에도 오메가(n). 점프 정보는 오른쪽 끝문자가 tiger라고 치면 43215가 됨. rational 의 a같이 중복되는게 있으면 76543218에서 제일 오른쪽 a만 살려둬서 7543218이됨. 그래서 패턴 ...aal..과 만나면 al은 일치하고 bad character는 앞쪽 a인데 
- bad character가 패턴에 존재하면 그 위치로 이동시키고, 패턴에 존재하지 않으면 아예 전체를 점프시킨다. 후퇴하는 일을 막기 위해 good suffix와 같이 씀
- 정리 : 마지막페이지는 a가 중복되니 rtional 점프테이블이 구성되는데 이 패턴의 길이만큼 점프시키는듯. bad character와 good suffix 중 더 큰 점프 할 수 있는걸 선택함. [Boyer-Moore string search algorithm - JH programming (heiwais25.github.io)](https://heiwais25.github.io/algorithm/2018/10/03/boyer-moore-string-search-algorithm/)
- [기술사 - 알고리즘 - 보이어-무어 알고리즘 (youtube.com)](https://www.youtube.com/watch?v=mXQtunIEo0k) 착한접미부와 일치하는 문자열 없는 경우 착한접미부의 왼쪽 부터 하나씩 줄여가면서 반복조사, 완전 불이치면 패턴 길이만큼 이동
- 앞의 a를 착한접미부 뒤로 위치시키는듯?

- 맨버마이어스 : 첫 한글자 기준 정렬 -> 첫 두 글자 기준 정렬 -> 첫 네 글자 기준 정렬. 기준 내에선 다 같은 rank임.
- suffix tree : 왼쪽 한 글자 씩 지워서 suffix를 글자수 만큼 만들고 거기서 서로 다른 앞 글자 만큼 자식을 만듦. 예를 들어 a, c, t이면 a, ca, tca로 앞글자 중복안되게 만드는거임. 그리고 저 3가지로 계속 가지치기 하는듯. O(n+m) [Suffix Tree Construction (youtube.com)](https://www.youtube.com/watch?v=amp1UcSKeCY)
- *area > 0 반시계, p1xp2 > 0 시계(p1이 p2로 부터)*
- Geometry Algo : 기하학적 문제를 해결하기 위한 효율적인 데이터 구조 및 알고리즘을 다룸.
- CCW : area > 0 이면 반시계, < 0이면 시계, 0이면 collinear. area = (bx-ax)(cy-ay)-(by-ay)(cx-ax). 
- 외적 p1xp2 = x1y2 - x2y1 이 positive면 시계, negative면 반시계.
- p1' x p2' 이 positive면 p1'이 p2'에 대해 시계, negative면 반시계. 이때 p1'은 p1-p0 로 구한다.
- Two Segments Intersect : p1p2, p3p4가 intersect한지는 p1p2에 대해 점 p3와 점 p4가 서로 왼쪽오른쪽 다른 위치에 존재하면 됨. 이건 p3가 p1p2에 대해 왼쪽 오른쪽인지 판단하는 방법은 p3' x p2' 이 <0이면 p3'이 p2'에 대해 반시계임. 이때 p3'은 p3-p1이 된다. (p1을 시작점으로 잡으니). p4' x p2' 에 대해서 구하면 > 0 나오면 p1p2와 p3p4가 교차함을 알 수 있음. 즉 둘 선분이 조사값이 음, 양이면 교차, 한쪽으로 몰리면 교차 x, 한 값이 0이면 교차(한 선분의 시작지점이 다른 선분 안에 존재), 둘다 0이여도 교차(p1p4에 대해 p3p2가 내부에 존재). 근데 둘 다 0이여도 교차 안 할 수도 있음.
- 그래서 Bounding Box 씀 : 일반적으로 바운딩 박스 두 개가 겹치지 않으면 선분도 겹치진 않음. 근데 항상 그런건 아님 (가까이서 평행할 때).
- Convex Hull : Smallest (area ) convex polygon enclosing the points.
- package wrapping method : 첫 archor point는 가장 작은 y 값 갖는 것으로 셋팅. 지평선을 위로 집어 올렸을 때 접촉하는 점들을 차례로 연결함. 이 방법을 완전히 wrapped 될 때 까지 반복해서 컨벡스헐 구축.
- Graham Scan : 주어진 n개의 정점으로 닫힌 경로를 만든다(경로구축). 최하위점을 선택하고, 모든 점들을 검사하기 위해 시작. 검사중인 세 점 ABC을 기준으로 그 각이 예각 혹은 둔각(CCW or CW)인지 검사함. 만약 clockwise(CW)이면 정점B는 convex hull집합에서 제외함. 49pge에 LNP는 반시계이니 N은 포함, NPx는 시계이니 P를 제외
- 1D영역탐색 : BST로 탐색
- sweep-line algo : 1d range 안에 있는 어떤 점이 해당 range와 교차되는 되는 부분임.
- 2d 직교 grid 구현 : 영역 검색 시 2d 범위 쿼리에 해당되는 사각형만 검사. 
- 2d tree : recursively divide space into two halfplanes. 나눌때 나누는 점의 x, y좌표를 기준(key)으로 세로, 가로 순차로 구분하는 듯. 선상의 x좌표는 왼쪽, y좌표는 밑으로 편입.
- 구간검색트리 : (lo, hi)로 BST 구성하는데 lo로 구성함(key). 그리고 max endpoint는 본인 서브트리에서 가질 수 있는 가장 큰 hi로 셋팅됨. 만약 새로운 키가 들어오면 lo 따라서 bst 하고 만약 새 노드의 hi가 가장 크다면 부모 노드들의 max endpoint를 다 업뎃해줌. 구간을 검색하기위해 (21, 23)이 들어오면, 왼쪽 서브트리의 max endpoint가 새 노드의 lo보다 작으면 오른쪽으로 감. 아니면 왼쪽으로 감. 즉 left max endpoint < low => go right else go left.
- 위 탐색이 right 방향으로 이루어졌다면 left에서의 교차는 존재하지 않음. left 방향으로 이루어졌다면 left에서 교차가 하나 있거나 아예 없음. 현재 노드의 구간보다 오른쪽에 있는 구간에서 교차를 찾습니다. 따라서 왼쪽 서브트리에는 교차 구간이 존재하지 않습니다. 현재 노드의 구간보다 왼쪽에 있는 구간에서 교차를 찾습니다. 따라서 왼쪽 서브트리에서 교차 구간을 찾을 수 있거나, 교차 구간이 아예 없을 수 있습니다.
- orthogoanl rectangle interseciton : sweep line과 동일

- population : encdoing(The process of representing the solution in the form of a string that conveys the necessary information.)으로 표현
- selection/reproduction/recombination : The process that chooses solutions to be preserved and allowed to reproduce and selects which ones must to die out.
- selection : raw fitness(목적함수에 개체의 표현형을 적용한 결과로 얻어진 원시 수치)의 적합도 값을 조정 즉 표준화 하면 적합도 함수(fitness function)을 얻음. 집단 중 다음 단계로 교배를 수행하는 개체의 생존분포를 결정함. 표준화 방법으론 선형 표준화, 옴 절단, 거듭제곱 표준화.
- Roulette wheel selection : 룰렛돌려서 운빨로 뽑음
- crossover : 균일교배 : a1~a10, b1~b10있을때 m 비트에 따라 0인 비트에 서로 뒤바꾸는 방식(single, two point도 같은 방식). 주기교배 : gpt참고. 
- Elitism : copy the best chromosomes to new population before applying corssover and mutation.
- Mutation(돌연변이) : random inversion of bits in solution to maintain diversity in population set.
- fitness function은 정답(염색체)의 최적을 수량으로 나타냄. A fitness value is assigned to each solution depending on how close it actually is to solving the problem.
- Generational GA: entire populations replaced with each iteration. Steady-state GA: a few members replaced each generation
- MAXONE : fitness f 는 1의 개수





