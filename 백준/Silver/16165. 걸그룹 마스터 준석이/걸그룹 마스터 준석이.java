
// map은 key값이 같을 경우 마지막 값으로 덮어쓰므로 같은키에 여러 값 저장 불가 => team, memeber map 분리 필요
// HashMap -> 자동 정렬 안되므로 사전순 나열을 위해 정렬 필요
// map.containValue / containsKey 는 답이 boolean이므로 String을 출력하고 싶다면 get으로 value값만 출력할 수 있음
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> teammap = new HashMap<>();
        HashMap<String, String> membermap = new HashMap<>();

        for(int i=0;i<N;i++){
            String team = br.readLine();
            int num = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            for(int j=0;j<num;j++) {
                String name = br.readLine();
                members.add(name);
                membermap.put(name,team); // 멤버 이름으로 찾을때 팀이 나와야하므로 key,value 순서 유의
            }

            Collections.sort(members); // 멤버 이름 사전순 정렬
            teammap.put(team,members); // teammap에 멤버이름 목록 리스트 값으로 저장 -> 하나 팀에 여러멤버 저장하기 위함
        }

        for(int i=0;i<M;i++){
            String quiz = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if(type==0){
                List<String> members = teammap.get(quiz);
                for(String mem : members){
                    System.out.println(mem);
                } // members 리스트에서 값 출력
            }else if(type==1){
                System.out.println(membermap.get(quiz));
            }
        }

    }
}
