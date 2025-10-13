import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        int[] answer = {};
        int l,m,n=0;
        
        for(int i=0;i<commands.length;i++){
            l= commands[i][0];
            m= commands[i][1];
            n= commands[i][2];
            
            int[] sliced = Arrays.copyOfRange(array,l-1,m);
            Arrays.sort(sliced);
            list.add(sliced[n-1]);
        }
        answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}