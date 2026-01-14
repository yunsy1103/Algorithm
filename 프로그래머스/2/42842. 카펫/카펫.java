class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
   
        for(int i=3;i<brown+yellow;i++){ // 3부터 시작해야 타일 구조 가능(갈-노-갈)
            int width = (brown+yellow)/i; 
            if(width>=i){
                 if ((i - 2) * (width - 2) == yellow) {
                     answer[0] = width;
                     answer[1] = i;
                    break;
                }
            }
            
        }
    
        return answer;
    }
}