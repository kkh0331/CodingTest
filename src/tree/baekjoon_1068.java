package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1068 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<N; i++){
            nodes.add(new ArrayList<>());
        }
        int head = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n == -1){
                head = i;
                continue;
            }
            nodes.get(n).add(i);
        }
        int removeNode = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        if(head == removeNode){
            System.out.println(0);
            return;
        }
        queue.add(head);
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            int n = nodes.get(node).size();
            if(n == 0){
                count++;
            } else if(n == 1 && nodes.get(node).get(0) == removeNode){
                count++;
            } else {
                for(int temp : nodes.get(node)){
                    if(temp == removeNode) continue;
                    queue.add(temp);
                }
            }
        }
        System.out.println(count);
    }
}
