import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                list.add(arr[i]);
            }
        
        }
        if (list.isEmpty()) {
            list.add(-1);
        }
  
        Collections.sort(list);
        
        // list → int 배열 변환
        return list.stream().mapToInt(i->i).toArray(); // 꼭 배열 사용하지 않고 list에 저장하고 배열로 변환하여 사용하는 것이 편함
    }
}