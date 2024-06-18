import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int MAX = 100001;
    static int[] dx = {-1 , +1};
    static int[] seconds = new int[MAX];
    static int[] parents = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static int start;
    static int k;


    static Queue<Integer> queue = new LinkedList<>();

    // 시작점 < 목적지
    static boolean leftside = false;

    static Stack<Integer> stack;

    public static void bfs(){
        int cnt = 0;
        while (!queue.isEmpty()){
            int t = queue.remove();
            cnt = seconds[t] + 1;
            // 좌우로 한칸씩 이동
            for(int i=0; i<2; i++){
                int next = t + dx[i];
                if(next >=0 && next < MAX){
                    if(visited[next] == false){
                        parents[next] = t;
                        visited[next] = true;
                        seconds[next] = cnt;
                        if(next == k){
                            return;
                        }
                        if((leftside && next < k )|| (!leftside && k < next )){
                            queue.add(next);
                        }
                    }
                }
            }
            // 2*x 칸으로 이동
            int x2 = 2*t;

            if(x2 < MAX){
                if( visited[x2] == false){
                    seconds[x2] = cnt;
                    parents[x2] = t;
                    if(x2 == k){
                        return;
                    }
                    if(visited[x2] == false){
                        if(Math.abs(x2-k) + cnt < Math.abs(start-k)){
                            visited[x2] = true;
                            queue.add(x2);
                        }
                    }
                }
            }

        }
    }

    public static void dfs(int k){
        stack.push(k);
        if( k == start){
            return;
        }
        dfs(parents[k]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        if(start == k){
            sb.append("0\n").append(start);
            System.out.println(sb);
            return;
        }

        if (start < k){
            leftside = true;
        }

        queue.add(start);
        visited[start] = true;

        bfs();
        dfs(k);

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(seconds[k]);
        System.out.println(sb);


    }
}