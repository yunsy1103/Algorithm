import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String upperN = N.toUpperCase();

        Set<Character> upper = new HashSet<>();
        for(int i=0;i<upperN.length();i++){
            char s = upperN.charAt(i);
            upper.add(s);
        }

        int[] count = new int[26];
        for(int i=0;i<upperN.length();i++){
            char s = upperN.charAt(i);
            if(upper.contains(s)){
                count[s-'A']++;
            }
        }

        int max = 0;
        char result = '?';
        for (int i = 0; i < count.length; i++) {
            if(count[i]>max){
                max = count[i];
                result = (char)(i+'A');
            }
            else if(count[i]==max){
                result='?';
            }
        }
        System.out.println(result);
    }
}
