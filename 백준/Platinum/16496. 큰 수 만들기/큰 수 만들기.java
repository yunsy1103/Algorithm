import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N =Integer.parseInt(br.readLine());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        String[] arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = String.valueOf(num[i]);
        }

        Arrays.sort(arr,(a,b)->{
            return (b+a).compareTo(a+b);
        });

        if(arr[0].equals("0")){
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(String x:arr){
            sb.append(x);
        }

        System.out.println(sb);

    }
}
