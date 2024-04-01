import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visit;

    static int MIN;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];
        MIN = Integer.MAX_VALUE;


        StringTokenizer st ;
        for(int i=0; i<arr.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<arr.length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j=0; j<arr.length; j++){
            if(arr[0][j]== 0){
                continue;
            }
            visit[0] = true;
            visit[j] = true;
            nextArr(1,n, j, arr[0][j]);
            visit[j] = false;
        }
        System.out.println(MIN);

    }

    public static void nextArr(int idx, int n, int now, int cost){
        if(idx == n-1){
            if(arr[now][0] == 0){
                return;
            }
            // 첫 행선지로 돌아가기
            cost += arr[now][0];
            MIN = Math.min(cost, MIN);
            return;
        }

        for(int j=1; j<n; j++){
            // 다음에 갈 행선지
            if(visit[j] == false && arr[now][j] != 0){
                visit[j] = true;
                nextArr(idx+1,n,j, cost+  arr[now][j]);
                visit[j] = false;
            }
        }

    }



}