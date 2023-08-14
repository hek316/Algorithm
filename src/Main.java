import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] k =  new int[n];
        int max  = 0;

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            k[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, k[i]);
        }
        long[] arr = new long[max+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int j=4; j<= max; j++) {
            arr[j] = (arr[j-1] + arr[j-2] + arr[j-3])%1000000009;
        }
        for (int i=0; i<n; i++) sb.append(arr[k[i]]).append("\n");
        System.out.println(sb);

    }
}
