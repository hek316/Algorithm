import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MIN;
    static int[][] arr;

    static int[] result;

    static int[] result2;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = new int[N];
        result2 = new int[N];
        MIN = Integer.MAX_VALUE;

        for(int i=0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0번째팀을 가진 경우만 비교해보아도 모든 경우의 수 파악가능
        result[0] = 0;
        go(1,1);
        System.out.println(MIN);

    }

    public static void go(int idx, int start){
        if(idx == N/2){

            boolean[] resultTmp = new boolean[N];
            for(int i=0; i<N/2; i++){
                resultTmp[result[i]] = true;
            }
            int j =0;
            for(int i=0; i<N; i++){
                if(resultTmp[i] == false){
                    result2[j] = i;
                    j++;
                }
            }
            int sum1 = solveLevel1(result, 0);
            int sum2 = solveLevel1(result2, 0);
            int tmp = Math.abs(sum2- sum1);
            MIN = Math.min(MIN, tmp);
            return;
        }

        for(int i=start; i<N; i++){
            result[idx] = i;

            go(idx+1,  i+1);
        }
    }

    public static int solveLevel1(int[] result2, int sum){

        for(int i=0; i<N/2; i++){
            for(int j=i+1; j<N/2; j++){
                sum= sum + arr[result2[i]][result2[j]] + arr[result2[j]][result2[i]] ;
            }
        }
        return sum;
    }

}