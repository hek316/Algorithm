import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] arr;
    static boolean[][] visited;
    static int cnt = 0;

    static int[] dx = {-1,0,0,1,-1,-1,1, 1};
    static int[] dy = {0,-1,1,0,-1, 1,1, -1};

    static int w;
    static int h;

    static void dfs(int i, int j){
        if(visited[i][j]) return;
        visited[i][j] = true;
        if (arr[i][j] == '1'){
            for(int k=0; k<8; k++){
                int nx = i+dx[k], ny = j+dy[k];
                if(nx>= 0 && ny >= 0 && nx < h&& ny< w){
                    dfs(nx, ny);
                }

            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals("0 0")){
            StringTokenizer st = new StringTokenizer(s);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            arr = new char[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                String str = br.readLine();
                for(int j=0; j<w; j++){
                    char tmp = str.charAt(j*2);
                    arr[i][j] = tmp;
                    if(tmp == '0'){
                        visited[i][j] = true;
                    }
                }
            }
            // 섬의 개수
            cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(visited[i][j] == false){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        br.close();
        System.out.println(sb);


    }
}