import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        int n =readInt();
        int[][] cnt = new int[3][n];
        for(int i=0; i<n; i++){
            cnt[1][i] = readInt();
        }


        int max = 0;

        for(int i=1; i<n; i++){
            max = Math.max(Math.max(cnt[0][i-1],cnt[1][i-1]),cnt[2][i-1]);
            cnt[0][i] = max ;
            int tmp = cnt[1][i];
            cnt[1][i] = cnt[0][i-1] + tmp ;
            cnt[2][i] = cnt[1][i-1] + tmp ;
        }

        max = Math.max(Math.max(cnt[0][n-1],cnt[1][n-1]),cnt[2][n-1]);
        System.out.println(max);
    }

    static int readInt() throws IOException {
        int sum = 0;
        boolean isNegative = false;
        while(true){
            int input = System.in.read();
            if(input=='\n' || input==' ')
                return isNegative ? sum*-1 : sum;
            else if(input=='-')
                isNegative = true;
            else
                sum = (sum*10)+input-'0';
        }
    }
}
