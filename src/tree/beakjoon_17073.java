package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class beakjoon_17073 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<=N; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            nodes.get(U).add(V);
            nodes.get(V).add(U);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        double leafNodeCount = 0.0;
        while(!queue.isEmpty()){
            int removeValue = queue.remove();
            int count = 0;
            for(int temp: nodes.get(removeValue)){
                if(!visited[temp]){
                    count++;
                    queue.offer(temp);
                    visited[temp] = true;
                }
            }
            if(count == 0) leafNodeCount++;
        }
        System.out.println(W/leafNodeCount);
    }
}
