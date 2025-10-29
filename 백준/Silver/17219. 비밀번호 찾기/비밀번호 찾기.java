import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        String[] answer = new String[M];
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            map.put(site, pw);
        }

        // 찾고 싶은 사이트 이름으로 바로 비밀번호 출력
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            System.out.println(map.get(query));  // HashMap이 내부에서 key 비교 수행
        }
    }
}
