import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N]; // 원본 배열
        int[] sorted = new int[N]; // 정렬 배열

        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            sorted[i] = X[i]; // 원본 배열 복사본 생성
        }

        Arrays.sort(sorted); // 복사본 정렬

        int idx = 0; // 좌표(count)
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(sorted[i])){ // map에 복사본 요소가 있지 않으면
                map.put(sorted[i],idx++); // 새롭게 요소 추가 (정렬되어있기 때문에 작은 순서대로 0부터 커지면서 value 값 추가됨)
            }
        }

        // 원본 배열 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(X[i])).append(" "); // 원본 배열을 key 값으로 map에 해당하는 value 조회
        }
        System.out.println(sb);

    }
}
