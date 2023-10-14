import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {

        int n = 9;
        int[] arr = new int[9];
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);


        Loop1 :
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (sum- arr[i] - arr[j] == 100) {
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j){
                            continue;
                        }
                        System.out.println(arr[k]);
                    }
                    break Loop1;
                }
            }
        }



    }

}
