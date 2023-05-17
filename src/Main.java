import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    long countMultiple(int n1, int divNum){
        long cnt = 0;
        /*
         while ( m != 0) {
            cnt = cnt + m ;
            i*=mutiple;
            m= n1/i;
        }
        초기 풀이시 나누는 값을 곱하는 형식으로 풀었는데 해당 식은 overFlow 가 발생한다
        int 의 범위 :
        –2,147,483,648 ~ 2,147,483,647
         */
        while ( n1/divNum != 0) {
            cnt += n1/divNum;
            n1/=divNum;
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String[] a = st.split(" ");
        int n1 = Integer.parseInt(a[0]);
        int n2 = Integer.parseInt(a[1]);
        Main main = new Main();

        final int DIV2 = 2;
        final int DIV5 = 5;
        long cnt2 = main.countMultiple(n1,DIV2) - main.countMultiple(n2, DIV2)  - main.countMultiple((n1 -n2), DIV2);
        long cnt5 = main.countMultiple(n1,DIV5) - main.countMultiple(n2, DIV5)  - main.countMultiple((n1 -n2), DIV5);
        if (cnt2 < cnt5) {
            System.out.println(cnt2);
        } else {
            System.out.println(cnt5);
        }
    }
}