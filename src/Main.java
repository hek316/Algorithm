import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        boolean[] isComposition = new boolean[1000000+1];
        for(int i=2; i<= 1000000; i++){
            if (isComposition[i]) {
                continue;
            }
            for(int j=2; i*j<= 1000000; j++){
                isComposition[i*j] = true;
            }
        }

        while (true){
            int n1 = Integer.parseInt(br.readLine());
            if (n1 == 0){ break;}
            for (int i = 2; i< n1 ;i++) {
                if(!isComposition[i] &&  !isComposition[n1 - i]){
                    sb.append(n1).append(" = ").append(i).append(" + ").append(n1 - i).append("\n");
                    break;
                }

            }
        }

        System.out.println(sb);

    }
}