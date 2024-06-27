import java.io.*;
import java.util.*;;

class Node{
    int to, cost;
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}

class Pair{
    int dismeter, height;
    public Pair(int dismeter, int height){
        this.dismeter = dismeter;
        this.height = height;
    }
}

public class Main{
    static ArrayList<Node>[] arr ;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true){
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                arr[u].add(new Node(v,dist));
            }
        }

        Pair ans = dfs(1,-1);
        System.out.println(ans.dismeter);

    }

    static Pair dfs(int x, int pre){
        ArrayList<Integer> heights = new ArrayList<Integer>();
        int ans =0;
        for(Node y : arr[x]){
            if(y.to == pre){
                continue;
            }
            Pair p = dfs(y.to, x);
            if(ans < p.dismeter) ans = p.dismeter;
            heights.add(y.cost + p.height);
        }
        int maxChild = 0;
        Collections.sort(heights, Collections.reverseOrder());
        if(heights.size() >= 1){
            maxChild = heights.get(0);
            if(ans < maxChild){
                ans = maxChild;
            }
        }
        if(heights.size() >= 2){
            int tmp = heights.get(0) + heights.get(1);
            if(ans < tmp){
                ans = tmp;
            }
        }
        return new Pair(ans, maxChild);

    }
}