// 가장 많이 팔린 책(빈도)를 탐색해야하므로 <key,value> 구조의 Map 자료구조 사용
// -> key 값에 따름 value값 세서 저장 가능

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String s = br.readLine();
            map.put(s, map.getOrDefault(s,0)+1);
        }


        // value가 가장 큰 값 찾아서 key 반환
        int max =0;
        String answer ="";
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String title = entry.getKey();
            int count = entry.getValue();

            if(count>max){  // 가장 큰 count 값 찾기
                max=count;
                answer = title; // 가장 큰 count(value)의 title(key) 저장
            }
            else if (count == max) { // 가장 큰 count 값이 여러개일 경우
                if (title.compareTo(answer) < 0) {  // 문자열 사전순 비교 -> title이 answer보다 사전순으로 앞서면 answer를 title로 바꾼다. (title이 더 앞서는 문자열이면 정답으로 채택)
                    answer = title;
                }
            }
        }
        System.out.println(answer);

    }

}
