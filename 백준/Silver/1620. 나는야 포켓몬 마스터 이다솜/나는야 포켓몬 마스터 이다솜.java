
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());

        Map<Integer,String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i=0;i<N;i++){
            String pokemon =br.readLine();
            map.put(i+1,pokemon);
            map2.put(pokemon,i+1);
        }

        for(int i=0;i<M;i++){
            String input = br.readLine();
            if (input.matches("\\d+")) {
                int num = Integer.parseInt(input);
                System.out.println(map.get(num));
            }
            else{
                System.out.println(map2.get(input));
            }

        }


    }
}
