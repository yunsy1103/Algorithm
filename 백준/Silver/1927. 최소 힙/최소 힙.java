import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙: 값이 작을수록 우선

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x>0){
                minHeap.offer(x);
            }else if(x==0){
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(minHeap.poll()).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}

