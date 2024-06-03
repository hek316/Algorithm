import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static char[][] arr;

    static int[][] cnt;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};

    static int N;
    static int M;

    static void bfs(){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()){
            Point t = queue.remove();
            if(t.x == (N-1) && t.y == (M-1)) {
                return;
            }

            if(cnt[t.x][t.y] != 0){
                for(int k=0; k<4; k++){
                    int nx = t.x+dx[k], ny = t.y+dy[k];
                    if(nx>= 0 && ny >= 0 && nx < N && ny< M && arr[nx][ny] == '1' && cnt[nx][ny] == 0){
                        queue.add(new Point(nx, ny));
                        cnt[nx][ny] = cnt[t.x][t.y]+1;
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        cnt = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char tmp = str.charAt(j);
                arr[i][j] = tmp;
            }
        }
        cnt[0][0] = 1;
        bfs();

        br.close();
        System.out.println(cnt[N-1][M-1]);

    }
}