import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        result = new int[n];
        visit = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<=n; i++){
            visit[i] = true;
        }

        String s  = nextArr(arr, n);
        System.out.println(s);
    }

    static private String nextArr(int[] arr, int n){
        int result = -1;
        int tmp = arr[n-1];
        visit[arr[n-1]] = false;
        for(int i=n-2; i>=0; i--){
            visit[arr[i]] = false;
            if(tmp < arr[i]){
                tmp = arr[i];
            }else {
                if(arr[i] !=n){
                    int k = arr[i] +1;
                    while(k <= n){
                        if(visit[k] == false){
                            arr[i] = k;
                            visit[k] = true;
                            break;
                        }
                        k++;
                    }
                }
                result = i;
                break;
            }
        }
        if(result != -1){
            for(int i=result+1; i<=n-1; i++){
                for(int j=1; j<=n; j++){
                    if(visit[j] == false){
                        arr[i] = j;
                        visit[j] = true;
                        i++;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(result != -1){
            for(int i=0; i<= arr.length-1; i++){
                sb.append(arr[i]).append(" ");
            }
        } else {
            sb.append("-1");
        }

        return sb.toString();
    }
}
