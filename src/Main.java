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
        arr = new int[N];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs( int dept){
        if(M == dept){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int preIndex = dept-1;
        if(preIndex < 0){
            preIndex = 0;
        }
        for(int i=arr[preIndex]; i<N; i++){
            arr[dept] = i+1;
            dfs(dept+1);
        }
    }
}