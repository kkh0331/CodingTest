package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon_3584 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] parentNodes = new int[N+1];
            for(int i=0; i<N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                parentNodes[child] = parent;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> aParents = new ArrayList<>();
            int current = a;
            aParents.add(a);
            while(true){
                int next = parentNodes[current];
                if(next != 0){
                    aParents.add(next);
                    current = next;
                } else {
                    break;
                }
            }
            TreeSet<Integer> bParents = new TreeSet<>();
            current = b;
            bParents.add(b);
            while(true){
                int next = parentNodes[current];
                if(next != 0){
                    bParents.add(next);
                    current = next;
                } else {
                    break;
                }
            }
            for(int node : aParents) {
                if (bParents.contains(node)) {
                    bw.write(node+"\n");
                    break;
                }
            }
        }
        bw.close();
    }
}
