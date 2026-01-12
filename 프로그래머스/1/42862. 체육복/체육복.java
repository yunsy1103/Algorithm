import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Set<Integer> lostset = new HashSet<>();
        for (int l : lost) lostset.add(l);
        
        Set<Integer> reserveset = new HashSet<>();
        for (int r : reserve) reserveset.add(r);
    
        Set<Integer> common = new HashSet<>(reserveset);
        common.retainAll(lostset);

        reserveset.removeAll(common);
        lostset.removeAll(common);
        
        int answer = n - lostset.size();
       
        for (int l : lostset){
            if (reserveset.contains(l - 1)){
                reserveset.remove(l-1);
                answer++;
            }
            else if(reserveset.contains(l+1)){
                reserveset.remove(l+1); 
                answer++;
            }
        }
        
        
        return answer;
    }
}