import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
        초기에 조합의 성질을 이용하여 풀려고 했으나 곱하는 수가 점점 커져서 범위를 초과하였음
        그래서 피보나치 수열 성질을 이용하여 풀이 하였음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n/2;

        long cnt = 0;
        for (int i= 0; i <= m; i++) {
            int r  = n - 2*i;;
            long tmp = 1;

            int k = r+i;
            for(int j = r+1; j <= k; j++){
                tmp *= j;
            }
            int ir = k - r;
            for(int j = 1; j <= ir; j++){
                tmp/= j;
            }
            cnt += tmp;
            cnt%=10007;
        }
        System.out.println(cnt);

 */
public class Main {


    public int f(int[] d, int n){
        if (d[n] > 0) {
            return d[n];
        }
        if(n ==1) {
            d[1] = 1;
            return 1;
        }else if(n ==2) {
            d[2] = 2;
            return 2;
        }
        d[n] =  f(d, n-2) + f(d, n-1);
        return d[n]%10007;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        Main main = new Main();
        int f = main.f(d, n);
        System.out.println(f);

    }
}
