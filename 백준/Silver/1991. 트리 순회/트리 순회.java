import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0)-'A';
            int childX = st.nextToken().charAt(0)-'A';
            int childY = st.nextToken().charAt(0)-'A';
            tree[parent][0] = (childX == -19) ? -1 : childX;
            tree[parent][1] = (childY == -19) ? -1 : childY;
        }

        preorder(0);
        sb.append('\n');
        inorder(0);
        sb.append('\n');
        postorder(0);
        System.out.println(sb.toString());

    }

    static void preorder(int node){
        if(node==-1){
            return;
        }
        sb.append((char)(node+'A'));
        preorder(tree[node][0]);
        preorder(tree[node][1]);

    }
    static void inorder(int node){
        if(node==-1){
            return;
        }
        inorder(tree[node][0]);
        sb.append((char)(node+'A'));
        inorder(tree[node][1]);

    }
    static void postorder(int node){
        if(node==-1){
            return;
        }
        postorder(tree[node][0]);
        postorder(tree[node][1]);
        sb.append((char)(node+'A'));

    }
}
