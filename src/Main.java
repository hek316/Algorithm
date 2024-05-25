import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;

    static int MAX;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int nm = N*M;

        arr = new int[N][M];

        int k = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i< (1 << nm ); i++){
            // 0 : - ,  1 : |
            int sum = 0;
            for(int j=0; j<N; j++){
                int cur = 0;
                for (int m = 0; m < M; m++) {
                    int tmp = j*M + m;
                    if((i & (1 << tmp)) == 0){
                        cur = cur*10 + arr[j][m];
                    } else {
                        sum+= cur;
                        cur = 0;
                    }
                }
                sum+= cur;
            }



            for (int m = 0; m < M; m++) {
                int cur = 0;
                for(int j=0; j<N; j++){
                    int tmp = j*M + m;
                    if((i & (1 << tmp)) != 0){
                        cur = cur*10 + arr[j][m];
                    } else {
                        sum+= cur;
                        cur = 0;
                    }
                }
                sum+= cur;
            }

            MAX = Math.max(MAX, sum);
        }

        System.out.println(MAX);

    }

}