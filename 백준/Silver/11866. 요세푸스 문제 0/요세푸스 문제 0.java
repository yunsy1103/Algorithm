import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=N;i++){
            queue.add(i);
        }
        System.out.print("<");

        while (!queue.isEmpty()){
            for(int i=0;i<K-1;i++){
                queue.add(queue.poll()); // K-1개 인덱스 제거 후 새로 추가
            }

            System.out.print(queue.poll());   // K번째 출력
            if(!queue.isEmpty()) {   // 마지막에 ,가 들어가면 안됨
                System.out.print(", ");
            }
        }
        System.out.print(">");

    }

}
