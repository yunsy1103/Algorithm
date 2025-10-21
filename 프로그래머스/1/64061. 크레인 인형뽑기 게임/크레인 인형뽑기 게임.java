import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int m : moves) {
            int j=m-1;
            for(int i=0;i<board.length;i++){
                if(board[i][j]!=0){
                    int doll = board[i][j];
                    board[i][j]=0;
                    // 같은 거면 제거 + 점수, push 안 함
                    if (!stack.isEmpty() && stack.peek() == doll){ //peek는 stack이 empty이면 에러나므로 empty인지 확인 필요 
                        stack.pop();
                        answer+=2;
                    }
                    // 다르면 쌓기
                    else{
                         stack.push(doll);
                    }
                    // 이번 move 종료 -> 한개만 선택하므로
                    break;
                }
               
            }

        }
        return answer;
    }
}