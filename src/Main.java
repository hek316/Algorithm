import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int N;

    static int sum = 0;

    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};

    static void dfs(int i, int j){
        if(visited[i][j]) return;
        visited[i][j] = true;
        if (arr[i][j] == 1){
            sum++;
            for(int k=0; k<4; k++){
                int nx = i+dx[k], ny = j+dy[k];
                if(nx>= 0 && ny >= 0 && nx < N&& ny< N){
                    dfs(nx, ny);
                }

            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];



        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                int tmp = s.charAt(j) - '0';
                arr[i][j] = tmp;
                if(tmp == 0){
                    visited[i][j] = true;
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        List<Integer> results = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] == false){
                    sum = 0;
                    dfs(i, j);
                    results.add(sum);
                }
            }
        }
        Collections.sort(results);
        sb.append(results.size()).append("\n");
        for(int i=0; i<results.size(); i++){
            sb.append(results.get(i)).append("\n");
        }

        br.close();
        System.out.println(sb);


    }
}