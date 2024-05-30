import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] grp;

    static ArrayList<Integer>[] arr;

    static StringBuilder sb = new StringBuilder();

    static boolean dfs(int node, int c){
        grp[node] = c;
        for(int i : arr[node]){
            int current = grp[i];
            if (grp[node] == current) {
                return false;
            }
            if(current == 0){
                if(dfs(i,  3 - grp[node]) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st ;
        // 정점의 갯수 V , 간선의 갯수 E
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[V+1];
            for(int j=0; j<=V; j++){
                arr[j] = new ArrayList<Integer>();
            }
            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int u1 = Integer.parseInt(st.nextToken());
                int v1 = Integer.parseInt(st.nextToken());
                arr[u1].add(v1);
                arr[v1].add(u1);
            }

            grp = new int[V+1];
            boolean result = true;
            for(int m=1; m<=V; m++){
                // 방문안한경우만 호출
                if(grp[m] == 0){
                    result = dfs(m,1);
                    if(result == false){
                        break;
                    }
                }
            }

            sb.append(result ? "YES" : "NO").append("\n");
        }
        br.close();
        System.out.println(sb);

    }
}