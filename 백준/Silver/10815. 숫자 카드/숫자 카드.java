// HashSet을 사용하면 리스트/배열보다 더 빠르게 탐색할 수 있어서 사용
// HashSet -> contains()를 통해 한번에 탐색 가능 => 존재 여부 확인할 때 HashSet 떠올리기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)){
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb.toString());
    }
}
