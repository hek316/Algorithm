import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int num = 0;
        for (int i=0; i < n; i++) {
            int i1 = Integer.parseInt(s[i]);
            boolean isNaturalNumber = false;
            for(int j=2; j < i1; j++){
                if(i1%j == 0){
                    isNaturalNumber = true;
                    break;
                }
            }
            if (i1 != 1 && !isNaturalNumber) {
                num++;
            }
        }

        System.out.println(num);
    }
}