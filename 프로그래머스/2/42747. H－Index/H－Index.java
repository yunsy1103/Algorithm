import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        
        for(int i=0;i<n;i++){
            int h = n-i; // 현재 인용된 논문 수 
            if(citations[i]>=h){
                answer = h;
                break;
            }
        }
        return answer;
        
    }
}