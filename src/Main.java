import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static class Emotion{
        int screen;
        int clipboard;
        int cnt;
        public Emotion(int screen, int clipboard, int cnt){
            this.screen = screen;
            this.clipboard = clipboard;
            this.cnt = cnt;
        }
    }

    static int goal;
    static int MAX = 1001;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        goal = Integer.parseInt(st.nextToken());
        visit = new boolean[MAX][MAX];

        Queue<Emotion> queue = new LinkedList<Emotion>();

        queue.add(new Emotion(1,0,0));
        visit[1][0] = true;

        while (!queue.isEmpty()){
            // s : 화면의 이모티콘 수
            // c : 클립복드의 이모티콘 수
            Emotion cur = queue.remove();
            int screen = cur.screen;
            // copy
            if(screen < MAX && visit[screen][screen] == false){
                visit[screen][screen] = true;
                if (screen == goal) {
                    System.out.println(cur.cnt + 1);
                    return;
                }
                queue.add(new Emotion(screen,screen,cur.cnt+ 1));
            }

            screen = cur.screen + cur.clipboard;
            // paste
            if(screen < MAX && visit[screen][cur.clipboard] == false){
                visit[screen][cur.clipboard] = true;
                if (screen == goal) {
                    System.out.println(cur.cnt + 1);
                    return;
                }
                queue.add(new Emotion(screen, cur.clipboard, cur.cnt + 1));
            }

            screen = cur.screen - 1;
            // minus
            if(screen > 0 && visit[screen][cur.clipboard] == false){
                visit[screen][cur.clipboard] = true;
                if (screen == goal) {
                    System.out.println(cur.cnt + 1);
                    return;
                }
                queue.add(new Emotion(screen, cur.clipboard, cur.cnt + 1));
            }
        }

    }
}