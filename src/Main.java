import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N;
    static int[] visited;
    static int[] cnts;

    static ArrayList<Integer>[] arr;

    // 순환선 찾기
    public static int dfs(int  idx, int pre){
        // 2 : cycle
        // 1 : visited and not included
        // -2 : found cycle
        if(visited[idx] == 1) {
            return idx;
        }
        visited[idx] = 1;
        for(int y : arr[idx]){
            if(y == pre){
                continue;
            }
            int res = dfs(y, idx);
            if(res == -2) return -2;
            if (res > 0) {
                visited[idx] = 2;
                if( res == idx ) return -2;
                return res;
            }
        }
        return -1;
    }
    // 지선 거리구하기
    public static void findDistance(int dist, int n, int pre){
        for(int j=0; j< arr[n].size(); j++){
            int t = arr[n].get(j);
            if (t == pre) {
                continue;
            }
            cnts[t] = dist;
            findDistance(dist+1, t, n);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new int[N+1];
        cnts = new int[N+1];

        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        dfs(1, -1);

        // 순환선이 아닐때 -1 로 초기화
        for(int i=0; i<=N; i++){
            if(visited[i] != 2) {
                cnts[i] = -1;
            }
        }

        for(int i=1; i<=N; i++){
            if(visited[i] == 2) {
                for(int j=0; j< arr[i].size(); j++){
                    int n = arr[i].get(j);
                    if(cnts[n] == -1){
                        cnts[n] = 1;
                        findDistance(2, n, i);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(cnts[i]).append(" ");
        }
        System.out.println(sb);

    }
}