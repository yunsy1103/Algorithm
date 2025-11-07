import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>(); // ArrayDeque를 사용하는 것이 메모리 관리에 유리

        for(int i=0;i<N;i++){
           String cmd = br.readLine();
           if(cmd.startsWith("push_front")){
               int a = Integer.parseInt(cmd.split(" ")[1]);
               deque.addFirst(a); // 덱 앞에 삽입
           }
           else if(cmd.startsWith("push_back")){
               int a = Integer.parseInt(cmd.split(" ")[1]);
               deque.addLast(a); // 덱 뒤에 삽입
           }
           else if(cmd.equals("pop_front")){
               System.out.println(deque.isEmpty() ? -1 : deque.pollFirst()); // Deque의 뒤에서 제거, 비어있으면 null 리턴
           }
           else if(cmd.equals("pop_back")){
               System.out.println(deque.isEmpty() ? -1 : deque.pollLast()); // Deque의 앞에서 제거, 비어있으면 null 리턴
           }
           else if(cmd.equals("size")){
               System.out.println(deque.size()); // 덱 크기 확인

           }
           else if(cmd.equals("empty")){
               System.out.println(deque.isEmpty() ? 1 : 0); // 덱 비었을 경우 1, 아니면 0 리턴
           }
           // getFirst() vs peekFirst() -> get은 비어있을 경우 예외 리턴, peek는 비어있을 경우 null 리턴
           else if(cmd.equals("front")){
               System.out.println(deque.isEmpty() ? -1 : deque.peekFirst()); // 첫 번째 엘리먼트를 확인, 비어있으면 null 리턴
           }
           else if(cmd.equals("back")){
               System.out.println(deque.isEmpty() ? -1 : deque.peekLast()); // 마지막 엘리먼트를 확인, 비어있으면 null 리턴
           }


        }
    }
}
