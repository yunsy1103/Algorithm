/*문제 풀이
1.pq를 쓰는 이유
- 현재 진행 중인 강의실들의 종료 시간만 저장하기 위해 사용
- pq.peek()은 가장 빨리 끝나는 강의실의 종료 시간을 의미
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] room = new int[N][2];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room, (a, b) -> {
            if(a[0]==b[0]){ // 같을 경우, 시작하는 시간 기준으로 정렬
                return a[1]-b[1];
            }
            return a[0]-b[0]; // 시작하는 시간 기준 오름차순으로 정렬
        });


        pq.add(room[0][1]); // 종료 시간 기준점 

        for (int i = 1; i < N; i++) {
            if(pq.peek()<=room[i][0]){
                pq.poll(); // 기존 강의실 재사용가능하여 삭제
            }
            pq.add(room[i][1]); // 겹치지 않는 경우 pq에 새로 추가
        }

        System.out.println(pq.size()); // 현재 점유 중인 강의실의 종료시간


    }
}
