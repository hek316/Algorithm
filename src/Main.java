import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer>[] arr ;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        int[] parents = new int[n+1];
        for(int i=0; i<parents.length; i++){
            parents[i] = -1;
        }


        Queue<Integer> queue = new LinkedList<Integer>();
        for(int y: arr[1]){
            queue.add(y);
            parents[y] = 1;
        }
        while (!queue.isEmpty()){
            int t = queue.remove();
            for(int y: arr[t]){
                if(parents[y] == -1){
                    parents[y] = t;
                    queue.add(y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }
}