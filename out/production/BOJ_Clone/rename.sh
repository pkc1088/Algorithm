#!/bin/bash

# ���� ���丮���� ��� .java ������ ã�� ó��
for file in *.java; do
    # ���ϸ��� �ߺ��� NDB_�� .java�� �����Ͽ� �� ���ϸ� ����
    new_name=$(echo "$file" | sed -E 's/^NDB_//;s/\.java\.java$/\.java/')

    # ���ϸ� ����
    mv "$file" "$new_name"

    # Java ���� ������ Ŭ���� �̸� ���� (��: NDB_16_5 -> NDB_16_5)
    sed -i "s/public class NDB_[0-9]+-[0-9]+/public class ${new_name%.java}/" "$new_name"
done

echo "���� �̸��� Ŭ���� �̸� ���� �Ϸ�."
