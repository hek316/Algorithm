import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int MIN;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        MIN = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i< (1<<N) ; i++){
            int cnt = 0;

            for(int j=0; j<N; j++){
                if((i&(1<<j)) != 0){
                    cnt++;
                }
            }
            if(cnt == N/2){
                int idx = 0;
                int[] result = new int[N/2];
                int[] result2 = new int[N/2];
                for(int j=0; j<N; j++){
                    if((i&(1<<j)) != 0){
                        result[idx] = j;
                        idx++;
                    }
                }
                idx = 0;
                for(int j=0; j<N; j++){
                    if((i&(1<<j)) == 0){
                        result2[idx] = j;
                        idx++;
                    }
                }
                int sum1 = solve(result);
                int sum2 = solve(result2);
                int tmp = Math.abs(sum2-sum1);
                MIN = Math.min(tmp, MIN);

            }
        }
        System.out.println(MIN);

    }

    public static int solve(int[] result){
        int sum = 0;
        for(int i=0; i<result.length; i++){
            for(int j=i+1; j< result.length; j++){
                int i2 = result[i];
                int j2 = result[j];
                sum = sum + arr[i2][j2] + arr[j2][i2];
            }
        }
        return sum;
    }
}