import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String word = br.readLine();
                String[] st = new String[word.length()];
                for(int i= 0; i < word.length(); i++) {
                    st[i]  = word.substring(i);
                }

                for(int i= 0; i < word.length(); i++) {
                  for (int j= i +1; j < word.length(); j++) {
                       int k = 0;
                      while(k < st[i].length() && k < st[j].length()) {
                          char a = st[i].charAt(k); char b = st[j].charAt(k);
                          if ( a> b) {
                              String s = st[i];
                              st[i] = st[j];
                              st[j] = s;

                              break;
                          } else if (st[i].charAt(k) == st[j].charAt(k)) {
                              k++;
                              if (k == st[j].length()) {
                                  String s = st[i];
                                  st[i] = st[j];
                                  st[j] = s;
                              }
                         } else {
                              break;
                          }
                      }
                  }
                }
                for(int i= 0; i < word.length(); i++) {
                    System.out.println(st[i]);
                }
    }
}