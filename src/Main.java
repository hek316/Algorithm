import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static boolean[] visit;
    static int MAX ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] result = new int[n];
        visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        nextArr(0, n, result, arr);
        System.out.println(MAX);

    }


    public static void nextArr(int dept, int n, int[] result, int[] arr){
        if(dept == n){
            int tmp = 0;
            for(int i=0; i<n-1; i++){
                tmp += Math.abs(result[i + 1] - result[i]);
            }
            if(tmp>MAX){
                MAX = tmp;
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(visit[i] == false){
                visit[i] = true;
                result[dept] = arr[i];
                nextArr(dept+1, n, result, arr);
                visit[i] = false;
            }
        }

    }

}
