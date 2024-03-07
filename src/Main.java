import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        N = s.charAt(0) - '0';
        M = s.charAt(2) - '0';
        arr = new int[M];

        dfs(0,0);
        System.out.println(sb);
    }

    public static void dfs(int start, int dept){
        if(M == dept){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<N; i++){
            arr[dept] = i+1;
            dfs(i+1 ,dept+1);
        }
    }
}