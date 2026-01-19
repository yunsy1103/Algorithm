import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] c = new int[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            c[i] = Integer.parseInt(br.readLine());
        }

        int next=1;
        for(int i=0;i<n;i++){
            int target = c[i];   
            while (next <= target){  
                stack.push(next);
                next++;
                sb.append("+\n");
            }
            if(stack.peek()!=target){
                System.out.println("NO");
                return;
            }
            else{
                stack.pop();
                sb.append("-\n");
            }
        }

        System.out.print(sb.toString());

    }

}


