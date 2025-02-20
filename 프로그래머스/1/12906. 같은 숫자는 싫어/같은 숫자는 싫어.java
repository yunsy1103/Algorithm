import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (stack.isEmpty() || num != stack.peek()) {
                stack.push(num);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
    

        return result;
    }
}