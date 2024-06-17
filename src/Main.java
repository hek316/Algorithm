import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N;
    static boolean[] check;
    static ArrayList<Integer>[] arr;
    static int[] order;
    static int[] parents;
    static int[] child;
    static public void dfs(int idx){
        if(check[idx]){
            return;
        }
        check[idx] = true;
        for(int y : arr[idx]){
            if(check[y] == false){
                child[idx] +=1;
                parents[y] = idx;
                dfs(y);
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        order = new int[N+1];
        check = new boolean[N+1];
        parents  = new int[N+1];
        child = new int[N+1];
        for(int i=0; i <=N; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i <= N; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        if(order[1] != 1 ){
            System.out.println("0");
            return;
        }

        dfs(1);

        Stack<Integer> stack = new Stack<>();
        boolean result = findOrder(stack, 1);
        if(result){
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static public boolean findOrder(Stack<Integer> stack, int idx){
        if(idx == N){
            return true;
        }
        int x = order[idx];
        if(!stack.isEmpty()){
            int t = stack.peek();
            int p = parents[x];
            if(t != p){
                return false;
            }
            child[p]--;
            if(child[p] == 0){
                stack.pop();
            }
        }
        if(child[x] != 0){
            stack.add(x);
        }
        if(findOrder(stack, idx+1) == false) return false;
        else return true;
    }
}