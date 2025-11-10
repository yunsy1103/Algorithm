import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        // 가장 최솟 합 구하기 위해 우선순위 큐로 최솟값 탐색
        int total=0;
        while(pq.size()>1){
            int a = pq.poll(); // 가장 작은 묶음
            int b = pq.poll(); // 그다음 작은 묶음
            int sum = a+b;
            total += sum;
            pq.add(sum);
        }

        System.out.println(total);

    }
}
