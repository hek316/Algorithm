import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        int[][] sum = new int[n+1][3];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j =0;
            while(st.hasMoreTokens()){
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        int n1= findMinimumRGB(sum,arr,n,0);
        int n2= findMinimumRGB(sum,arr,n,1);
        int n3= findMinimumRGB(sum,arr,n,2);
        int min = Math.min(n1,n2);
        min = Math.min(min,n3);
        System.out.println(min);
    }

    public static int findMinimumRGB(int[][] sum,int[][] arr, int a, int b){
        if(b==0){
            if (a== 2){
                return sum[a][b]=  (arr[a-1][1] < arr[a-1][2] ? arr[a-1][1] : arr[a-1][2]) + arr[a][b];
            }
            if(sum[a-1][1] > 0 && sum[a-1][2] >0 ){
                return sum[a][b]= (sum[a-1][1] < sum[a-1][2] ? sum[a-1][1] : sum[a-1][2] )+ arr[a][b];
            } else {
                int sum1 = findMinimumRGB(sum, arr,a-1, 1);
                int sum2 = findMinimumRGB(sum, arr,a-1, 2);
                return  sum[a][b]= (sum1 < sum2? sum1 : sum2)+arr[a][b];
            }
        } else if (b==1) {
            if (a== 2){
                return sum[a][b]=  (arr[a-1][0]  < arr[a-1][2] ? arr[a-1][0] : arr[a-1][2]) + arr[a][b];
            }
            if(sum[a-1][0] > 0 && sum[a-1][2] >0 ){
                return sum[a][b]= (sum[a-1][0] < sum[a-1][2] ? sum[a-1][0] : sum[a-1][2]) + arr[a][b];
            } else {
                int sum1 = findMinimumRGB(sum, arr,a-1, 0);
                int sum2 = findMinimumRGB(sum, arr,a-1, 2);
                return sum[a][b]=  (sum1 < sum2? sum1 : sum2)+arr[a][b];
            }
        }else {
            if (a== 2){
                return sum[a][b]=  (arr[a-1][0] <  arr[a-1][1] ? arr[a-1][0] : arr[a-1][1]) + arr[a][b];
            }
            if(sum[a-1][0] > 0 && sum[a-1][1] >0 ){
                return sum[a][b]=(sum[a-1][0] < sum[a-1][1] ? sum[a-1][0] : sum[a-1][1]) + +arr[a][b];
            } else {
                int sum1 = findMinimumRGB(sum, arr,a-1, 0);
                int sum2 = findMinimumRGB(sum, arr,a-1, 1);
                return sum[a][b]= (sum1 < sum2? sum1 : sum2)+arr[a][b];
            }
        }
    }
}
