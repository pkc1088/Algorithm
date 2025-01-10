# ���� ���丮���� ��� .java ������ ã�� ó��
for file in *.java; do
    # ���ϸ��� ���� ��ȣ ���� (��: 03.21 BOJ 4196.java -> 4196)
    problem_number=$(echo "$file" | sed -E 's/^[0-9]{2}\.[0-9]{2} BOJ ([0-9]+).*$/\1/')

    # �� ���ϸ� ���� (��: BOJ_4196.java)
    new_name="BOJ_${problem_number}.java"

    # ���ϸ� ����
    mv "$file" "$new_name"

    # Java ���� ������ Ŭ���� �̸� ���� (��: public class Main -> public class BOJ_4196)
    sed -i "s/public class Main/public class BOJ_${problem_number}/" "$new_name"
done
