import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i < participant.length;i++){
            String part = participant[i];
            map.put(part,map.getOrDefault(part,0)+1);
        }
        for(int i=0;i<completion.length;i++){
            String name = completion[i];
            if(map.containsKey(name)){
                map.put(name,map.get(name)-1); // 참여자랑 완주자가 겹치면 value -1
            }
        }
        for(String key:map.keySet()){
            if(map.get(key)>0){
                return key;
            }
        }
        return ""; // key없으면 빈 것 return
    }
}