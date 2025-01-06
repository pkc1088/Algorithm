import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Stack<String> stk = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str="", k="";
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()) {
                str = st.nextToken();
                if(str.equals("push")) {
                    stk.push(st.nextToken());
                }
                else if(str.equals("pop")) {
                    if(!stk.empty())
                        System.out.println(stk.pop());
                    else
                        System.out.println(-1);
                }
                else if(str.equals("size")) {
                    System.out.println(stk.size());
                }
                else if(str.equals("empty")) {
                    System.out.println(stk.empty() ? 1 : 0);
                }
                else if(str.equals("top")) {
                    if(!stk.empty())
                        System.out.println(stk.peek());
                    else
                        System.out.println(-1);
                }
            }
        }
    }
}
