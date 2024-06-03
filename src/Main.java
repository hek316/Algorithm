import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    // 세로
    static int N;
    // 가로
    static int M;
    static int[][] arr;
    static int[][] days;


    static int[] dx = {-1, +1, 0, 0};
    static int[] dy = {0, 0, +1, -1};

    static Queue<int[]> q = new LinkedList<>();

    static boolean all_ripen =true;


    public static void bfs(){

        while (!q.isEmpty()){
            int[] r = q.poll();

            for(int i=0; i<4; i++){
                int x = r[0] + dx[i];
                int y = r[1] + dy[i];
                if(x>=0 && y>=0 && x < N && y < M && days[x][y] == 0 && arr[x][y] != 1){
                    days[x][y] = days[r[0]][r[1]]+ 1;
                    q.add(new int[]{x,y});
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        days = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.offer(new int[]{i,j});
                } else if(arr[i][j] == -1){
                    days[i][j] = -1;
                } else if(arr[i][j] == 0){
                    all_ripen = false;
                }
            }
        }

        if (all_ripen) {
            System.out.println(0);
            return;
        }
        bfs();
        br.close();



        int day = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (days[i][j] == 0 && arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                day = Math.max(day, days[i][j]);
            }
        }

        System.out.println(day);

    }

}