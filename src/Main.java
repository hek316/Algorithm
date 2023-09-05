import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[][] arr = new int[n][n];

        arr[0][0] = readInt();

        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if (j == 0){
                    arr[i][j] = arr[i-1][j] + readInt();
                } else if (j==i){
                    arr[i][j] = arr[i-1][j-1] + readInt();
                } else {
                    arr[i][j] = Math.max(arr[i-1][j-1],arr[i-1][j]) +  readInt();
                }
            }
        }

        int max = arr[n-1][0];
        for(int i=1; i<n; i++){
            if (arr[n-1][i] > max){
                max = arr[n-1][i] ;
            }
        }
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
