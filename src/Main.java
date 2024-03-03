import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        N = s.charAt(0) - '0';
        M = s.charAt(2) - '0';
        arr = new int[N];
        visit = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs( int dept){
        if(M == dept){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }

        for(int i=0; i<N; i++){
            if(false == visit[i]){
                arr[dept] = i+1;
                visit[i] = true;
                dfs(dept+1);
                visit[i] = false;
            }
        }
    }
}