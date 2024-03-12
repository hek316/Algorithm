import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s =br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        int[] result = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(m, arr, result, 0);
        System.out.println(sb);
    }

    static private void dfs(int m, int[] arr, int[] result, int idx){
        if( m <= idx ){
            for(int i=0; i<m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i= 0; i< arr.length; i++){
            if(check[i]){
                continue;
            }
            result[idx] = arr[i];
            check[i]  = true;
            dfs(m, arr, result, idx+1);
            check[i]  = false;
        }
    }
}
