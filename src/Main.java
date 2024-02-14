import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {


        int n = read();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = read();
            }
        }
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<arr.length; i++){

            sb.append(solveYear(arr[i][0], arr[i][1], arr[i][2], arr[i][3])).append("\n");
        }
        System.out.println(sb);
    }
    static int solveYear(int n , int m, int x, int y){
        int i = 0;
        int lcm = n*m/gcd(m,n);
        int year = n*i+x;
        while(year <= lcm){
            int mod = year%m;
            if(mod == 0){
                mod = m;
            }
            if(mod==y){
                return year;
            }
            i++;
            year = n*i+x;
        }
        return -1;
    }

    static int gcd(int a, int b){
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        int mod = a%b;
        if (mod != 0){
            return gcd(b,mod);
        } else {
            return b;
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
