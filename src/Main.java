import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] st = new String[word.length()];
        for(int i= 0; i < word.length(); i++) {
            st[i]  = word.substring(i);
        }

        Arrays.sort(st);

        StringBuilder sb = new StringBuilder();



        for(int i= 0; i < word.length(); i++) {
            sb.append(st[i]).append("\n");
        }
        System.out.println(sb);
    }
}