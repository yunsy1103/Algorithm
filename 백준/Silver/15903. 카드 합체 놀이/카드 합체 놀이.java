/*
문제 접근
1.pq 사용한 이유: 최소를 사용해서 최솟값을 구하려면 입력값에서 최솟값 2개를 찾아야한다 생각함, 그래서 우선순위 큐 떠올림
-> poll()해서 작은 것 찾고, 그다음으로 작은것 찾기
-> 새로운 sum pq에 2번 넣어 a, b sum으로 대체
-> pq의 값 다 더하기 위해선 반복문으로 pq.size()만큼 poll()해서 더하기
2.pq 자료형 long : 카드 합이 더해지면서 최종 값이 integer보다 커질 수 있기 때문
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();


        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

   
        for(int i=0;i<m;i++){
            long a = pq.poll(); // 가장 작은 묶음
            long b = pq.poll(); // 그다음 작은 묶음
            long sum = a+b;
            pq.add(sum); // a가 sum으로 바뀜
            pq.add(sum); // b가 sum으로 바뀜
        }
        
        long total=0;
        while (!pq.isEmpty()) {
            total += pq.poll(); // poll()은 가장 작은 값부터 꺼냄 (min-heap)
        }
        
        System.out.println(total);
        

    }
}
