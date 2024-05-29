import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] a ;

    static boolean[] c;

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int x){
        if(c[x]){
            return;
        }
        c[x] = true;
        sb.append(x).append(" ");
        for(int y : a[x]){
            if(c[y] == false){
                dfs(y);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;
        while (q.isEmpty() == false){
            int x = q.remove();
            sb.append(x).append(" ");
            for(int i : a[x]){
                if(c[i] == false){
                    c[i] = true;
                    q.add(i);
                }
            }
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            a[from].add(to);
            a[to].add(from);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(a[i]);
        }
        c = new boolean[n+1];
        dfs(start);
        sb.append("\n");
        c = new boolean[n+1];
        bfs(start);
        System.out.println(sb);

    }
}