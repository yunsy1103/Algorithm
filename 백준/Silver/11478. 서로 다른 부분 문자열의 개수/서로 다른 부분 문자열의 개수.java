import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<S.length();i++){
            for(int j=i+1;j<=S.length();j++){
                set.add(S.substring(i, j)); // substring으로 i부터 j-1까지 자름
            }
        }

        System.out.println(set.size());
        

    }
}
