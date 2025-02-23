import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
    
        for(int i=0;i<scoville.length;i++){
            queue.add(scoville[i]);
        }
        
        while( queue.peek() < K){
            if (queue.size()<=1) {
                return -1;
            }
            int n1 = queue.poll();
            int n2 = queue.poll();
            int s = n1+(n2*2);
            queue.add(s);
            answer++;
            
        }
        
        
        
        
        
        return answer;
    }
}