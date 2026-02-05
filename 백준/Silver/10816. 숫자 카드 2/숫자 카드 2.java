import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
// 중복 된 것 키-값 형식 저장할 때는 HashMap 사용 (중복 저장 안함, 중복된 값 개수 세기 용이)

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N =Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0) + 1);   // 카드 하나 읽을 때마다 개수 갱신
        }

        int M =Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int y = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(y, 0)).append(" ");
        }


        System.out.println(sb.toString());

    }
}

