import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
                if(ch == '(') {
                    stack.push(ch);
                }
                else{
                    if(stack.empty()) {
                        stack.push(ch);
                        break;
                    }else {
                        stack.pop();
                    }

                }
            }
            if(stack.isEmpty()) {
               return true;
            }
            else {
                return false;
            }
        
    }
}