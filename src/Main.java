import java.io.*;
class Node{
    int left, right;
    Node(int left, int right){
        this.left = left;
        this.right = right;
    }
}

public class Main{

    static StringBuilder sb = new StringBuilder();
    static void preOrder(Node[] a, int x){
        if( x == -1) return;
        sb.append((char)(x+'A'));
        preOrder(a, a[x].left);
        preOrder(a, a[x].right);
    }

    static void inOrder(Node[] a, int x){
        if( x == -1) return;
        inOrder(a, a[x].left);
        sb.append((char)(x+'A'));
        inOrder(a, a[x].right);
    }

    static void postOrder(Node[] a, int x){
        if( x == -1) return;
        postOrder(a, a[x].left);
        postOrder(a, a[x].right);
        sb.append((char)(x+'A'));
    }


    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] node = new Node[26];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            int idx = str.charAt(0) -'A';
            char s = str.charAt(2);
            int left = -1;
            if(s != '.'){
                left = s - 'A';
            }
            s = str.charAt(4);
            int right = -1;
            if(s != '.'){
                right = s - 'A';
            }

            node[idx] = new Node(left, right);

        }

        preOrder(node, 0);
        sb.append("\n");
        inOrder(node, 0);
        sb.append("\n");
        postOrder(node, 0);
        System.out.println(sb);
    }


}