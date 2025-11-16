import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (a, b) -> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0]; // 시작하는 시간 기준 오름차순으로 정렬
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(time[0][1]);

        for(int i=1;i<N;i++){
            if(pq.peek()<=time[i][0]){
                pq.poll();
            }
            pq.add(time[i][1]);
        }

        System.out.println(pq.size());

        
    }
}
