
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

/*
  int[] arr = new int[ n + 1];
        int[] tmp = new int[n*1000];
        int k =0;
        for(int i=1; i<=9;i++){
            arr[1] = i;
            tmp[k++] = i;
            for(int j=2; j<=n;j++){
                if(arr[j-1] != 0){
                    arr[j] = arr[j-1]-1;
                    if(j==n){
                        tmp[k++] = arr[j];

                        System.out.println( "arr[0] :" + Arrays.toString(arr));
                    }

                }

                if(arr[j-1] != 9){
                    arr[j] = arr[j-1]+1;
                    if(j==n){
                        tmp[k++] = arr[j];
                        System.out.println("arr[0] :" + Arrays.toString(arr));
                    }
                }

            }

        }
        System.out.println("tmp:" + Arrays.toString(tmp));
        for(int s= tmp.length-1; s>=0; s--){
            if(tmp[s]!= 0){
                System.out.println(tmp[s]);
                break;
            }
        }
처음에는 마지막 수 배열을 저장하는 방법을 생각했으나 메모리 사이즈가 초과하여
연속이라는 속성에 맞춰 점화식을 생성하여 품
 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 1000000000;

        long[][] arr = new long[101][10];
        for(int i=1; i< 10; i++){
            arr[1][i] = 1;
        }
        for(int j=2; j<=n; j++){
            for(int i=0; i<=9; i++){
                if(i== 0){
                    arr[j][i] = arr[j-1][i+1]%mod;
                } else if (i==9) {
                    arr[j][i] = arr[j-1][i-1]%mod;
                } else {
                    arr[j][i] = arr[j-1][i+1]%mod+ arr[j-1][i-1]%mod;
                }
            }
        }
        long ans = 0;
        for(int k =0; k<=9; k++){
            ans += arr[n][k];
            ans%=mod;
        }
        System.out.println(ans);


    }
}