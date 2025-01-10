# 현재 디렉토리에서 모든 .java 파일을 찾고 처리
for file in *.java; do
    # 파일명에서 문제 번호 추출 (예: 03.21 BOJ 4196.java -> 4196)
    problem_number=$(echo "$file" | sed -E 's/^[0-9]{2}\.[0-9]{2} BOJ ([0-9]+).*$/\1/')

    # 새 파일명 생성 (예: BOJ_4196.java)
    new_name="BOJ_${problem_number}.java"

    # 파일명 변경
    mv "$file" "$new_name"

    # Java 파일 내부의 클래스 이름 변경 (예: public class Main -> public class BOJ_4196)
    sed -i "s/public class Main/public class BOJ_${problem_number}/" "$new_name"
done
