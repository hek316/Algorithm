import java.io.*;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] arr = new int[n];
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans[0] = arr[0];
        int max = ans[0];;

        for(int i=1; i< n; i++){
            if(ans[i-1] < 0){
                ans[i] = arr[i];
            }else{
                ans[i] = ans[i-1] + arr[i];
            }
            if(max < ans[i]){
                max = ans[i];
            }
        }
        System.out.println(max);

    }
}