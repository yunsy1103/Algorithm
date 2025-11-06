import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for(int i=0;i<N;i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        int count=0;
        for(int i=N-1;i>0;i--){
            if(score[i-1] >= score[i]){
                int newvalue =score[i]-1; // 맨 뒤에것보다 작은 수
                count +=score[i-1]-newvalue; // count에 기존 score[i-1]에서 작은 수 뺀 값만큼 세기
                score[i-1]=newvalue; // 기준치 맨 뒤에것보다 작은 수로 변경
            }

        }

        System.out.println(count);
    }
}
