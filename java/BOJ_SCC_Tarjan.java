import java.io.*;
import java.util.*;

public class BOJ_SCC_Tarjan {

    static HashMap<Integer,List<Integer>> adj=new HashMap<>();
    static int Disc[]=new int[8];
    static int Low[]=new int[8];
    static boolean inStack[]=new boolean[8];
    static Stack<Integer> stack=new Stack<>();
    static int time = 0;

    static void DFS(int u) {
        System.out.println("DFS "+u);
        Disc[u] = time;
        Low[u] = time;
        time++;
        stack.push(u);
        inStack[u] = true;
        List<Integer> temp=adj.get(u);
        // get the list of edges from the node.

        if(temp==null)
            return;

        for(int v : temp) {
        System.out.println("v : "+v);
        if(Disc[v]==-1) {
        //If v is not visited
        DFS(v);
        Low[u] = Math.min(Low[u],Low[v]);
        }
        //Differentiate back-edge and cross-edge
        else if(inStack[v]) //Back-edge case
        Low[u] = Math.min(Low[u],Disc[v]);
        }

        if(Low[u]==Disc[u]) {//If u is head node of SCC
        System.out.print("SCC is: ");
        while(stack.peek()!=u) {
        System.out.print(stack.peek()+" ");
        inStack[stack.peek()] = false;
        stack.pop();
        }
        System.out.println(stack.peek());
        inStack[stack.peek()] = false;
        stack.pop();
        }
        }

static void findSCCs_Tarjan(int n) {
        for(int i=1;i<=n;i++) {
        Disc[i]=-1;
        Low[i]=-1;
        inStack[i]=false;
        }

        for(int i=1;i<=n;++i) {
            if(Disc[i]==-1)
                DFS(i);   // call DFS for each undiscovered node.
        }
}

public static void main(String[] args) {
        adj.put(1,new ArrayList<Integer>());
        adj.get(1).add(3);

        adj.put(2,new ArrayList<Integer>());
        adj.get(2).add(1);
        adj.put(3,new ArrayList<Integer>());
        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.put(4,new ArrayList<Integer>());
        adj.get(4).add(5);
        adj.put(5,new ArrayList<Integer>());
        adj.get(5).add(6);
        adj.put(6,new ArrayList<Integer>());
        adj.get(6).add(7);
        adj.put(7,new ArrayList<Integer>());
        adj.get(7).add(4);

        findSCCs_Tarjan(7);
        }

}
