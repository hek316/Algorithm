import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];
        int[] dr = new int[n];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int max= arr[0];

        for (int i = 0; i < n; i++) {
            d[i] =arr[i];
            if (i == 0) {
                continue;
            }
            if (d[i-1] > 0) {
                d[i] =d[i-1]+ arr[i];
            }

            max = Math.max(max,d[i]);
        }
        for (int i = n-1; i > 0; i--) {
            dr[i] =arr[i];
            if (i == n-1) {
                continue;
            }
            if (dr[i+1] > 0) {
                dr[i] =dr[i+1]+ arr[i];
            }
        }

        int tmp = 0;
        for (int i = 1; i < n-1; i++) {
            if (arr[i] < 0) {
                tmp = d[i-1]+ dr[i+1];
            }
            max = Math.max(max, tmp);
        }

        System.out.println(max);
    }

}
