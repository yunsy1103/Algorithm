import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> Heap = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a)== Math.abs(b)) {
                return a - b; // 절댓값이 같으면 실제 값이 작은 순 (음수 우선)
            }
            return Math.abs(a) - Math.abs(b); // 절댓값이 작은 순
        });



        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if (Heap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(Heap.poll()).append("\n");
                }
            }
            else{
                Heap.offer(x);
            }
        }
        System.out.print(sb);
        br.close();
    }
}
