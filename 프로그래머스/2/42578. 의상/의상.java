import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            String type = c[1]; 
            map.put(type,map.getOrDefault(type,0)+1); // type이 이미 있으면 그 값 가져오고, 없으면 0 리턴 +1
        }
        
    
        for(int count : map.values()){
            answer *= (count+1);
        }
        return answer-1;
    
    }
}