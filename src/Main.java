import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[][] arr;
    static int[][] cnt;


    static int[] dx = {+1, +2, +1, +2, -2, -1, -2, -1};
    static int[] dy = {+2, +1, -2, -1, +1, +2, -1, -2};


    public static void bfs(int[] start, int[] end, int l){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()){
            int[] r = q.poll();

            for(int i=0; i<8; i++){
                int x = r[0] + dx[i];
                int y = r[1] + dy[i];
                if(x>=0 && y>=0 && x < l && y < l && cnt[x][y] == 0){
                    cnt[x][y] = cnt[r[0]][r[1]]+ 1;
                    q.add(new int[]{x,y});
                    if(x == end[0] && y == end[1]){
                        return;
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 갯수
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            // 체스판의 한 변의 길이
            int l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            cnt = new int[l][l];
            st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] end = new int[2];
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            if(start[0] == end[0] && start[1] == end[1]){
                sb.append("0\n");
            } else {
                bfs(start, end,l);
                sb.append(cnt[end[0]][end[1]]).append("\n");
            }
        }

        br.close();
        System.out.println(sb);

    }

}