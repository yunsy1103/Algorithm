import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1); // map은 type이 몇개인지 개수세기용으로 사용
            }
            int result = 1;
            for (int v : map.values()) {
                result*=(v+1);
            }
            result-=1;
            System.out.println(result);
        }

    }
}

