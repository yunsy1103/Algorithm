import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        char[] s= new char[N.length()];
        for(int i=0;i<N.length();i++){
            s[i]= N.charAt(i);
        }
        Arrays.sort(s);

        for(int i=N.length()-1;i>=0;i--){
            System.out.print(s[i]);
        }

    }
}
