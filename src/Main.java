import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int K;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dfs(K,0);
        System.out.println(MIN);

    }
    static void dfs(int k, int time) {
        if(N >= k){
            MIN = Math.min(MIN, time+ N-k);
            return;
        }

        dfs(N, time + k - N);


        if(N==0 && k <2){
            MIN = Math.min(MIN, time+ k);
            return;
        }

        if(k%2 == 0){
            dfs(k/2, time);
        } else{
            dfs(k+1, time+1);
            dfs(k-1, time+1);
        }
    }

}