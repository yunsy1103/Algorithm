import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();


        for(int i=0;i<N;i++){
            set1.add(br.readLine());
        }
        for(int j = 0; j <M; j++){
            set2.add(br.readLine());
        }

        //교집합 관리할 Set 생성
        Set<String> dup = new HashSet<>(set1);
        dup.retainAll(set2);

        List<String> result = new ArrayList<>(dup);
        //사전 순 정렬
        Collections.sort(result);

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }


    }

}
