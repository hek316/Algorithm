public class Main {

    private static int read() throws Exception {

        int c, N = System.in.read() - 48;
        while ((c = System.in.read()) > 32) N = 10 * N + c - 48;
        return N;

    }

    public static void main(String[] args) throws Exception {

        int  n = read();

        int r = read();
        int g = read();
        int b = read();


        for (int i = 2; i <= n; i++) {
            int r1 = Math.min(g, b);
            int g1 = Math.min(r, b);
            int b1 =  Math.min(r, g);

            r =  r1 + read();
            g =  g1 + read();
            b =  b1 + read();

        }

        int min = Math.min(r, Math.min(g, b));
        System.out.println(min);
    }

}
