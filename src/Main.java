import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[][] arr;
    static int[][] cnt;
    static boolean[][] visited;
    static int[][] island;
    static int N;
    static int[] dx = {-1, +1, 0, 0};
    static int[] dy = {0, 0, +1, -1};
    static int MIN = Integer.MAX_VALUE;

    static int num = 0;

    static  Queue<Point> q = new LinkedList<>();

    public static void findIsland(Point start){
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(start);
        num++;
        visited[start.x][start.y] = true;
        island[start.x][start.y] = num;
        while (!queue.isEmpty()){
            Point t = queue.remove();
            for(int i=0; i<4; i++){
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if(a >= 0 && b >= 0 && a < N && b < N){
                    if(visited[a][b] == false && arr[a][b] == 1){
                        island[a][b] = num;
                        visited[a][b] = true;
                        Point point2 = new Point(a, b);
                        queue.add(point2);
                    }
                }
            }
        }
    }
    public static void bfs(){
        while (!q.isEmpty()){
            Point t = q.remove();

            visited[t.x][t.y] = true;
            for(int i=0; i<4; i++){
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                int land = island[t.x][t.y];
                if(a >= 0 && b >= 0 && a < N && b < N){
                    if(visited[a][b] == false && arr[a][b] == 0){
                        cnt[a][b] = cnt[t.x][t.y] + 1;
                        visited[a][b] = true;
                        island[a][b] = land;
                        Point point = new Point(a, b);
                        q.add(point);
                    } else if (visited[a][b] == true && land != island[a][b] ){
                        MIN = Math.min(cnt[t.x][t.y] + cnt[a][b], MIN);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        cnt = new int[N][N];
        visited = new boolean[N][N];
        island = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int c = Integer.parseInt(st.nextToken());
                arr[i][j] = c;
                if (c == 1) {
                    q.add(new Point(i, j));
                }
            }
        }
        // 섬의 번호 부여
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && island[i][j] == 0) {
                    findIsland(new Point(i, j));
                }
            }
        }
        visited = new boolean[N][N];
        bfs(); // bfs 를 통해 최소 다리 길이 찾기
        System.out.println(MIN);
    }
}