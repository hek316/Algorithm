import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{


    public static void main(String[] arg) throws IOException{

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int[][] d = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                d[i][j] = -1;
            }
        }

        Queue<Point> q = new LinkedList<Point>();
        Queue<Point> next_q = new LinkedList<Point>();
        q.offer(new Point(0, 0));
        d[0][0] = 0;
        while(!q.isEmpty()){
            Point p = q.remove();
            for(int i=0; i<4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(d[x][y] == -1){
                        if(arr[x][y] == '0'){
                            d[x][y] = d[p.x][p.y];
                            q.offer(new Point(x, y));
                        } else {
                            d[x][y] = d[p.x][p.y]+1;
                            next_q.add(new Point(x, y));
                        }

                    }
                }
            }
            if(q.isEmpty()){
                q = next_q;
                next_q = new LinkedList<Point>();
            }

        }
        System.out.println(d[n-1][m-1]);

    }
}