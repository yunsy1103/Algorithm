import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1,s2)->{
            // 1. n번째 글자 기준으로 먼저 정렬
            if(s1.charAt(n)!=s2.charAt(n)) // 같은 알파벳이 아니면 
                return s1.charAt(n) - s2.charAt(n); // 아스키코드 더 작은게 앞에 정렬되게 
            // 2. n번째 숫자가 같을 때 사전 순 정렬
            return s1.compareTo(s2); 
        });
        return strings;
    }
}