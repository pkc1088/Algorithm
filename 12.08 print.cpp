public class HelloJava {
    public static void main(String[] args) {
        System.out.println("hello2" + 1);
        System.out.printf("%o%n", 122);
        for (int i = 0; i < 1 + 2; i++) {
            System.out.println("i = " + 2);
        }
        char ch='c';    String str="what the fuck";
        System.out.printf("%c %d%n", ch, (int)ch);
        System.out.printf("%20s", str);
    }
}
