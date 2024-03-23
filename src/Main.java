import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        arr = new int[n];
        visit = new boolean[n+1];
        nextArr(0, n);
        System.out.println(sb);
    }

    static private void nextArr(int idx, int n){
        if(idx == n){
            for(int i=0; i<n; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            if(visit[i] == false){
                arr[idx] = i;
                visit[i] = true;
                nextArr(idx+1, n);
                visit[i] = false;
            }
        }
    }
}
