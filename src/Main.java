import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] cnt;

    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        cnt = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                cnt[i][j] = -1;
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        cnt[0][0] = 0;
        while(!queue.isEmpty()){
            Point p = queue.remove();
            for(int i=0; i<4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x >= 0 && y >= 0 && x < N && y < M){
                    int next = 0;
                    if(arr[x][y] == '1'){
                        next = cnt[p.x][p.y] + 1;
                    } else {
                        next = cnt[p.x][p.y];
                    }
                    if(cnt[x][y] == -1  || cnt[x][y] != -1 && cnt[x][y] > next){
                        queue.add(new Point(x,y));
                        cnt[x][y] = next;
                    }

                }
            }

        }

        System.out.println(cnt[N-1][M-1]);

    }
}