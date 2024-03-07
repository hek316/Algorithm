import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static char[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        N = s.charAt(0) - '0';
        M = s.charAt(2) - '0';
        arr = new char[2*M];

        dfs(0, 1);
        System.out.println(sb);
    }

    public static void dfs(int dept, int value){
        if(M == dept){
            arr[2*M-1] = '\n';
            sb.append(arr);
            return;
        }

        for(int i=value; i<=N; i++){
            arr[2*dept] = (char)(i +'0');
            arr[2*dept+1]= ' ';
            dfs(dept+1, i);
        }

    }
}