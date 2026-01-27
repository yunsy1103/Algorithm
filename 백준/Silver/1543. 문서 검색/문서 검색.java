import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        String answer = br.readLine();
        int startIndex =0;
        int count=0;

        while(true){
            int foundIndex = sentence.indexOf(answer, startIndex); // sentecne 문자열에서 startIndex 이후부터 answer를 찾아서 인덱스(위치) 저장
            if(foundIndex==-1){ // 더 이상 answer이 없다면
                break;
            }
            count++;
            startIndex = foundIndex+answer.length();

        }

        System.out.println(count);


    }
}
