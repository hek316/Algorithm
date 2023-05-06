import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] s = input.split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int lcd = 0;
        int max = 0;

        if (a > b) {
            max = a;
        } else {
            max = b;
        }

        for (int i=max; i > 0 ; i--) {
            if (a%i == 0 && b%i == 0){
                lcd = i;
                break;
            }

        }


        StringBuilder sb = new StringBuilder();
        sb.append(lcd).append("\n");
        sb.append(a*b/lcd).append("\n");


        System.out.println(sb);
    }
}