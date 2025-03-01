

class Solution {
    public int solution(int[][] sizes) {
        int maxrow = 0;
        int maxcol = 0;
        
        for(int i=0;i<sizes.length;i++){
            int tmp = sizes[i][0];
            if(sizes[i][0]<sizes[i][1]){
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp ;
            }
            if(maxrow< sizes[i][0]){
                 maxrow = sizes[i][0];
            }
            if(maxcol < sizes[i][1]){
                 maxcol = sizes[i][1];
             }
        }
        
        
        int answer = maxrow * maxcol;
    
        
            
        return answer;
    }
}