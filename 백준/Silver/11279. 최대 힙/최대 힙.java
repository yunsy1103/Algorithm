import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0;i<N;i++){
			int x = Integer.parseInt(br.readLine());
			if(x>0){
				maxHeap.offer(x);
			}else if(x==0){
				if (maxHeap.isEmpty()) {
                    sb.append(0).append("\n"); 
                } else {
                    sb.append(maxHeap.poll()).append("\n");
                }
			}
		}
        System.out.print(sb.toString());
        br.close();
	}
}