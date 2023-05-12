import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int[] prime = new int[1000000+1];

        boolean[] isComposition = new boolean[1000000+1];
        for(int i=2; i<= 1000000; i++){
            if (isComposition[i] == true) {
                continue;
            }
            for(int j=2; i*j<= 1000000; j++){
                isComposition[i*j] = true;
            }
        }
        int j =0;
        for(int i=2; i<= 1000000; i++){

            if (isComposition[i] == false) {
                prime[j++] = i;
            }

        }

        while (true){
            int n1 = Integer.parseInt(br.readLine());
            if (n1 == 0){ break;}

            sb.append(n1).append(" = ");
            for (int i = 0; i< n1 ;i++) {
                int n2;
                n2 = n1 - prime[i];
                if(isComposition[n2] == false){
                    sb.append(prime[i]).append(" + ").append(n2).append("\n");
                    break;
                }

            }
        }

        System.out.println(sb);

    }
}