import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        int j= 0;
        StringBuilder sb = new StringBuilder();
        if(charArray.length%3 == 2){
            int n1 = (charArray[0]-'0') * 2;
            int n2 = (charArray[1]-'0') * 1;
            j= 2;
            sb.append(n1 +n2);
        } else if (charArray.length%3 == 1) {
            int n1 = (charArray[0]-'0') * 1;
            j= 1;
            sb.append(n1);
        }

        for (int i=j; i < charArray.length; i+=3) {
            int n1 = (charArray[i]-'0') * 4;
            int n2 = (charArray[i+1]-'0') * 2;
            int n3 = (charArray[i+2]-'0') * 1;
            sb.append(n1+ n2+ n3);
        }


        System.out.println(sb);
    }
}