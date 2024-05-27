import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge{
    int from, to;

    Edge(int from, int to){
        this.from = from;
        this.to = to;
    }

}

public class Main {

    static boolean[] visited;
    static int answer;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        //인접리스트
        list = (ArrayList<Integer>[])new ArrayList[n];

        for(int i=0; i<n; i++){
            list[i] = new ArrayList<Integer>();
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        for(int i=0; i<n; i++){
            if(answer != 1) dfs(1,i);
        }
        System.out.println(answer);

    }

    public static void dfs(int dept, int start){
        if(dept == 5){
            answer = 1;
            return;
        }
        visited[start] = true;
        for(int to :  list[start]){
            if(visited[to] == false){
                dfs(dept+1, to);
            }
        }
        visited[start] = false;

    }
}