import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static char[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;

    static int[] dx = {+1, 0, -1, 0};
    static int[] dy = {0, +1, 0, -1};
    static boolean result;

    public static void dfs(int i, int j, int prei, int prej){
        if(visited[i][j]){ return;}
        visited[i][j] = true;
        for(int m=0; m<4; m++){
            int x = i + dx[m];
            int y = j + dy[m];
            if(x >= 0 && y >= 0 && x < N && y < M && arr[i][j] == arr[x][y]){
                if(x == prei && y == prej){
                    continue;
                }
                if(visited[x][y] == false){
                    dfs(x,y, i, j);
                } else if(visited[x][y] == true){
                    result = true;
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] == false){
                    dfs(i,j, i,j);
                    if(result){
                        System.out.println( "Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");

    }
}import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Main{

    static char[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;

    static int[] dx = {+1, 0, -1, 0};
    static int[] dy = {0, +1, 0, -1};
    static boolean result;

    public static void dfs(int i, int j, int prei, int prej){
        if(visited[i][j]){ return;}
        visited[i][j] = true;
        for(int m=0; m<4; m++){
            int x = i + dx[m];
            int y = j + dy[m];
            if(x >= 0 && y >= 0 && x < N && y < M && arr[i][j] == arr[x][y]){
                if(x == prei && y == prej){
                    continue;
                }
                if(visited[x][y] == false){
                    dfs(x,y, i, j);
                } else if(visited[x][y] == true){
                    result = true;
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] == false){
                    dfs(i,j, i,j);
                    if(result){
                        System.out.println( "Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");

    }
}