package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_11725 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> inputs = new ArrayList<>();
        for(int i=0; i<=N; i++){
            inputs.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inputs.get(a).add(b);
            inputs.get(b).add(a);
        }
        boolean visited[] = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int[] res = new int[N+1];
        while(!queue.isEmpty()){
            int remove = queue.remove();
            for(int temp : inputs.get(remove)){
                if(visited[temp]) continue;
                res[temp] = remove;
                visited[temp] = true;
                queue.add(temp);
            }
        }
        for(int i=2; i<=N; i++){
            bw.write(res[i]+"\n");
        }
        bw.close();
    }
}
