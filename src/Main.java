import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public int f(int[] arr, int n1, int[] ans){

        if (n1 == 1) {
            return arr[1];
        }else if (n1 == 2){
            if(ans[2] > 0){
                return ans[2];
            }else {
                ans[2] =  arr[1]*2 > arr[2] ? arr[1]*2 : arr[2];
                return ans[2];
            }
        }
        if(ans[n1] >0){
            return ans[n1];
        }

        for(int i=n1; i>1; i--){
            int tmp = i/2;
            if(i%2!=0){
                tmp++;
            }
            int max = arr[i];

            for (int j = i-1; j >= tmp; j--) {
                int tmp2 = f(arr, j,  ans) + f(arr, i-j,  ans);
                if (max < tmp2) {
                    max = tmp2;
                }
            }
            ans[i] = max;
        }
        return ans[n1];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int[] arr = new int[n1+2];
        int[] ans = new int[n1+2];

        String s = br.readLine();
        Main main = new Main();

        StringTokenizer st = new StringTokenizer(s);

        for(int i=1; i<=n1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.f(arr,n1, ans));
    }
}