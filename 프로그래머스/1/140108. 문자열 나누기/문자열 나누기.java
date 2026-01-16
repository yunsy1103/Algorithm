import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        int start = 0; // 현재 문자열 시작 인덱스 -> 시간초과 방지
        while (start < n) { 
            int same =0;
            int diff=0;
            char x = s.charAt(start);
            for(int i=start;i<n;i++){
                if(x == s.charAt(i)){
                    same++;
                } else{ diff++; }
                if(same==diff){
                    answer++;
                    start = i + 1;  // 다음 문자열로 넘어가기 
                    break;
                }
                if (i == n - 1) {
                     answer++;
                     start = n; // 인덱스가 끝까지 가면 끝
                }
            }  
        }  
        return answer;
    }
}