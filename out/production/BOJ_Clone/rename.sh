#!/bin/bash

# 현재 디렉토리에서 모든 .java 파일을 찾고 처리
for file in *.java; do
    # 파일명에서 중복된 NDB_와 .java를 제거하여 새 파일명 생성
    new_name=$(echo "$file" | sed -E 's/^NDB_//;s/\.java\.java$/\.java/')

    # 파일명 변경
    mv "$file" "$new_name"

    # Java 파일 내부의 클래스 이름 변경 (예: NDB_16_5 -> NDB_16_5)
    sed -i "s/public class NDB_[0-9]+-[0-9]+/public class ${new_name%.java}/" "$new_name"
done

echo "파일 이름과 클래스 이름 변경 완료."
