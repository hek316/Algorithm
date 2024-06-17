import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static boolean[] visited;
    static int[] child;
    static int[] parents;

    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];
        child  = new int[N+1];
        parents = new int[N+1];

        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            result[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int t = q.remove();
            for(int y : arr[t]){
                if(visited[y] == false){
                    parents[y] = t;
                    child[t] +=1;
                    q.add(y);
                    visited[y] = true;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);

        for(int i=2; i<=N; i++){
            int n = result[i];
            int t = queue.peek();
            int p = parents[n];
            if(t != p) {
                System.out.println("0");
                return;
            } else {
                child[t] = child[t] -1;
                if(child[t] == 0){
                    queue.remove();
                }
            }

            if(child[n] != 0){
                queue.add(n);
            }
        }
        System.out.println("1");
    }
}