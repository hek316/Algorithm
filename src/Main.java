import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Edge{
    int from, to;

    Edge(int from, int to){
        this.from = from;
        this.to = to;
    }

}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //인접행렬
        boolean[][] a = new boolean[n][n];
        //인접리스트
        ArrayList<Integer> g[] = (ArrayList<Integer>[]) new ArrayList[n];
        // 간선리스트
        ArrayList<Edge> edges = new ArrayList<Edge>();

        for(int i=0; i<n; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            a[from][to] = a[to][from] = true;
            g[from].add(to);
            g[to].add(from);
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
        }

        m *= 2;

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                // A - > B
                int A = edges.get(i).from;
                int B = edges.get(i).to;

                // C - > D
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if(A == B || A == C || A == D || B == C || B == D || C == D ){
                    continue;
                }

                if(a[B][C] == false){
                    continue;
                }
                // D - > E
                for(int E : g[D]){
                    if(A == E || B == E || C == E || D == E){
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}