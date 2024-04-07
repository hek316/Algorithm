import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int L ;
    static int C ;

    static char[] ARR;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] s1 = input.split(" ");

        L = Integer.parseInt(s1[0]);
        C = Integer.parseInt(s1[1]);

        ARR = new char[C];
        char[] result = new char[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            ARR[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(ARR);
        goPassword(0, result, L, C, 0);

        System.out.println(sb);

    }

    public static void goPassword(int idx, char[] result, int L, int C, int start){
        if(idx >= L){
            int vowelsCnt = containsVowels(result);
            int consonantCount = L - vowelsCnt;
            if(vowelsCnt >= 1 && consonantCount >= 2 ){
                for(char c : result){
                    sb.append(c);
                }
                sb.append("\n");
                return;
            }else {
                return;
            }
        }

        for(int i=start; i<C; i++){
            result[idx] = ARR[i];
            goPassword(idx+1, result, L, C, i+1);
        }
    }

    public static int containsVowels(char[] array) {
        int cnt = 0;
        for (char c : array) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
        }
        return cnt;
    }

}