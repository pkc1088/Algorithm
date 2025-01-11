#!/bin/bash

# 현재 디렉토리에서 0으로 시작하는 파일을 찾고 삭제
find . -type f -name '03*' -exec rm -f {} \;

echo "01으로 시작하는 파일들이 삭제되었습니다."
