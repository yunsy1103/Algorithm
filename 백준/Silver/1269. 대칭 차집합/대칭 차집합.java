import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st  = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        st  = new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++){
            set1.add(Integer.parseInt(st.nextToken()));
        }

        st  = new StringTokenizer(br.readLine());
        for(int i=0;i<B;i++){
            set2.add(Integer.parseInt(st.nextToken()));
        }

        int count=0;
        for(int x: set1){ // set 집합 전체를 돌 수 없기 때문에 for로 set집합 내부 탐색 
            if(!set2.contains(x)){
                count++;
            }
        }

        for(int x: set2){
            if(!set1.contains(x)){
                count++;
            }
        }

        System.out.println(count);

    }
}
