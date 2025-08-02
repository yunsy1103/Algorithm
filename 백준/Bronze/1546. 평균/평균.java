import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double [] grade = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            grade[i] = Integer.parseInt(st.nextToken());
        }

        double max =0;
        for(int i=0;i<N;i++){
            if(grade[i]>max){
                max=grade[i];
            }
        }

        double sum =0;
        for(int i=0;i<N;i++){
           grade[i]= grade[i]/max*100;
           sum += grade[i];
        }

        double avg = sum /N;

        System.out.println(avg);
    }
}
