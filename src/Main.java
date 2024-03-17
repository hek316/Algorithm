import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s =br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        arr = new int[n];
        result = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(m, 0);
        System.out.println(sb);
    }

    static private void dfs(int m, int idx){
        if( m == idx ){
            for(int i=0; i<m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int last = 0;
        for(int i= 0; i< arr.length; i++){

            if(visit[i] == false){
                if(last == arr[i]){
                    continue;
                }
                visit[i] = true;
                result[idx] = arr[i];
                last = result[idx] ;
                dfs(m,idx+1);
                visit[i] = false;
            }

        }
    }
}
